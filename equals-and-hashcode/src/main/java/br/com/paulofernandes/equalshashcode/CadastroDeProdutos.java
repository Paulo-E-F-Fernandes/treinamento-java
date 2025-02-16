package br.com.paulofernandes.equalshashcode;

import br.com.paulofernandes.equalshashcode.models.Produto;
import br.com.paulofernandes.equalshashcode.models.ProdutoComEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class CadastroDeProdutos {

    private static final String CONTINUAR_SIM = "s";

    // A variável "produtos" é uma coleção de "Produto".
    // Como o "ArrayList" utiliza o "equals()" para fazer a comparação com o "contains", e a classe "Produto" não
    // teve o metodo "equals()" sobreescrito, vai comparar se é a mesma instância do objeto.
    private static final Collection<Produto> produtos = new ArrayList<>();

    // A variável "produtosComEquals" é uma coleção de "ProdutoComEquals", que teve apenas o metodo "equals()" sobreescrito.
    private static final Collection<ProdutoComEquals> produtosComEquals = new ArrayList<>();
    private static final Collection<ProdutoComEquals> produtosComEqualsHash = new HashSet<>();

    public static void main(final String[] args) {
        System.out.println("##### Cadastro de produtos #####\n");

        // Esta técnica de instanciar objetos no parenteses do "try" foi adicionado pelo Java 7.
        //
        // Como a instância da classe "Scanner" precisa ser fechado, quando a inicialização dela é
        // realizada dentro do parenteses do "try", o metodo "close()" do "Scanner" não precisará
        // ser chamado explicitamente, pois quando a instanciação é feita dentro maneira, o metodo
        // "close()" é chamado automaticamente no final do bloco "try".
        try (Scanner entrada = new Scanner(System.in)) {
            String continuar = CONTINUAR_SIM;

            while (CONTINUAR_SIM.equalsIgnoreCase(continuar)) {
                System.out.println("SKU: ");
                final String sku = entrada.nextLine();

                System.out.println("Nome: ");
                final String nome = entrada.nextLine();

                /* *** Produto sem equals e hashCode() *** */
                /* OBS.: Para a classe "Produto", a validação não funcionará,
                pois não há a implementação dos metodos "equals" e "hashcode". */
                final Produto produto = new Produto(sku, nome);
                adicionaProduto(produtos, produto);

                /* *** Produto somente com o equals() *** */
                // ArrayList
                final ProdutoComEquals produtoComEquals = new ProdutoComEquals(sku, nome);
                adicionaProduto(produtosComEquals, produtoComEquals);
                // HashSet
                /* OBS.: Para a HashSet da classe "ProdutoComEquals", a validação não funcionará,
                pois não há a implementação dos metodos "hashcode". */
                adicionaProduto(produtosComEqualsHash, produtoComEquals);

                System.out.println("\nDeseja cadastrar outro produto? (s/n)");
                continuar = entrada.nextLine();
            }

            exibeInformacoesDosProdutos();

            System.out.println("Cadastro de produtos - Finalizado!");
        }
    }

    private static <T> void adicionaProduto(final Collection<T> produtos, final T produto) {
        if (produtos.contains(produto)) {
            System.err.println("Esse produto já foi cadastrado. Utilize outro SKU!");
        } else {
            produtos.add(produto);
            System.out.println("Produto cadastrado com sucesso!");
        }
    }

    private static void exibeInformacoesDosProdutos() {
        // Adicionado no Java 8
        // O "forEach" da classe "Collection" percorre todos os elementos que foram adicionados
        // e aplica a ação indicada no metodo passado por parâmetro.
        // O "System.out::println" recebe como parâmetro o elemento da Collection que está sendo
        // percorrida e realizará a impressão no console o conteúdo do  "toeString" do objeto.
        System.out.println("Produtos sem equals() e hashCode()");
        produtos.forEach(System.out::println);

        System.out.println("Produtos com equals() - ArrayList");
        produtosComEquals.forEach(System.out::println);

        System.out.println("Produtos com equals() - HashSet");
        produtosComEqualsHash.forEach(System.out::println);
    }

}