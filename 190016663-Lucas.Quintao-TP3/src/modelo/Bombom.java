package modelo;

import java.util.List;
import java.util.Scanner;

public class Bombom extends Produto {
	String recheio;

	public Bombom(double p, int quant, String d, String recheioBombom) {
		preco = p;
		quantidadeEstoque = quant;
		nome = d;
		recheio = recheioBombom;
	}

	public Bombom() {

	}

	public String toString() {
		return "Nome do Produto: " + nome + "\n" + "Quantidade em estoque: " + quantidadeEstoque + "\n" + "Preço: "
				+ preco + "\n" + "Recheio do Bombom: " + recheio;
	}

	public String getRecheio() {
		return recheio;
	}

	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}

	public void alteraProduto() {
		System.out.println("Qual dado deseja alterar?\n" + "1-Nome\n" + "2-Quantidade em Estoque\n" + "3-Preço\n"
				+ "4-Recheio\n" + "5-Sair para Menu");
		Scanner ler = new Scanner(System.in);
		int opcao = ler.nextInt();

		while (opcao != 5) {
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
				System.out.println("Digite o novo recheio do Bombom");
				String novoRecheio = ler.nextLine();
				this.setRecheio(novoRecheio);
				System.out.println("Recheio alterado com sucesso!");
				break;

			case 5:
				break;

			}

			System.out.println("Qual dado deseja alterar?\n" + "1-Nome\n" + "2-Quantidade em Estoque\n" + "3-Preço\n"
					+ "4-Recheio\n" + "5-Sair para Menu");
			opcao = ler.nextInt();
		}

	}

}
