import Router, { Request, Response } from "express"
import knex from "../knex"
import AppError from "../utils/AppError"
import { z } from "zod"

const router = Router()

router.post("/", async (req: Request, res: Response) => {
    const agendamentoBodySchema = z.object({
        dataVisita: z.string(),
        situacao: z.string().max(20),
        id_agenteSaude: z.number(),
        id_paciente: z.number()
    })

    const objSalvar = agendamentoBodySchema.parse(req.body)

    const id_agendamentovisita = await knex('agendamentovisita').insert(objSalvar)

    const agendamento = await knex('agendamentovisita').where({ id: id_agendamentovisita[0] }).first()

    res.json({ message: "Agendamento de Visita Salvo", agendamento })
})


router.get("/", async (req: Request, res: Response) => {
    const agendamentos = await knex('agendamentovisita')
        .select(
            'agendamentovisita.*',
            'agenteSaude.nome as agenteNome',
            'agenteSaude.cpf as agenteCpf',
            'agenteSaude.celular as agenteCelular'
        )
        .leftJoin('agenteSaude', 'agendamentovisita.id_agenteSaude', 'agenteSaude.id')

    res.json({ agendamentos })
})

router.put("/:id", async (req: Request, res: Response) => {
    const objSalvar = req.body
    const { id } = req.params

    let agendamento = await knex('agendamentovisita').where({ id }).first()

    if (!agendamento) {
        throw new AppError('Agendamento de Visita não encontrado!', 404)
    }

    let newAgendamento = {
        ...agendamento,
        ...objSalvar
    }

    await knex('agendamentovisita').update(newAgendamento).where({ id: agendamento.id })

    return res.json({
        message: `Agendamento de Visita atualizado com sucesso`
    })
})

router.delete("/:id", async (req: Request, res: Response) => {
    const { id } = req.params

    const agendamento = await knex('agendamentovisita').where({ id }).first()

    if (!agendamento) {
        throw new AppError('Agendamento de Visita não encontrado', 404)
    }

    await knex('agendamentovisita').where({ id }).delete()

    res.json({ message: 'Agendamento de Visita deletado com sucesso' })
})

export default router
