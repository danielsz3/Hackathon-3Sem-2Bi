import { Knex } from "knex";

export async function up(knex: Knex): Promise<void> {
    await knex.schema.raw(`
        CREATE SCHEMA IF NOT EXISTS \`dbVacinacao\` DEFAULT CHARACTER SET utf8;
        USE \`dbVacinacao\`;
    `);

    await knex.schema.withSchema('dbVacinacao').createTable('vacina', (table) => {
        table.increments('id').primary();
        table.string('nomeVacina', 50).notNullable().unique();
        table.string('descricao', 100).notNullable();
    });

    await knex.schema.withSchema('dbVacinacao').createTable('endereco', (table) => {
        table.increments('id').primary();
        table.string('cep', 8).notNullable();
        table.string('logradouro', 50).notNullable();
        table.string('numero', 5).notNullable();
        table.string('complemento', 50).notNullable();
        table.string('bairro', 50).notNullable();
        table.string('cidade', 45).notNullable();
        table.string('estado', 45).notNullable();
    });

    await knex.schema.withSchema('dbVacinacao').createTable('paciente', (table) => {
        table.increments('id').primary();
        table.integer('id_endereco').unsigned().notNullable().references('id').inTable('dbVacinacao.endereco').onDelete('NO ACTION').onUpdate('NO ACTION');
        table.string('nome', 100).notNullable();
        table.date('dataNascimento').notNullable();
        table.string('cpf', 11).notNullable().unique();
        table.string('cns', 15).notNullable().unique();
        table.string('celular', 11).notNullable().unique();
        table.string('email', 50).notNullable().unique();
        table.string('nomeCuidador', 100).nullable();
        table.string('telefoneCuidador', 11).nullable();
    });

    await knex.schema.withSchema('dbVacinacao').createTable('agenteSaude', (table) => {
        table.increments('id').primary();
        table.string('nome', 100).notNullable();
        table.string('cpf', 11).notNullable().unique();
        table.string('celular', 11).notNullable().unique();
        table.string('senha', 100).notNullable().unique();
    });

    await knex.schema.withSchema('dbVacinacao').createTable('agendamentoVisita', (table) => {
        table.increments('id').primary();
        table.dateTime('dataVisita').notNullable();
        table.string('situacao', 20).notNullable();
        table.integer('id_agenteSaude').unsigned().notNullable().references('id').inTable('dbVacinacao.agenteSaude').onDelete('NO ACTION').onUpdate('NO ACTION');
        table.integer('id_paciente').unsigned().notNullable().references('id').inTable('dbVacinacao.paciente').onDelete('NO ACTION').onUpdate('NO ACTION');
    });

    await knex.schema.withSchema('dbVacinacao').createTable('prontuario', (table) => {
        table.integer('id_vacina').unsigned().notNullable().references('id').inTable('dbVacinacao.vacina').onDelete('NO ACTION').onUpdate('NO ACTION');
        table.integer('id_agendamentoVisita').unsigned().notNullable().references('id').inTable('dbVacinacao.agendamentoVisita').onDelete('NO ACTION').onUpdate('NO ACTION');
    });
}

export async function down(knex: Knex): Promise<void> {
    await knex.schema.withSchema('dbVacinacao').dropTableIfExists('prontuario');
    await knex.schema.withSchema('dbVacinacao').dropTableIfExists('agendamentoVisita');
    await knex.schema.withSchema('dbVacinacao').dropTableIfExists('agenteSaude');
    await knex.schema.withSchema('dbVacinacao').dropTableIfExists('paciente');
    await knex.schema.withSchema('dbVacinacao').dropTableIfExists('endereco');
    await knex.schema.withSchema('dbVacinacao').dropTableIfExists('vacina');
    await knex.schema.raw(`DROP SCHEMA IF EXISTS \`dbVacinacao\``);
}
