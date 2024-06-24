exports.up = function (knex) {
    return knex.schema.createTable('paciente', table => {
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
};

exports.down = function (knex) {
    return knex.schema.dropTableIfExists('paciente');
};
