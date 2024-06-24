package model;

public class Vacina {
    private Long id; // Alterado de int para Integer
    private String nomeVacina;
    private String descricao;

    public Vacina(Long id, String nomeVacina, String descricao) {
        this.id = id;
        this.nomeVacina = nomeVacina;
        this.descricao = descricao;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
