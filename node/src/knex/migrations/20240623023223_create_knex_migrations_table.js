exports.up = function (knex) {
    return knex.schema.createTable('knex_migrations', table => {
        table.increments('id').primary();
        table.string('name').nullable();
        table.integer('batch').nullable();
        table.timestamp('migration_time').nullable();
    });
};

exports.down = function (knex) {
    return knex.schema.dropTableIfExists('knex_migrations');
};
