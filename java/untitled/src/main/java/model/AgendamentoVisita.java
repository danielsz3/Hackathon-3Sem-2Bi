package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class AgendamentoVisita {
    private Long id;
    private Date dataVisita;
    private String situacao;
    private String nomeAgenteSaude;
    private String cnsPaciente;
    private JList<Vacina> vacinas;

    public AgendamentoVisita(Long id, Date dataVisita, String situacao, String nomeAgenteSaude, String cnsPaciente, JList<Vacina> vacinas) {
        this.id = id;
        this.dataVisita = dataVisita;
        this.situacao = situacao;
        this.nomeAgenteSaude = nomeAgenteSaude;
        this.cnsPaciente = cnsPaciente;
        this.vacinas = vacinas;
    }

    public AgendamentoVisita(Date dataVisita, String situacao, String nomeAgenteSaude, String cnsPaciente, JList<Vacina> vacinas) {
        this.dataVisita = dataVisita;
        this.situacao = situacao;
        this.nomeAgenteSaude = nomeAgenteSaude;
        this.cnsPaciente = cnsPaciente;
        this.vacinas = vacinas;
    }
}