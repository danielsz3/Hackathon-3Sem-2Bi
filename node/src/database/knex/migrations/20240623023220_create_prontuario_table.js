exports.up = function (knex) {
    return knex.schema.createTable('prontuario', table => {
        table.integer('id_vacina').unsigned().notNullable();
        table.integer('id_agendamentoVisita').unsigned().notNullable();
        table.primary(['id_vacina', 'id_agendamentoVisita']);
        table.foreign('id_vacina').references('vacina.id');
        table.foreign('id_agendamentoVisita').references('agendamentovisita.id');
    });
};

exports.down = function (knex) {
    return knex.schema.dropTableIfExists('prontuario');
};
