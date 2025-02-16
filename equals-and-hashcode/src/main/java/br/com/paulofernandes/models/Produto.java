package br.com.paulofernandes.models;

public class Produto {

    // Código ÚNICO para o produto, por exemplo, "IHPDJ2320"
    private String sku;

    // Nome do produto, por exemplo, "Impressora HP Deskjet 2320"
    private String nome;

    public Produto(final String sku, final String nome) {
        this.sku = sku;
        this.nome = nome;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(final String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto [sku = " + sku + ", nome = " + nome + "]";
    }
}
