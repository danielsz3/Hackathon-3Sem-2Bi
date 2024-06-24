exports.up = function (knex) {
    return knex.schema.createTable('knex_migrations_lock', table => {
        table.increments('index').primary();
        table.integer('is_locked').nullable();
    });
};

exports.down = function (knex) {
    return knex.schema.dropTableIfExists('knex_migrations_lock');
};
