package modelo;

import java.util.List;
import java.util.Scanner;

public abstract class Produto {
	protected double preco;
	protected int quantidadeEstoque;
	protected String nome;

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static boolean verificaProdutoExiste(String nomeProduto, List<Produto> produtos) {
		boolean produtoExiste = false;

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getNome().equals(nomeProduto)) {
				produtoExiste = true;
			}
		}

		return produtoExiste;
	}

	public boolean cadastraProduto(List<Produto> produtos) {
		boolean produtoJaExiste = false;

		produtoJaExiste = verificaIgual(this, produtos);

		if (produtoJaExiste == false) {
			produtos.add(this);
		}

		return produtoJaExiste;
	};

	public boolean verificaIgual(Produto produtoAtual, List<Produto> produtos) {
		boolean produtoJaExiste = false;

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getNome().equals(produtoAtual.getNome())) {
				produtoJaExiste = true;
			}
		}

		return produtoJaExiste;
	}

	public boolean deletaProduto(List<Produto> produtos) {
		return produtos.remove(this);

	}

	public abstract void alteraProduto();

	public void buscaProduto(List<Produto> produtos) {
		String nomeParaBusca;
		boolean produtoExiste = false;

		System.out.println("Digite o nome do produto que deseja buscar:");
		Scanner ler = new Scanner(System.in);

		nomeParaBusca = ler.nextLine();
		nomeParaBusca = nomeParaBusca.toLowerCase();

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getNome().contains(nomeParaBusca)) {
				produtoExiste = true;

				System.out.println(produtos.get(i).toString());

				System.out.println("Gostaria de alterar/deletar os dados deste produto?\n" + "1-Alterar dados\n"
						+ "2-Deletar Produto\n" + "3-Voltar ao menu");
				int opcao = ler.nextInt();

				while (!(opcao == 1 || opcao == 2 || opcao == 3)) {
					System.out.println("Por favor digite uma opção válida");
					opcao = ler.nextInt();
				}

				if (opcao == 1) {

					produtos.get(i).alteraProduto();

				}
				if (opcao == 2) {
					// deletaProduto(i, produtos);

				}
				if (opcao == 3) {
					break;

				}

			}
		}

		if (produtoExiste == false) {
			System.out.println("Produto não encontrado!");
		}
	}
}
