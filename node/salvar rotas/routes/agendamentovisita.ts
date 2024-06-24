import Router, { Request, Response } from "express"
import knex from "knex"
import AppError from "../../src/utils/AppError"
import { z } from "zod"

const router = Router()

const agendamentoBodySchema = z.object({
    dataVisita: z.string(),
    situacao: z.string().max(20),
    id_agenteSaude: z.number().nullable(),
    id_paciente: z.number().nullable()
})

router.post("/", async (req: Request, res: Response) => {
    try {
        const objSalvar = agendamentoBodySchema.parse(req.body)

        await knex('agendamentovisita').insert({
            dataVisita: objSalvar.dataVisita,
            situacao: objSalvar.situacao,
            id_agentesaude: objSalvar.id_agenteSaude !== undefined ? objSalvar.id_agenteSaude : null,
            id_paciente: objSalvar.id_paciente !== undefined ? objSalvar.id_paciente : null
        })

        res.status(201).json({ message: "Agendamento da Visita criado com sucesso" })
    } catch (error) {
        console.error("Erro ao criar o Agendamento da Visita:", error)
        if (error instanceof z.ZodError) {
            res.status(400).json({ message: "Erro de validação", errors: error.errors })
        } else {
            res.status(500).json({ message: "Erro interno do servidor" })
        }
    }
})

router.get("/", async (req: Request, res: Response) => {
    try {
        const agendamentos = await knex('agendamentovisita')
            .select(
                'agendamentovisita.*',
                'agenteSaude.nome as agenteNome',
                'agenteSaude.cpf as agenteCpf',
                'agenteSaude.celular as agenteCelular'
            )
            .leftJoin('agenteSaude', 'agendamentovisita.id_agenteSaude', 'agenteSaude.id')

        res.json({ agendamentos })
    } catch (error) {
        console.error("Erro ao buscar agendamentos:", error)
        res.status(500).json({ message: "Erro interno do servidor" })
    }
})

router.put("/:id", async (req: Request, res: Response) => {
    const updateBodySchema = agendamentoBodySchema.partial()

    try {
        const objSalvar = updateBodySchema.parse(req.body)
        const { id } = req.params

        const agendamento = await knex('agendamentovisita').where({ id }).first()

        if (!agendamento) {
            throw new AppError('Agendamento de Visita não encontrado!', 404)
        }

        const newAgendamento = {
            ...agendamento,
            ...objSalvar
        }

        await knex('agendamentovisita').update(newAgendamento).where({ id: agendamento.id })

        res.json({ message: "Agendamento de Visita atualizado com sucesso" })
    } catch (error) {
        console.error("Erro ao atualizar o Agendamento de Visita:", error)
        if (error instanceof z.ZodError) {
            res.status(400).json({ message: "Erro de validação", errors: error.errors })
        } else if (error instanceof AppError) {
            res.status(error.statusCode).json({ message: error.message })
        } else {
            res.status(500).json({ message: "Erro interno do servidor" })
        }
    }
})

router.delete("/:id", async (req: Request, res: Response) => {
    const { id } = req.params

    try {
        const agendamento = await knex('agendamentovisita').where({ id }).first()

        if (!agendamento) {
            throw new AppError('Agendamento de Visita não encontrado', 404)
        }

        await knex('agendamentovisita').where({ id }).delete()

        res.json({ message: 'Agendamento de Visita deletado com sucesso' })
    } catch (error) {
        console.error("Erro ao deletar o Agendamento de Visita:", error)
        if (error instanceof AppError) {
            res.status(error.statusCode).json({ message: error.message })
        } else {
            res.status(500).json({ message: "Erro interno do servidor" })
        }
    }
})

export default router
