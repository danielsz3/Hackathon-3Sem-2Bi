exports.up = function (knex) {
    return knex.schema.createTable('vacina', table => {
        table.increments('id').primary();
        table.string('nomeVacina', 50).notNullable().unique();
        table.string('descricao', 100).notNullable();
    });
};

exports.down = function (knex) {
    return knex.schema.dropTableIfExists('vacina');
};
