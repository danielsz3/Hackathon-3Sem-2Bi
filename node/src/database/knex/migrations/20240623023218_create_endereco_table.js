exports.up = function (knex) {
    return knex.schema.createTable('endereco', table => {
        table.increments('id').primary();
        table.string('cep', 8).notNullable();
        table.string('logradouro', 50).notNullable();
        table.string('numero', 5).notNullable();
        table.string('complemento', 50).notNullable();
        table.string('bairro', 50).notNullable();
        table.string('cidade', 45).notNullable();
        table.string('estado', 45).notNullable();
    });
};

exports.down = function (knex) {
    return knex.schema.dropTableIfExists('endereco');
};
