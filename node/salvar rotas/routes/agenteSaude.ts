import Router, { Request, Response } from "express"
import knex from "knex"
import AppError from "../../src/utils/AppError"
import CPFvalidator from "../../../php/funcoes/CPFvalidator"
import { hash } from 'bcrypt'
import { z } from "zod"

const router = Router()

const registerBodySchema = z.object({
    nome: z.string(),
    cpf: z.string().length(11),
    celular: z.string().length(11),
    senha: z.string().min(6, { message: "Senha Obrigatória" })
})

const updateBodySchema = z.object({
    nome: z.string().optional(),
    cpf: z.string().length(11).optional(),
    celular: z.string().length(11).optional(),
    senha: z.string().min(6, { message: "Senha Obrigatória" }).optional()
})

router.post("/", async (req: Request, res: Response) => {
    try {
        const objSalvar = registerBodySchema.parse(req.body)

        if (!CPFvalidator(objSalvar.cpf)) {
            throw new AppError("CPF inválido. Por favor, insira um CPF válido.")
        }

        const cpfExistente = await knex('agentesaude').where({ cpf: objSalvar.cpf }).first()
        if (cpfExistente) {
            throw new AppError("CPF já cadastrado. Por favor, utilize outro CPF.")
        }

        const celularExistente = await knex('agentesaude').where({ celular: objSalvar.celular }).first()
        if (celularExistente) {
            throw new AppError("Celular já cadastrado. Por favor, utilize outro número.")
        }

        objSalvar.senha = await hash(objSalvar.senha, 8)

        const id_agentesaude = await knex('agentesaude').insert(objSalvar)

        const agentesaude = await knex('agentesaude').where({ id: id_agentesaude[0] })

        res.status(201).json({ message: "Agente de Saúde Salvo", agentesaude })
    } catch (error) {
        if (error instanceof AppError) {
            return res.status(error.statusCode).json({ error: error.message })
        }
        console.error("Erro ao criar o Agente de Saúde:", error)
        return res.status(500).json({ error: "Erro interno do servidor" })
    }
})

router.get("/", async (req: Request, res: Response) => {
    try {
        const agentes = await knex('agentesaude')
        res.json({ agentes })
    } catch (error) {
        console.error("Erro ao buscar agentes de saúde:", error)
        res.status(500).json({ error: "Erro interno do servidor" })
    }
})

router.put("/:id", async (req: Request, res: Response) => {
    try {
        const objSalvar = updateBodySchema.parse(req.body)
        const { id } = req.params

        const agente = await knex('agentesaude').where({ id }).first()
        if (!agente) {
            throw new AppError('Agente de Saúde não encontrado!', 404)
        }

        if (objSalvar.cpf && objSalvar.cpf !== agente.cpf) {
            await validarEAtualizarCPF(objSalvar.cpf)
        }

        if (objSalvar.celular && objSalvar.celular !== agente.celular) {
            await validarEAtualizarCelular(objSalvar.celular)
        }

        if (objSalvar.senha) {
            objSalvar.senha = await hash(objSalvar.senha, 8)
        }

        await knex('agentesaude').where({ id }).update(objSalvar)

        res.json({ message: "Agente de Saúde atualizado com sucesso" })
    } catch (error) {
        if (error instanceof AppError) {
            return res.status(error.statusCode).json({ error: error.message })
        }
        console.error("Erro ao atualizar o Agente de Saúde:", error)
        return res.status(500).json({ error: "Erro interno do servidor" })
    }
})

async function validarEAtualizarCPF(cpf: string) {
    if (!CPFvalidator(cpf)) {
        throw new AppError("CPF inválido. Por favor, insira um CPF válido.")
    }

    const cpfExistente = await knex('agentesaude').where({ cpf }).first()
    if (cpfExistente) {
        throw new AppError("CPF já cadastrado. Por favor, utilize outro CPF.")
    }
}

async function validarEAtualizarCelular(celular: string) {
    const celularExistente = await knex('agentesaude').where({ celular }).first()
    if (celularExistente) {
        throw new AppError("Celular já cadastrado. Por favor, utilize outro número.")
    }
}

router.delete("/:id", async (req: Request, res: Response) => {
    try {
        const { id } = req.params

        const agente = await knex('agentesaude').where({ id }).first()
        if (!agente) {
            throw new AppError('Agente de Saúde não encontrado', 404)
        }

        await knex('agentesaude').where({ id }).delete()

        res.json({ message: 'Agente de Saúde deletado com sucesso' })
    } catch (error) {
        if (error instanceof AppError) {
            return res.status(error.statusCode).json({ error: error.message })
        }
        console.error("Erro ao deletar o Agente de Saúde:", error)
        return res.status(500).json({ error: "Erro interno do servidor" })
    }
})

export default router
