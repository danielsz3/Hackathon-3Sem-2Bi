package model;

public class Prontuario {
    private int idVacina;
    private int idAgendamentoVisita;

    public Prontuario(int idVacina, int idAgendamentoVisita) {
        this.idVacina = idVacina;
        this.idAgendamentoVisita = idAgendamentoVisita;
    }

    public int getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(int idVacina) {
        this.idVacina = idVacina;
    }

    public int getIdAgendamentoVisita() {
        return idAgendamentoVisita;
    }

    public void setIdAgendamentoVisita(int idAgendamentoVisita) {
        this.idAgendamentoVisita = idAgendamentoVisita;
    }
}
