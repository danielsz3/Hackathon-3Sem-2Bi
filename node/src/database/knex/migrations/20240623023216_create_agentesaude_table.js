exports.up = function (knex) {
    return knex.schema.createTable('agentesaude', table => {
        table.increments('id').primary();
        table.string('nome', 100).notNullable();
        table.string('cpf', 11).notNullable().unique();
        table.string('celular', 11).notNullable().unique();
        table.string('senha', 100).notNullable();
    });
};

exports.down = function (knex) {
    return knex.schema.dropTableIfExists('agentesaude');
};
