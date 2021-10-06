package modelo;

import java.util.List;
import java.util.Scanner;

public class Trufa extends Produto {
	private String tipo;
	private String recheio;

	public Trufa(double p, int quant, String d, String recheioTrufa, String tipoTrufa) {
		preco = p;
		quantidadeEstoque = quant;
		nome = d;
		recheio = recheioTrufa;
		tipo = tipoTrufa;
	}

	public Trufa() {

	}

	public String toString() {
		return "Nome do Produto: " + nome + "\n" + "Quantidade em estoque: " + quantidadeEstoque + "\n" + "Preço: "
				+ preco + "\n" + "Tipo da Trufa: " + tipo + "\n" + "Recheio da Trufa: " + recheio;

	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRecheio() {
		return recheio;
	}

	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}

	public void alteraProduto() {
		System.out.println("Qual dado deseja alterar?\n" + "1-Nome\n" + "2-Quantidade em Estoque\n" + "3-Preço\n"
				+ "4-Tipo de Trufa\n" + "5-Recheio\n" + "6-Sair para Menu");
		Scanner ler = new Scanner(System.in);
		int opcao = ler.nextInt();

		while (opcao != 6) {
			switch (opcao) {
			case 1:
				ler.nextLine();
				System.out.println("Digite o novo nome do produto:");
				String novoNome = ler.nextLine();
				this.setNome(novoNome);
				;
				System.out.println("Nome alterado com sucesso!");
				break;

			case 2:
				System.out.println("Digite a nova quantidade em estoque do produto:");
				int novaQuant = ler.nextInt();
				this.setQuantidadeEstoque(novaQuant);
				;
				System.out.println("Quantidade alterada com sucesso!");
				break;

			case 3:
				System.out.println("Digite o novo preço do produto:");
				Double novoPreco = ler.nextDouble();
				this.setPreco(novoPreco);
				;
				System.out.println("Preco alterado com sucesso!");
				break;

			case 4:
				ler.nextLine();
				System.out.println("Digite o novo tipo da Trufa (clássica ou artesanal:");
				String novoTipo = ler.nextLine();
				this.setTipo(novoTipo);
				System.out.println("Tipo alterado com sucesso!");
				break;

			case 5:
				ler.nextLine();
				System.out.println("Digite o novo recheio da Trufa");
				String novoRecheio = ler.nextLine();
				this.setRecheio(novoRecheio);
				System.out.println("Recheio alterado com sucesso!");
				break;

			case 6:
				break;

			}

			System.out.println("Deseja alterar mais algum dado?\n" + "1-Nome\n" + "2-Quantidade em Estoque\n"
					+ "3-Preço\n" + "4-Tipo de Chocolate\n" + "5-Recheio\n" + "6-Sair para Menu");
			opcao = ler.nextInt();
		}

	}

}
