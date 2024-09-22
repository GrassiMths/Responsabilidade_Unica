import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorVendas gerenciadorVendas = new GerenciadorVendas();
        Estoque estoque = new Estoque();
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("Menu:");
            System.out.println("1. Criar Produto");
            System.out.println("2. Realizar Venda");
            System.out.println("3. Buscar Produto");
            System.out.println("4. Historico De Vendas");
            System.out.println("5. Sair");
            System.out.print("Qual sua escolha: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    estoque.adicionarProduto();
                    break;

                case 2:
                    Venda venda = new Venda();
                    boolean produtoConfirmado = false;
                    Produto produto = null;

                    while (!produtoConfirmado) {
                        System.out.println("Digite o código do produto que deseja vender: ");
                        int codigo = scanner.nextInt();

                        produto = estoque.buscarProdutoPorCodigo(codigo);

                        if (produto != null) {
                            // Exibe as informações do produto encontrado
                            System.out.println("Produto encontrado:");
                            System.out.println("Nome: " + produto.getNome());
                            System.out.println("Código: " + produto.getCodigo());
                            System.out.println("Preço: " + produto.getPreco());
                            System.out.println("Quantidade: " + produto.getQuant());

                            // Pergunta ao usuário se esse é o produto correto
                            System.out.print("Este é o produto que deseja vender? (s/n): ");
                            String resposta = scanner.next();

                            if (resposta.equalsIgnoreCase("s")) {
                                produtoConfirmado = true;  // Se o produto for confirmado, o loop termina
                                venda.adicionarProdutoVendido(produto);
                                System.out.println("Produto adicionado à venda.");
                            } else {
                                System.out.println("Vamos tentar de novo.");
                            }
                        } else {
                            System.out.println("Produto não encontrado. Tente novamente.");
                        }
                    }

                    // Registrar a venda no Gerenciador de Vendas
                    gerenciadorVendas.registrarVenda(venda);
                    break;

                case 3:
                    estoque.buscarProduto();
                    break;

                case 4:
                    gerenciadorVendas.imprimirVendas();
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Escolha inválida");
            }
        } while (escolha != 5);
    }
}
