import Router, { Request, Response } from "express"
import knex from "../knex"
import AppError from "../utils/AppError";
import { hash } from 'bcrypt'
import { z } from "zod"

const router = Router();



router.post("/", async (req: Request, res: Response) => {

    const registerBodySchema = z.object({
        cep: z.string({ message: "CEP Obrigatorio" }).max(8).min(8),
        logradouro: z.string({ message: "Logradouro Obrigatório"}).max(50),
        numero: z.string({ message: "Numero Obrigatorio" }).max(11),
        complemento: z.string().max(50),
        bairro: z.string({ message: "Bairro Obrigatorio" }).max(50),
        cidade: z.string({ message: "Cidade Obrigatorio" }).max(45),
        estado: z.string({ message: "Nome do cuidador Obrigatorio" }).max(45)
    })

    const objSalvar = registerBodySchema.parse(req.body)

    if (!objSalvar?.cep) {
        throw new AppError("CEP Obrigatório")
    }
    if (!objSalvar?.logradouro) {
        throw new AppError("Logradouro Obrigatório")
    }
    if (!objSalvar?.numero) {
        throw new AppError("Numero Obrigatório")
    }
    if (!objSalvar?.bairro) {
        throw new AppError("Bairro Obrigatório")
    }
    if (!objSalvar?.cidade) {
        throw new AppError("Cidade Obrigatório")
    }
    if (!objSalvar?.estado) {
        throw new AppError("Cuidador Obrigatório")
    }

    const id_endereco = await knex('endereco').insert(objSalvar)
    const endereco = await knex('endereco').where({ id: id_endereco[0] })
    res.json({ message: "Endereco Salvar", endereco })

})


router.get('/', (req, res) => {
    knex('endereco').then((resposta) => {
        res.json({ endereco: resposta })
    })

})

export default router
