/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = async function (knex) {
    await knex.raw(`
        CREATE SCHEMA IF NOT EXISTS \`dbVacinacao\` DEFAULT CHARACTER SET utf8 ;
        USE \`dbVacinacao\` ;

        CREATE TABLE IF NOT EXISTS \`dbVacinacao\`.\`vacina\` (
          \`id\` INT NOT NULL AUTO_INCREMENT,
          \`nomeVacina\` VARCHAR(50) NOT NULL,
          \`descricao\` VARCHAR(100) NOT NULL,
          PRIMARY KEY (\`id\`),
          UNIQUE INDEX \`nomeVacina_UNIQUE\` (\`nomeVacina\` ASC)
        ) ENGINE = InnoDB;

        CREATE TABLE IF NOT EXISTS \`dbVacinacao\`.\`endereco\` (
          \`id\` INT NOT NULL AUTO_INCREMENT,
          \`cep\` VARCHAR(8) NOT NULL,
          \`logradouro\` VARCHAR(50) NOT NULL,
          \`numero\` VARCHAR(5) NOT NULL,
          \`complemento\` VARCHAR(50) NOT NULL,
          \`bairro\` VARCHAR(50) NOT NULL,
          \`cidade\` VARCHAR(45) NOT NULL,
          \`estado\` VARCHAR(45) NOT NULL,
          PRIMARY KEY (\`id\`)
        ) ENGINE = InnoDB;

        CREATE TABLE IF NOT EXISTS \`dbVacinacao\`.\`paciente\` (
          \`id\` INT NOT NULL AUTO_INCREMENT,
          \`id_endereco\` INT NOT NULL,
          \`nome\` VARCHAR(100) NOT NULL,
          \`dataNascimento\` DATE NOT NULL,
          \`cpf\` VARCHAR(11) NOT NULL,
          \`cns\` VARCHAR(15) NOT NULL,
          \`celular\` VARCHAR(11) NOT NULL,
          \`email\` VARCHAR(50) NOT NULL,
          \`nomeCuidador\` VARCHAR(100) NULL,
          \`telefoneCuidador\` VARCHAR(11) NULL,
          PRIMARY KEY (\`id\`),
          INDEX \`fk_paciente_endereco1_idx\` (\`id_endereco\` ASC),
          UNIQUE INDEX \`cpf_UNIQUE\` (\`cpf\` ASC),
          UNIQUE INDEX \`cns_UNIQUE\` (\`cns\` ASC),
          UNIQUE INDEX \`celular_UNIQUE\` (\`celular\` ASC),
          UNIQUE INDEX \`email_UNIQUE\` (\`email\` ASC),
          CONSTRAINT \`fk_paciente_endereco1\`
            FOREIGN KEY (\`id_endereco\`)
            REFERENCES \`dbVacinacao\`.\`endereco\` (\`id\`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
        ) ENGINE = InnoDB;

        CREATE TABLE IF NOT EXISTS \`dbVacinacao\`.\`agenteSaude\` (
          \`id\` INT NOT NULL AUTO_INCREMENT,
          \`nome\` VARCHAR(100) NOT NULL,
          \`cpf\` VARCHAR(11) NOT NULL,
          \`celular\` VARCHAR(11) NOT NULL,
          \`senha\` VARCHAR(100) NOT NULL,
          PRIMARY KEY (\`id\`),
          UNIQUE INDEX \`cpf_UNIQUE\` (\`cpf\` ASC),
          UNIQUE INDEX \`senha_UNIQUE\` (\`senha\` ASC),
          UNIQUE INDEX \`celular_UNIQUE\` (\`celular\` ASC)
        ) ENGINE = InnoDB;

        CREATE TABLE IF NOT EXISTS \`dbVacinacao\`.\`agendamentoVisita\` (
          \`id\` INT NOT NULL AUTO_INCREMENT,
          \`dataVisita\` DATETIME NOT NULL,
          \`situacao\` VARCHAR(20) NOT NULL,
          \`id_agenteSaude\` INT NOT NULL,
          \`id_paciente\` INT NOT NULL,
          PRIMARY KEY (\`id\`),
          INDEX \`fk_agendamentoVisita_agenteSaude1_idx\` (\`id_agenteSaude\` ASC),
          INDEX \`fk_agendamentoVisita_paciente1_idx\` (\`id_paciente\` ASC),
          CONSTRAINT \`fk_agendamentoVisita_agenteSaude1\`
            FOREIGN KEY (\`id_agenteSaude\`)
            REFERENCES \`dbVacinacao\`.\`agenteSaude\` (\`id\`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
          CONSTRAINT \`fk_agendamentoVisita_paciente1\`
            FOREIGN KEY (\`id_paciente\`)
            REFERENCES \`dbVacinacao\`.\`paciente\` (\`id\`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
        ) ENGINE = InnoDB;

        CREATE TABLE IF NOT EXISTS \`dbVacinacao\`.\`prontuario\` (
          \`id_vacina\` INT NOT NULL,
          \`id_agendamentoVisita\` INT NOT NULL,
          INDEX \`fk_vacina_has_agendamentoVisita_agendamentoVisita1_idx\` (\`id_agendamentoVisita\` ASC),
          INDEX \`fk_vacina_has_agendamentoVisita_vacina_idx\` (\`id_vacina\` ASC),
          CONSTRAINT \`fk_vacina_has_agendamentoVisita_vacina\`
            FOREIGN KEY (\`id_vacina\`)
            REFERENCES \`dbVacinacao\`.\`vacina\` (\`id\`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
          CONSTRAINT \`fk_vacina_has_agendamentoVisita_agendamentoVisita1\`
            FOREIGN KEY (\`id_agendamentoVisita\`)
            REFERENCES \`dbVacinacao\`.\`agendamentoVisita\` (\`id\`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
        ) ENGINE = InnoDB;
    `);
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = async function (knex) {
    await knex.raw(`
        DROP TABLE \`dbVacinacao\`.\`prontuario\`;
        DROP TABLE \`dbVacinacao\`.\`agendamentoVisita\`;
        DROP TABLE \`dbVacinacao\`.\`agenteSaude\`;
        DROP TABLE \`dbVacinacao\`.\`paciente\`;
        DROP TABLE \`dbVacinacao\`.\`endereco\`;
        DROP TABLE \`dbVacinacao\`.\`vacina\`;
        DROP SCHEMA IF EXISTS \`dbVacinacao\`;
    `);
};
