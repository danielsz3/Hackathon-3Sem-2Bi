const path = require('path')

module.exports = {
    development: {
        client: 'mysql',
        connection: {
            host: 'localhost',
            port: 3306,
            user: 'root',
            password: '',
            database: 'dbVacinacao',
        },
        pool: {
            afterCreate: (conn, cb) => conn.run('PRAGMA foreign_keys = ON', cb)
        },
        migrations: {
            directory: path.resolve(
                __dirname,
                'src',
                'database',
                'knex',
                'migrations'
            )
        },
        useNullAsDefault: true
    }
}
