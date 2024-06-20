package model;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private String celular;

    public Pessoa(String nome, String cpf, String celular) {
        this.id = 0;
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
    }
}

