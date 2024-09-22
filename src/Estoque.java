import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    // Metodo para adicionar um novo produto

    public void adicionarProduto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o código do produto: ");
        int codigo = scanner.nextInt();

        // Verificar se o produto com o código já existe

        if (buscarProdutoPorCodigo(codigo) != null) {
            System.out.println("Produto com esse código já existe.");
            return;
        }

        // Criar novo produto

        Produto produto = new Produto();
        produto.setCodigo(codigo);

        System.out.println("Digite o nome do produto: ");
        scanner.nextLine();  // Limpar buffer de nova linha
        String nome = scanner.nextLine();
        produto.setNome(nome);

        System.out.println("Digite o preço do produto: ");
        float preco = scanner.nextFloat();
        produto.setPreco(preco);

        System.out.println("Digite a quantidade do produto: ");
        int quant = scanner.nextInt();
        produto.setQuant(quant);

        // Adicionar produto ao estoque

        this.produtos.add(produto);
        System.out.println("Produto criado com sucesso!");
    }

    // Metodo para buscar produto por código

    public void buscarProduto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o código do produto: ");
        int codigo = scanner.nextInt();

        Produto produto = buscarProdutoPorCodigo(codigo);

        if (produto != null) {
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Quantidade em estoque: " + produto.getQuant());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // Metodo privado para buscar produto pelo código

    public Produto buscarProdutoPorCodigo(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
        // Retorna null se o produto não for encontrado
    }
}
