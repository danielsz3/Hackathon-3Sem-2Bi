package model;

public abstract class Pessoa {
    private Long id;
    private String nome;
    private String cpf;
    private String celular;

    public Pessoa(Long id,String nome, String cpf, String celular) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
    }
}

