import Router, { Request, Response } from "express"
import knex from "knex"
import AppError from "../utils/AppError";
import { hash } from 'bcrypt'
import { z } from "zod"

const router = Router();

router.post("/", async (req: Request, res: Response) => {

    const registerBodySchema = z.object({
        cep: z.string({ message: "CEP Obrigatorio" }).max(8).min(8),
        logradouro: z.string({ message: "Logradouro Obrigatório" }).max(50),
        numero: z.string({ message: "Numero Obrigatorio" }).max(11),
        complemento: z.string().max(50),
        bairro: z.string({ message: "Bairro Obrigatorio" }).max(50),
        cidade: z.string({ message: "Cidade Obrigatorio" }).max(45),
        estado: z.string({ message: "Estado Obrigatorio" }).max(45)
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
        throw new AppError("Estado Obrigatório")
    }

    const id_endereco = await knex('endereco').insert(objSalvar)
    const endereco = await knex('endereco').where({ id: id_endereco[0] })
    res.json({ message: "Endereco Salvar" })

})

router.get("/", async (req: Request, res: Response) => {
    const endereco = await knex('endereco')
        .select(
            'endereco.*'
        )
    res.json({ endereco })
})

router.get('/id', async (req: Request, res: Response) => {
    try {
        const maxIdResult = await knex('endereco').max('id as maxId').first();

        if (maxIdResult && maxIdResult.maxId !== null) {
            const maxId = parseInt(maxIdResult.maxId); // Converter para número inteiro

            res.json({ id: maxId }); // Retorna apenas o campo ID
        } else {
            res.status(404).json({ error: 'Nenhum endereço encontrado' });
        }
    } catch (error) {
        console.error('Erro ao buscar maior ID de endereço:', error);
        res.status(500).json({ error: 'Erro interno ao buscar maior ID de endereço' });
    }
});

export default router
