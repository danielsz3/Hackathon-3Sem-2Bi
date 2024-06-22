package model;

import java.time.LocalDate;
import java.sql.Date;

public class Paciente extends Pessoa {
    private Endereco endereco;
    private Date dataNascimento;
    private String cns;
    private String email;
    private String nomeCuidador;
    private String telefoneCuidador;

    public Paciente(Long id ,String nome, Date dataNascimento, String cns, String cpf, String celular,  String email, String nomeCuidador, String telefoneCuidador) {
        super(id, nome, cpf, celular);
        this.dataNascimento = dataNascimento;
        this.cns = cns;
        this.email = email;
        this.nomeCuidador = nomeCuidador;
        this.telefoneCuidador = telefoneCuidador;
    }

    public Paciente(String nome, String cpf, String celular, Date dataNascimento, String cns, String email, String nomeCuidador, String telefoneCuidador) {
        super(0L,nome, cpf, celular);
        this.dataNascimento = dataNascimento;
        this.cns = cns;
        this.email = email;
        this.nomeCuidador = nomeCuidador;
        this.telefoneCuidador = telefoneCuidador;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento.toLocalDate();
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = Date.valueOf(dataNascimento);
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeCuidador() {
        return nomeCuidador;
    }

    public void setNomeCuidador(String nomeCuidador) {
        this.nomeCuidador = nomeCuidador;
    }

    public String getTelefoneCuidador() {
        return telefoneCuidador;
    }

    public void setTelefoneCuidador(String telefoneCuidador) {
        this.telefoneCuidador = telefoneCuidador;
    }
}
