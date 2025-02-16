package br.com.paulofernandes;

import br.com.paulofernandes.models.Produto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class CadastroDeProdutos {

    private static final String CONTINUAR_SIM = "s";

    public static void main(final String[] args) {
        final Collection<Produto> produtos = new ArrayList<>();

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

                final Produto produto = new Produto(sku, nome);

                /* OBS.: Para a classe "Produto", a validação não funcionará, pois não há a
                implementação dos metodos "equals" e "hashcode". */
                if (produtos.contains(produto)) {
                    System.err.println("Esse produto já foi cadastrado. Utilize outro SKU!");
                } else {
                    produtos.add(produto);
                    System.out.println("Produto cadastrado com sucesso!");
                }

                System.out.println("\nDeseja cadastrar outro produto? (s/n)");
                continuar = entrada.nextLine();
            }

            // Adicionado no Java 8
            // O "forEach" da classe "Collection" percorre todos os elementos que foram adicionados
            // e aplica a ação indicada no metodo passado por parâmetro.
            // O "System.out::println" recebe como parâmetro o elemento da Collection que está sendo
            // percorrida e realizará a impressão no console o conteúdo do  "toeString" do objeto.
            produtos.forEach(System.out::println);
            System.out.println("Cadastro de produtos - Finalizado!");
        }
    }

}