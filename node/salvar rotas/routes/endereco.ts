import Router, { Request, Response } from "express"
import knex from "knex"
import AppError from "../../src/utils/AppError"
import { z } from "zod"

const router = Router()

const registerBodySchema = z.object({
    cep: z.string().length(8, { message: "CEP Obrigatório" }),
    logradouro: z.string().max(50, { message: "Logradouro Obrigatório" }),
    numero: z.string().max(11, { message: "Número Obrigatório" }),
    complemento: z.string().max(50, { message: "Complemento" }).optional(),
    bairro: z.string().max(50, { message: "Bairro Obrigatório e" }),
    cidade: z.string().max(50, { message: "Cidade Obrigatória" }),
    estado: z.string().max(50, { message: "Estado Obrigatório" })
})

router.post("/", async (req: Request, res: Response) => {
    try {
        const objSalvar = registerBodySchema.parse(req.body)

        const id_endereco = await knex('endereco').insert(objSalvar)
        const endereco = await knex('endereco').where({ id: id_endereco[0] }).first()

        res.status(201).json({ message: "Endereço Salvo com Sucesso", endereco })
    } catch (error) {
        if (error instanceof AppError) {
            return res.status(error.statusCode).json({ error: error.message })
        }
        if (error instanceof z.ZodError) {
            return res.status(400).json({ error: error.errors })
        }
        console.error("Erro ao salvar endereço:", error)
        return res.status(500).json({ error: "Erro interno do servidor" })
    }
})

router.get("/", async (req: Request, res: Response) => {
    try {
        const enderecos = await knex('endereco')
        res.json({ enderecos })
    } catch (error) {
        console.error("Erro ao buscar endereços:", error)
        res.status(500).json({ error: "Erro interno do servidor" })
    }
})

router.get("/id", async (req: Request, res: Response) => {
    try {
        const maxIdResult = await knex('endereco').max('id as maxId').first()

        if (maxIdResult && maxIdResult.maxId !== null) {
            const maxId = parseInt(maxIdResult.maxId)
            res.json({ id: maxId })
        } else {
            res.status(404).json({ error: 'Nenhum endereço encontrado' })
        }
    } catch (error) {
        console.error('Erro ao buscar maior ID de endereço:', error)
        res.status(500).json({ error: 'Erro interno ao buscar maior ID de endereço' })
    }
})

export default router
