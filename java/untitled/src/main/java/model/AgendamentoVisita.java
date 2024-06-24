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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(Date dataVisita) {
        this.dataVisita = dataVisita;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getNomeAgenteSaude() {
        return nomeAgenteSaude;
    }

    public void setNomeAgenteSaude(String nomeAgenteSaude) {
        this.nomeAgenteSaude = nomeAgenteSaude;
    }

    public String getCnsPaciente() {
        return cnsPaciente;
    }

    public void setCnsPaciente(String cnsPaciente) {
        this.cnsPaciente = cnsPaciente;
    }

    public JList<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(JList<Vacina> vacinas) {
        this.vacinas = vacinas;
    }
}