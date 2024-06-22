import Router, { Request, Response } from "express";
import knex from "../knex";
import AppError from "../utils/AppError";
import { hash } from 'bcrypt';
import { z } from "zod";

const router = Router();

// Promise - async

router.post("/", async (req: Request, res: Response) => {
    const registerBodySchema = z.object({
        nome: z.string(),
        cpf: z.string().length(11),
        celular: z.string().length(11),
        senha: z.string({ message: "Senha Obrigatória" }).min(6)
    });

    const objSalvar = registerBodySchema.parse(req.body);

    if (!objSalvar?.senha) {
        throw new AppError("Senha Obrigatória");
    }

    // Hash the password
    objSalvar.senha = await hash(objSalvar.senha, 8);

    // Insert the data into agenteSaude table
    const id_agenteSaude = await knex('agenteSaude').insert(objSalvar);

    // Fetch the inserted data
    const agenteSaude = await knex('agenteSaude').where({ id: id_agenteSaude[0] });

    res.json({ message: "Agente de Saúde Salvo", agenteSaude });
});

router.get("/", (req: Request, res: Response) => {
    knex('agenteSaude').then((resposta) => {
        res.json({ agentes: resposta });
    });
});

router.put("/:id", async (req: Request, res: Response) => {
    const objSalvar = req.body;
    const { id } = req.params;

    if (objSalvar?.senha) {
        objSalvar.senha = await hash(objSalvar.senha, 8);
    }

    let agente = await knex('agenteSaude').where({ id }).first();

    if (!agente?.id) {
        throw new AppError('Agente de Saúde não encontrado!');
    }

    let newAgente = {
        ...agente,
        ...objSalvar
    };

    await knex('agenteSaude').update(newAgente).where({ id: agente.id });

    return res.json({
        message: `Agente de Saúde atualizado com sucesso`
    });
});

router.delete("/:id", async (req: Request, res: Response) => {
    const { id } = req.params;

    const agente = await knex('agenteSaude').where({ id }).first();

    if (!agente) {
        throw new AppError('Agente de Saúde não encontrado', 404);
    }

    await knex('agenteSaude').where({ id }).delete();

    res.json({ message: 'Agente de Saúde deletado com sucesso' });
});

export default router;
