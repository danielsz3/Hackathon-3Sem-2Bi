import Router, { Request, Response } from "express"
import knex from "../knex"
import AppError from "../utils/AppError"
import CPFvalidator from "../utils/CPFvalidator"

import { hash } from 'bcrypt'
import { z } from "zod"

const router = Router()

router.post("/", async (req, res) => {
    try {
        const registerBodySchema = z.object({
            nome: z.string(),
            cpf: z.string().length(11),
            celular: z.string().length(11),
            senha: z.string({ message: "Senha Obrigatória" }).min(6)
        });

        const objSalvar = registerBodySchema.parse(req.body);

        if (!CPFvalidator(objSalvar.cpf)) {
            throw new AppError("CPF inválido. Por favor, insira um CPF válido.");
        }

        const cpfExistente = await knex('agentesaude').where({ cpf: objSalvar.cpf }).first();
        if (cpfExistente) {
            throw new AppError("CPF já cadastrado. Por favor, utilize outro CPF.");
        }

        const celularExistente = await knex('agentesaude').where({ celular: objSalvar.celular }).first();
        if (celularExistente) {
            throw new AppError("Celular já cadastrado. Por favor, utilize outro número.");
        }

        objSalvar.senha = await hash(objSalvar.senha, 8);

        const id_agentesaude = await knex('agentesaude').insert(objSalvar);

        const agentesaude = await knex('agentesaude').where({ id: id_agentesaude[0] });

        res.json({ message: "Agente de Saúde Salvo", agentesaude });
    } catch (error) {
        if (error instanceof AppError) {
            return res.status(error.statusCode).json({ error: error.message });
        }

        return res.status(500).json({ error: "Erro interno do servidor" });
    }
});


router.get("/", (req: Request, res: Response) => {
    knex('agentesaude').then((resposta) => {
        res.json({ agentes: resposta })
    })
})

router.put("/:id", async (req: Request, res: Response) => {
    try {
        const objSalvar = req.body;
        const { id } = req.params;

        if (!id) {
            throw new AppError('ID do agente de saúde é obrigatório!');
        }

        const camposPermitidos = ['nome', 'cpf', 'celular', 'senha'];
        const camposAtualizar: any = {};

        // Filtra e atualiza apenas os campos permitidos
        for (const key of camposPermitidos) {
            if (objSalvar[key] !== undefined) {
                camposAtualizar[key] = objSalvar[key];
            }
        }

        // Se houver senha, criptografa antes de atualizar
        if (camposAtualizar.senha) {
            camposAtualizar.senha = await hash(camposAtualizar.senha, 8);
        }

        // Busca o agente pelo ID
        let agente = await knex('agentesaude').where({ id }).first();
        if (!agente) {
            throw new AppError('Agente de Saúde não encontrado!');
        }

        // Verifica se o CPF está sendo alterado e valida
        if (camposAtualizar.cpf && camposAtualizar.cpf !== agente.cpf) {
            await validarEAtualizarCPF(camposAtualizar.cpf, agente.cpf);
        }

        // Verifica se o celular está sendo alterado e valida
        if (camposAtualizar.celular && camposAtualizar.celular !== agente.celular) {
            await validarEAtualizarCelular(camposAtualizar.celular);
        }

        // Atualiza os dados do agente no banco de dados
        await knex('agentesaude').where({ id }).update(camposAtualizar);

        return res.json({
            message: `Agente de Saúde atualizado com sucesso`
        });
    } catch (error) {
        if (error instanceof AppError) {
            return res.status(error.statusCode).json({ error: error.message });
        }

        return res.status(500).json({ error: "Erro interno do servidor" });
    }
});

async function validarEAtualizarCPF(novoCPF: string, cpfAtual: string) {
    if (!CPFvalidator(novoCPF)) {
        throw new AppError("CPF inválido. Por favor, insira um CPF válido.");
    }

    const cpfExistente = await knex('agentesaude').where({ cpf: novoCPF }).first();
    if (cpfExistente) {
        throw new AppError("CPF já cadastrado. Por favor, utilize outro CPF.");
    }
}

async function validarEAtualizarCelular(novoCelular: string) {
    const celularExistente = await knex('agentesaude').where({ celular: novoCelular }).first();
    if (celularExistente) {
        throw new AppError("Celular já cadastrado. Por favor, utilize outro número.");
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

        return res.status(500).json({ error: "Erro interno do servidor" })
    }
})

export default router
