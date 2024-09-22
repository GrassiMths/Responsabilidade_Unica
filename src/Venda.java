import java.util.ArrayList;
import java.util.List;

public class Venda {

        private List<Produto> produtosVendidos;

        public Venda() {
            this.produtosVendidos = new ArrayList<>();
        }

        // Metodo para adicionar um produto à lista de produtos vendidos

        public void adicionarProdutoVendido(Produto produto) {
            produtosVendidos.add(produto);
        }

        // Metodo para calcular o valor total da venda

        public float calcularValorTotalVenda() {
            float total = 0;
            for (Produto produto : produtosVendidos) {
                total += produto.calcularValorTotal();
            }
            return total;
        }

        // Metodo para exibir os detalhes da venda

        public void imprimirDetalhesVenda() {
            System.out.println("Detalhes da Venda:");
            for (Produto produto : produtosVendidos) {
                System.out.println("Produto: " + produto.getNome() + " | Código: " + produto.getCodigo());
                System.out.println("Preço: " + produto.getPreco() + " | Quantidade: " + produto.getQuant());
                System.out.println("Subtotal: " + produto.calcularValorTotal());
            }
            System.out.println("Valor total da venda: " + calcularValorTotalVenda());
        }

    }

