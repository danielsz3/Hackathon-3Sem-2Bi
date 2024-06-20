package model;

import java.util.Date;

public class AgendamentoVisita {
    private int id;
    private Date dataVisita;
    private String situacao;
    private AgenteSaude agenteSaude;
    private Paciente paciente;

    public AgendamentoVisita(int id, Date dataVisita, String situacao, AgenteSaude agenteSaude, Paciente paciente) {
        this.id = id;
        this.dataVisita = dataVisita;
        this.situacao = situacao;
        this.agenteSaude = agenteSaude;
        this.paciente = paciente;
    }

}