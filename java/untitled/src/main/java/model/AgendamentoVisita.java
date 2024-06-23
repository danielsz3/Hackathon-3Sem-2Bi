package model;

import java.util.ArrayList;
import java.util.Date;

public class AgendamentoVisita {
    private Long id;
    private Date dataVisita;
    private String situacao;
    private AgenteSaude agenteSaude;
    private Paciente paciente;
    private ArrayList<Vacina> vacinas;
    private AgendamentoVisita agendamentoVisita;

    public AgendamentoVisita(Long id, Date dataVisita, String situacao, AgenteSaude agenteSaude, Paciente paciente, ArrayList<Vacina> vacinas, AgendamentoVisita agendamentoVisita) {
        this.id = id;
        this.dataVisita = dataVisita;
        this.situacao = situacao;
        this.agenteSaude = agenteSaude;
        this.paciente = paciente;
        this.vacinas = vacinas;
        this.agendamentoVisita = agendamentoVisita;
    }
}