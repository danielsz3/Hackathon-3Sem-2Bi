exports.up = function (knex) {
    return knex.schema.createTable('agendamentovisita', table => {
        table.increments('id').primary();
        table.datetime('dataVisita').notNullable();
        table.string('situacao', 20).notNullable();
        table.integer('id_agenteSaude').unsigned().nullable();
        table.integer('id_paciente').unsigned().nullable();
        table.foreign('id_agenteSaude').references('agentesaude.id');
        table.foreign('id_paciente').references('paciente.id');
    });
};

exports.down = function (knex) {
    return knex.schema.dropTableIfExists('agendamentovisita');
};
