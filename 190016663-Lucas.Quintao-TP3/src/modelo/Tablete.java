package modelo;

import java.util.List;
import java.util.Scanner;

public class Tablete extends Produto {

	private String peso;
	private String tipoDeChocolate;
	private String recheio;

	public Tablete(double p, int quant, String d, String pesoTablete, String tipo, String recheioTablete) {
		preco = p;
		quantidadeEstoque = quant;
		nome = d;
		peso = pesoTablete;
		tipoDeChocolate = tipo;
		recheio = recheioTablete;

	}

	public Tablete() {

	}

	public String toString() {
		return "Nome do Produto: " + nome + "\n" + "Quantidade em estoque: " + quantidadeEstoque + "\n" + "Preço: "
				+ preco + "\n" + "Peso do Tablete: " + peso + "\n" + "Tipo de Chocolate: " + tipoDeChocolate + "\n"
				+ "Recheio do Tablete: " + recheio;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getTipoDeChocolate() {
		return tipoDeChocolate;
	}

	public void setTipoDeChocolate(String tipoDeChocolate) {
		this.tipoDeChocolate = tipoDeChocolate;
	}

	public String getRecheio() {
		return recheio;
	}

	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}

	public void alteraProduto() {
		System.out.println("Qual dado deseja alterar?\n" + "1-Nome\n" + "2-Quantidade em Estoque\n" + "3-Preço\n"
				+ "4-Peso\n" + "5-Tipo de Chocolate\n" + "6-Recheio\n" + "7-Sair para Menu");
		Scanner ler = new Scanner(System.in);
		int opcao = ler.nextInt();

		// laço para permitir varias alterações nos dados do produto
		while (opcao != 7) {
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
				System.out.println("Digite o novo peso do tablete (90g/120g/180g):");
				String novoPeso = ler.nextLine();
				this.setPeso(novoPeso);
				System.out.println("Peso alterado com sucesso!");
				break;

			case 5:
				ler.nextLine();
				System.out.println("Digite o novo tipo do chocolate (ao leite, branco, amargo...):");
				String novoTipo = ler.nextLine();
				this.setTipoDeChocolate(novoTipo);
				System.out.println("Tipo alterado com sucesso!");
				break;

			case 6:
				ler.nextLine();
				System.out.println("Digite o novo recheio do Tablete");
				String novoRecheio = ler.nextLine();
				this.setRecheio(novoRecheio);
				System.out.println("Recheio alterado com sucesso!");
				break;

			case 7:
				break;

			}

			System.out.println("Deseja alterar mais algum dado?\n" + "1-Nome\n" + "2-Quantidade em Estoque\n"
					+ "3-Preço\n" + "4-Peso\n" + "5-Tipo de Chocolate\n" + "6-Recheio\n" + "7-Sair para Menu");
			opcao = ler.nextInt();
		}

	}

}
