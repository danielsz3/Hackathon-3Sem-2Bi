import Router, { Request, Response } from "express"
import knex from "knex"
import AppError from "../utils/AppError"
import { z } from "zod"

const router = Router()

const vacinaBodySchema = z.object({
    nomeVacina: z.string().max(50),
    descricao: z.string().max(100)
})

router.post("/", async (req: Request, res: Response) => {
    const objSalvar = vacinaBodySchema.parse(req.body)

    try {
        const id_vacina = await knex('vacina').insert(objSalvar)
        const vacina = await knex('vacina').where({ id: id_vacina[0] }).first()
        res.json({ message: "Vacina Salva com Sucesso", vacina })
    } catch (error) {
        throw new AppError('Erro ao salvar a vacina', 500)
    }
})

router.get("/", async (req: Request, res: Response) => {
    const vacinas = await knex('vacina').select('*')
    res.json({ vacinas })
})

router.put("/:id", async (req: Request, res: Response) => {
    const objSalvar = vacinaBodySchema.parse(req.body)
    const { id } = req.params

    let vacina = await knex('vacina').where({ id }).first()

    if (!vacina) {
        throw new AppError('Vacina não encontrada!', 404)
    }

    await knex('vacina').update(objSalvar).where({ id: vacina.id })

    return res.json({ message: "Vacina atualizada com sucesso" })
})

router.delete("/:id", async (req: Request, res: Response) => {
    const { id } = req.params

    try {
        const vacina = await knex('vacina').where({ id }).first()

        if (!vacina) {
            throw new AppError('Vacina não encontrada', 404)
        }

        await knex('vacina').where({ id }).delete()

        res.json({ message: 'Vacina deletada com sucesso' })
    } catch (error) {
        console.error(error)
        throw new AppError('Erro ao deletar vacina', 500)
    }
})


export default router
