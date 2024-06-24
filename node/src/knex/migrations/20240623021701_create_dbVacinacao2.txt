/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = async function (knex) {
    // Criando tabela agendamentovisita
    await knex.schema.createTable('agendamentovisita', table => {
        table.increments('id').primary();
        table.datetime('dataVisita').notNullable();
        table.string('situacao', 20).notNullable();
        table.integer('id_agenteSaude').unsigned().nullable();
        table.integer('id_paciente').unsigned().nullable();
        table.foreign('id_agenteSaude').references('agentesaude.id');
        table.foreign('id_paciente').references('paciente.id');
    });

    // Criando tabela agentesaude
    await knex.schema.createTable('agentesaude', table => {
        table.increments('id').primary();
        table.string('nome', 100).notNullable();
        table.string('cpf', 11).notNullable().unique();
        table.string('celular', 11).notNullable().unique();
        table.string('senha', 100).notNullable().unique();
    });

    // Criando tabela endereco
    await knex.schema.createTable('endereco', table => {
        table.increments('id').primary();
        table.string('cep', 8).notNullable();
        table.string('logradouro', 50).notNullable();
        table.string('numero', 5).notNullable();
        table.string('complemento', 50).notNullable();
        table.string('bairro', 50).notNullable();
        table.string('cidade', 45).notNullable();
        table.string('estado', 45).notNullable();
    });

    // Criando tabela paciente
    await knex.schema.createTable('paciente', table => {
        table.increments('id').primary();
        table.integer('id_endereco').unsigned().notNullable();
        table.string('nome', 100).notNullable();
        table.date('dataNascimento').notNullable();
        table.string('cpf', 11).notNullable().unique();
        table.string('cns', 15).notNullable().unique();
        table.string('celular', 11).notNullable().unique();
        table.string('email', 50).notNullable().unique();
        table.string('nomeCuidador', 100).nullable();
        table.string('telefoneCuidador', 11).nullable();
        table.foreign('id_endereco').references('endereco.id');
    });

    // Criando tabela prontuario
    await knex.schema.createTable('prontuario', table => {
        table.integer('id_vacina').unsigned().notNullable();
        table.integer('id_agendamentoVisita').unsigned().notNullable();
        table.primary(['id_vacina', 'id_agendamentoVisita']);
        table.foreign('id_vacina').references('vacina.id');
        table.foreign('id_agendamentoVisita').references('agendamentovisita.id');
    });

    // Criando tabela vacina
    await knex.schema.createTable('vacina', table => {
        table.increments('id').primary();
        table.string('nomeVacina', 50).notNullable().unique();
        table.string('descricao', 100).notNullable();
    });

    // Criando tabela knex_migrations (tabela de controle do Knex)
    await knex.schema.createTable('knex_migrations', table => {
        table.increments('id').primary();
        table.string('name').nullable();
        table.integer('batch').nullable();
        table.timestamp('migration_time').nullable();
    });

    // Criando tabela knex_migrations_lock (tabela de bloqueio do Knex)
    await knex.schema.createTable('knex_migrations_lock', table => {
        table.increments('index').primary();
        table.integer('is_locked').nullable();
    });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = async function (knex) {
    // Excluindo tabelas na ordem inversa da criação

    await knex.schema.dropTableIfExists('knex_migrations_lock');
    await knex.schema.dropTableIfExists('knex_migrations');
    await knex.schema.dropTableIfExists('prontuario');
    await knex.schema.dropTableIfExists('vacina');
    await knex.schema.dropTableIfExists('paciente');
    await knex.schema.dropTableIfExists('endereco');
    await knex.schema.dropTableIfExists('agentesaude');
    await knex.schema.dropTableIfExists('agendamentovisita');
};
