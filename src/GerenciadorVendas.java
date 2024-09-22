import java.util.ArrayList;
import java.util.List;

public class GerenciadorVendas {
    private List<Venda> vendas;

    public GerenciadorVendas() {
        this.vendas = new ArrayList<>();
    }

    // Metodo para registrar uma nova venda

    public void registrarVenda(Venda venda) {
        vendas.add(venda);
        System.out.println("Venda registrada com sucesso!");
    }

    // Metodo para exibir todas as vendas registradas

    public void imprimirVendas() {
        System.out.println("Vendas registradas:");
        for (int i = 0; i < vendas.size(); i++) {
            System.out.println("Venda " + (i + 1) + ":");
            vendas.get(i).imprimirDetalhesVenda();
            System.out.println("----------------------------");
        }
    }
}

