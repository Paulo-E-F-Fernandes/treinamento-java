package br.com.paulofernandes.equalshashcode.models;

import java.util.Objects;

public class ProdutoComEquals {

    // Código ÚNICO para o produto, por exemplo, "IHPDJ2320"
    private final String sku;

    // Nome do produto, por exemplo, "Impressora HP Deskjet 2320"
    private final String nome;

    public ProdutoComEquals(final String sku, final String nome) {
        this.sku = sku;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto [sku = " + sku + ", nome = " + nome + "]";
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final ProdutoComEquals that = (ProdutoComEquals) o;
        return Objects.equals(sku, that.sku);
    }

}
