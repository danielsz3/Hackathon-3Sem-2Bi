package model;

public class AgenteSaude extends Pessoa {
    private String senha;

    public AgenteSaude(int id, String nome, String cpf, String celular, String senha) {
        super(id, nome, cpf, celular);
        this.senha = senha;
    }


}