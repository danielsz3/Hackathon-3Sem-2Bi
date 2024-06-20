package model;

import java.time.LocalDate;

public class Paciente extends Pessoa {
    private int idEndereco;
    private LocalDate dataNascimento;
    private String cns;
    private String email;
    private String nomeCuidador;
    private String telefoneCuidador;

    public Paciente(int id, String nome, String cpf, String celular, int idEndereco, String dataNascimento, String cns, String email, String nomeCuidador, String telefoneCuidador) {
        super(id, nome, cpf, celular);
        this.idEndereco = idEndereco;
        this.dataNascimento = LocalDate.parse(dataNascimento);
        this.cns = cns;
        this.email = email;
        this.nomeCuidador = nomeCuidador;
        this.telefoneCuidador = telefoneCuidador;
    }


}
