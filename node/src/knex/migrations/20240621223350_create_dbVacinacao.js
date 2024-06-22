/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function (knex) {
    return knex.schema
        .createTable('agentesaude', function (table) {
            table.increments('id').primary()
            table.string('nome', 100).notNullable()
            table.string('cpf', 11).notNullable().unique()
            table.string('celular', 11).notNullable().unique()
            table.string('senha', 100).notNullable().unique()
        })
        .createTable('endereco', function (table) {
            table.increments('id').primary()
            table.string('cep', 8).notNullable()
            table.string('logradouro', 50).notNullable()
            table.string('numero', 5).notNullable()
            table.string('complemento', 50).notNullable()
            table.string('bairro', 50).notNullable()
            table.string('cidade', 45).notNullable()
            table.string('estado', 45).notNullable()
        })
        .createTable('paciente', function (table) {
            table.increments('id').primary()
            table.integer('id_endereco').unsigned().notNullable()
            table.string('nome', 100).notNullable()
            table.date('dataNascimento').notNullable()
            table.string('cpf', 11).notNullable().unique()
            table.string('cns', 15).notNullable().unique()
            table.string('celular', 11).notNullable().unique()
            table.string('email', 50).notNullable().unique()
            table.string('nomeCuidador', 100).defaultTo(null)
            table.string('telefoneCuidador', 11).defaultTo(null)
            table.foreign('id_endereco').references('id').inTable('endereco').onDelete('NO ACTION').onUpdate('NO ACTION')
        })
        .createTable('vacina', function (table) {
            table.increments('id').primary()
            table.string('nomeVacina', 50).notNullable().unique()
            table.string('descricao', 100).notNullable()
        })
        .createTable('agendamentovisita', function (table) {
            table.increments('id').primary()
            table.dateTime('dataVisita').notNullable()
            table.string('situacao', 20).notNullable()
            table.integer('id_agenteSaude').unsigned().notNullable()
            table.integer('id_paciente').unsigned().notNullable()
            table.foreign('id_agenteSaude').references('id').inTable('agentesaude').onDelete('NO ACTION').onUpdate('NO ACTION')
            table.foreign('id_paciente').references('id').inTable('paciente').onDelete('NO ACTION').onUpdate('NO ACTION')
        })
        .createTable('prontuario', function (table) {
            table.integer('id_vacina').unsigned().notNullable()
            table.integer('id_agendamentoVisita').unsigned().notNullable()
            table.foreign('id_vacina').references('id').inTable('vacina').onDelete('NO ACTION').onUpdate('NO ACTION')
            table.foreign('id_agendamentoVisita').references('id').inTable('agendamentovisita').onDelete('NO ACTION').onUpdate('NO ACTION')
            table.primary(['id_vacina', 'id_agendamentoVisita'])
        })
}

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function (knex) {
    return knex.schema
        .dropTableIfExists('prontuario')
        .dropTableIfExists('agendamentovisita')
        .dropTableIfExists('vacina')
        .dropTableIfExists('paciente')
        .dropTableIfExists('endereco')
        .dropTableIfExists('agentesaude')
}
