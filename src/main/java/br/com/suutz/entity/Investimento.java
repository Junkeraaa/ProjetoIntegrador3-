package br.com.suutz.entity;

class Investimento {
    private String nome;
    private double taxa;

    public Investimento(String nome) {
        this.nome = nome;
        this.taxa = 0.0; // Inicialmente, a taxa é zero.
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double getTaxa() {
        return taxa;
    }

    public String getNome() {
        return nome;
    }
}