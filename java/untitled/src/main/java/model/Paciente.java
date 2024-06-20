package model;

import java.time.LocalDate;

public class Paciente extends Pessoa {
    private Endereco endereco;
    private LocalDate dataNascimento;
    private String cns;
    private String email;
    private String nomeCuidador;
    private String telefoneCuidador;

    public Paciente(int id, String nome, String cpf, String celular, Endereco endereco, String dataNascimento, String cns, String email, String nomeCuidador, String telefoneCuidador) {
        super(id, nome, cpf, celular);
        this.endereco = endereco;
        this.dataNascimento = LocalDate.parse(dataNascimento);
        this.cns = cns;
        this.email = email;
        this.nomeCuidador = nomeCuidador;
        this.telefoneCuidador = telefoneCuidador;
    }


}
