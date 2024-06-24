package model;

public class AgenteSaude extends Pessoa {

    public AgenteSaude(Long id, String nome, String cpf, String celular) {
        super(id, nome, cpf, celular);
    }

    public AgenteSaude( String nome, String cpf, String celular) {
        super(0L, nome, cpf, celular);
    }

}