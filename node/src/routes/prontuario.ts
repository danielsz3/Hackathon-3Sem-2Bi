import { Router } from 'express'
import knex from 'knex'
import AppError from '../utils/AppError'
import { z } from "zod"

const router = Router()

const prontuarioBodySchema = z.object({
    id_vacina: z.number().int(),
    id_agendamentoVisita: z.number().int()
})

router.post('/prontuario', async (req, res) => {
    const { id_vacina, id_agendamentoVisita } = prontuarioBodySchema.parse(req.body)

    try {
        await knex('prontuario').insert({ id_vacina, id_agendamentoVisita })
        res.json({ message: 'Dados do prontuário salvos com sucesso' })
    } catch (error) {
        throw new AppError('Erro ao salvar dados do prontuário', 500)
    }
})

export default router
