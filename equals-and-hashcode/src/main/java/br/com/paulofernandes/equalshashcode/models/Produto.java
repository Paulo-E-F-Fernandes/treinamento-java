package br.com.paulofernandes.equalshashcode.models;

public class Produto {

    // Código ÚNICO para o produto, por exemplo, "IHPDJ2320"
    private final String sku;

    // Nome do produto, por exemplo, "Impressora HP Deskjet 2320"
    private final String nome;

    public Produto(final String sku, final String nome) {
        this.sku = sku;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto [sku = " + sku + ", nome = " + nome + "]";
    }
}
