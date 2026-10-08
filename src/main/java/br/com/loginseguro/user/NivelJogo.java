package br.com.loginseguro.user;

public enum NivelJogo {
    FACIL("Fácil"),
    MEDIO("Médio"),
    DIFICIL("Difícil");

    private final String nome;

    NivelJogo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
