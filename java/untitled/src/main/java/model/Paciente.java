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

    public Paciente(Long id, String nome, String cpf, String celular, Date dataNascimento, String cns, String email, String nomeCuidador, String telefoneCuidador, Endereco endereco) {
        super(id, nome, cpf, celular);
        this.dataNascimento = dataNascimento;
        this.cns = cns;
        this.email = email;
        this.nomeCuidador = nomeCuidador;
        this.telefoneCuidador = telefoneCuidador;
        this.endereco = endereco;
    }

    public Paciente(String nome, String cpf, String celular, Endereco endereco, Date dataNascimento, String cns, String email, String nomeCuidador, String telefoneCuidador) {
        super(0L, nome, cpf, celular);
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.cns = cns;
        this.email = email;
        this.nomeCuidador = nomeCuidador;
        this.telefoneCuidador = telefoneCuidador;
    }

    public Paciente(Long id,String nome, String cpf, String celular,String cns, String nomeCuidador, String telefoneCuidador){
        super(id, nome, cpf, celular);
        this.cns = cns;
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