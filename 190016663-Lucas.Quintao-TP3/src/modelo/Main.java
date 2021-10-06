package modelo;

import java.util.ArrayList;
import java.util.List;

import view.ViewMenu;

public class Main {
	static Cliente c2;
	static Cliente c3;
	static Tablete tablete2;
	static Trufa trufa2;
	static Bombom bombom2;
	static Venda v1;
	static Endereco end;
	static Endereco end2;

	public static void main(String[] args) {
		// declaração de arraylists para cadastros
		List<Cliente> clientes = new ArrayList<>();
		List<Venda> vendas = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();

		ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
		menu.setVisible(true);
		menu.setLocationRelativeTo(null);

		// Dados pré-cadastrados
		long cel = 99010747;
		end = new Endereco("DF", "Brasilia", (long) 77777, "Gama", 502);
		end2 = new Endereco("RJ", "Rio de Janeiro", (long) 66666, "Leblon", 555);
		c2 = new Cliente("lucas", cel, (long) 030557241, "prime", end);
		c3 = new Cliente("pedro", cel, (long) 82673342, "tradicional", end2);
		tablete2 = new Tablete(7.99, 100, "barra de chocolate", "90g", "ao leite", "gnache de chocolate");
		trufa2 = new Trufa(5.99, 2000, "trufa recheada", "morango", "caseira");
		bombom2 = new Bombom(2.99, 3000, "bombom caseiro recheado", "leite condensado");
		v1 = new Venda("credito", c2, tablete2, 2, "111111", 0, 10);
		clientes.add(c2);
		clientes.add(c3);
		produtos.add(tablete2);
		produtos.add(bombom2);

	}
}
