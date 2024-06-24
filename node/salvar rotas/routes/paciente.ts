import Router, { Request, Response } from "express"
import knex from "knex"
import AppError from "../../src/utils/AppError"
import { z } from "zod"

const router = Router()

const registerBodySchema = z.object({
    id_endereco: z.number().nonnegative(),
    nome: z.string().min(8, { message: "Nome deve ter no mínimo 8 caracteres" }).max(100, { message: "Nome deve ter no máximo 100 caracteres" }),
    dataNascimento: z.string().max(10, { message: "Data de nascimento deve ter no máximo 10 caracteres" }),
    cpf: z.string().max(11, { message: "CPF deve ter no máximo 11 caracteres" }),
    cns: z.string().max(15, { message: "CNS deve ter no máximo 15 caracteres" }),
    celular: z.string().max(11, { message: "Celular deve ter no máximo 11 caracteres" }),
    email: z.string().email({ message: "Email inválido" }).max(50, { message: "Email deve ter no máximo 50 caracteres" }),
    nomeCuidador: z.string().min(6, { message: "Nome do cuidador deve ter no mínimo 6 caracteres" }).max(100, { message: "Nome do cuidador deve ter no máximo 100 caracteres" }),
    telefoneCuidador: z.string().max(11, { message: "Telefone do cuidador deve ter no máximo 11 caracteres" }),
})

router.post("/", async (req: Request, res: Response) => {
    try {
        const objSalvar = registerBodySchema.parse(req.body)

        const id_paciente = await knex('paciente').insert(objSalvar)
        const paciente = await knex('paciente').where({ id: id_paciente[0] })

        res.json({ message: "Paciente salvo", paciente })
    } catch (error) {
        if (error instanceof z.ZodError) {
            res.status(400).json({ errors: error.errors })
        } else {
            res.status(500).json({ error: "Erro interno do servidor" })
        }
    }
})

router.get('/', async (req: Request, res: Response) => {
    try {
        const resposta = await knex('paciente')
        res.json({ endereco: resposta })
    } catch (error) {
        res.status(500).json({ error: "Erro interno do servidor" })
    }
})

router.get('/id', async (req: Request, res: Response) => {
    try {
        const maxIdResult = await knex('paciente').max('id as maxId').first()

        if (maxIdResult && maxIdResult.maxId !== null) {
            const maxId = parseInt(maxIdResult.maxId)
            res.json({ id: maxId })
        } else {
            res.status(404).json({ error: 'Nenhum paciente encontrado' })
        }
    } catch (error) {
        console.error('Erro ao buscar maior ID de paciente:', error)
        res.status(500).json({ error: 'Erro interno ao buscar maior ID de paciente' })
    }
})

router.get('/:cns', async (req: Request, res: Response) => {
    const cns = req.params.cns

    try {
        const paciente = await knex('paciente').where({ cns }).first()
        if (paciente) {
            res.json({ paciente })
        } else {
            res.status(404).json({ message: 'Paciente não encontrado' })
        }
    } catch (error) {
        console.error('Erro ao consultar paciente:', error)
        res.status(500).json({ message: 'Erro interno do servidor' })
    }
})

router.put('/:id', async (req: Request, res: Response) => {
    try {
        const objSalvar = registerBodySchema.omit({ id_endereco: true }).parse(req.body)
        const { id } = req.params

        const paciente = await knex('paciente').where({ id }).first()

        if (!paciente) {
            throw new AppError('Paciente não encontrado!', 404)
        }

        const newPaciente = {
            ...paciente,
            ...objSalvar
        }

        await knex('paciente').update(newPaciente).where({ id: paciente.id })

        res.json({ message: 'Paciente alterado com sucesso' })
    } catch (error) {
        if (error instanceof z.ZodError) {
            res.status(400).json({ errors: error.errors })
        } else {
            res.status(500).json({ error: 'Erro interno do servidor' })
        }
    }
})

router.delete('/:id', async (req: Request, res: Response) => {
    const { id } = req.params

    try {
        const paciente = await knex('paciente').where({ id }).first()

        if (!paciente) {
            throw new AppError('Paciente não encontrado', 404)
        }

        await knex('paciente').where({ id }).delete()

        res.json({ message: 'Paciente deletado com sucesso' })
    } catch (error) {
        res.status(500).json({ error: 'Erro interno do servidor' })
    }
})

export default router
