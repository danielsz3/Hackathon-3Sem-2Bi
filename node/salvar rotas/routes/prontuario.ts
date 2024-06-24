import { Router, Request, Response } from 'express';
import knex from 'knex';
import { z } from 'zod';

const router = Router();

const prontuarioBodySchema = z.object({
    id_vacina: z.number().int().nonnegative({ message: "ID da vacina deve ser um número inteiro" }),
    id_agendamentoVisita: z.number().int().nonnegative({ message: "ID do agendamento da visita deve ser um número inteiro" })
});

router.post('/prontuario', async (req: Request, res: Response) => {
    try {
        const { id_vacina, id_agendamentoVisita } = prontuarioBodySchema.parse(req.body);

        await knex('prontuario').insert({ id_vacina, id_agendamentoVisita });
        res.status(201).json({ message: 'Dados do prontuário salvos com sucesso' });
    } catch (error) {
        if (error instanceof z.ZodError) {
            return res.status(400).json({ error: error.errors });
        } else {
            console.error("Erro ao salvar dados do prontuário:", error);
            return res.status(500).json({ error: 'Erro ao salvar dados do prontuário' });
        }
    }
});

router.get('/prontuario', async (req: Request, res: Response) => {
    try {
        const prontuarios = await knex('prontuario').select('*');
        res.json({ prontuarios });
    } catch (error) {
        console.error("Erro ao buscar dados dos prontuários:", error);
        res.status(500).json({ error: 'Erro ao buscar dados dos prontuários' });
    }
});

router.put('/prontuario/:id', async (req: Request, res: Response) => {
    const { id } = req.params;
    try {
        const { id_vacina, id_agendamentoVisita } = prontuarioBodySchema.parse(req.body);

        const prontuario = await knex('prontuario').where({ id }).first();

        if (!prontuario) {
            return res.status(404).json({ error: 'Prontuário não encontrado' });
        }

        await knex('prontuario').where({ id }).update({ id_vacina, id_agendamentoVisita });

        res.json({ message: 'Dados do prontuário atualizados com sucesso' });
    } catch (error) {
        if (error instanceof z.ZodError) {
            return res.status(400).json({ error: error.errors });
        } else {
            console.error("Erro ao atualizar dados do prontuário:", error);
            return res.status(500).json({ error: 'Erro ao atualizar dados do prontuário' });
        }
    }
});

router.delete('/prontuario/:id', async (req: Request, res: Response) => {
    const { id } = req.params;
    try {
        const prontuario = await knex('prontuario').where({ id }).first();

        if (!prontuario) {
            return res.status(404).json({ error: 'Prontuário não encontrado' });
        }

        await knex('prontuario').where({ id }).delete();

        res.json({ message: 'Prontuário deletado com sucesso' });
    } catch (error) {
        console.error("Erro ao deletar prontuário:", error);
        return res.status(500).json({ error: 'Erro ao deletar prontuário' });
    }
});

export default router;
