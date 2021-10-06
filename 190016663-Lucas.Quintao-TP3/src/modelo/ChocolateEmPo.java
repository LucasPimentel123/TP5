package modelo;

import java.util.List;
import java.util.Scanner;

public class ChocolateEmPo extends Produto {
	private String tamanho;
	private String tipo;
	private String chocolate;

	public ChocolateEmPo(double p, int quant, String d, String tam, String t, String choc) {
		preco = p;
		quantidadeEstoque = quant;
		nome = d;
		tamanho = tam;
		tipo = t;
		chocolate = choc;
	}

	public ChocolateEmPo() {

	}

	public String toString() {
		return "Nome do Produto: " + nome + "\n" + "Quantidade em estoque: " + quantidadeEstoque + "\n" + "Preço:"
				+ preco + "\n" + "Tamanho do saco: " + tamanho + "\n" + "Tipo: " + tipo + "\n" + "Chocolate: "
				+ chocolate;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getChocolate() {
		return chocolate;
	}

	public void setChocolate(String chocolate) {
		this.chocolate = chocolate;
	}

	public void alteraProduto() {
		System.out.println("Qual dado deseja alterar?\n" + "1-Nome\n" + "2-Quantidade em Estoque\n" + "3-Preço\n"
				+ "4-Tamanho do Saco\n" + "5-Tipo de Chocolate\n" + "6-Sabor do Chocolate\n" + "7-Sair para Menu");
		Scanner ler = new Scanner(System.in);
		int opcao = ler.nextInt();

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
				System.out.println("Digite o novo tamanho do saco (pequeno, médio ou grande):");
				String novoTamanho = ler.nextLine();
				this.setTamanho(novoTamanho);
				System.out.println("Tamanho alterado com sucesso!");
				break;

			case 5:
				ler.nextLine();
				System.out.println("Digite o novo tipo de chocolate em pó (cremoso ou tradicional)");
				String novoTipo = ler.nextLine();
				this.setTipo(novoTipo);
				System.out.println("Tipo de chocolate alterado com sucesso!");
				break;

			case 6:
				ler.nextLine();
				System.out.println("Digite o novo sabor do chocolate(ao leite, branco, amargo...)");
				String novoChocolate = ler.nextLine();
				this.setChocolate(novoChocolate);
				System.out.println("Sabor do chocolate alterado com sucesso!");
				break;

			case 7:
				break;

			}

			System.out.println("Deseja alterar mais algum dado?\n" + "1-Nome\n" + "2-Quantidade em Estoque\n"
					+ "3-Preço\n" + "4-Tamanho do Saco\n" + "5-Tipo de Chocolate\n" + "6-Sabor do Chocolate\n"
					+ "7-Sair para Menu");
			opcao = ler.nextInt();
		}

	}

}
