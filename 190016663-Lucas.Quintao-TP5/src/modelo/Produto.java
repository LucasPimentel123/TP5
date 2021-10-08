package modelo;

import java.util.List;
import java.util.Scanner;

/**
 * Defini��o da classe abstrata Produto e dos met�dos e atributos comuns a todos
 * os objetos que herdar�o ela
 * 
 * @author Lucas Pimentel Quint�o
 * @version final
 */

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

	/**
	 * Verifica se o produto em quest�o j� esta na lista de produtos cadastrados
	 * 
	 * @param nomeProduto String contendo o nome do produto para a verifica��o
	 * @param produtos    lista de produtos cadastrados
	 * @return false caso o produto ainda n�o tenha sido cadastrado, true caso
	 *         contr�rio
	 */

	public static boolean verificaProdutoExiste(String nomeProduto, List<Produto> produtos) {
		boolean produtoExiste = false;

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getNome().equals(nomeProduto)) {
				produtoExiste = true;
				break;
			}
		}

		return produtoExiste;
	}

	/**
	 * Adiciona o produto na lista de produtos cadastrados, caso n�o tenha outro
	 * produto com o mesmo nome ja cadastrado
	 * 
	 * @param produtos lista de produtos cadastrados
	 * @return false caso o produto tenha sido adicionado com sucesso, true caso jj�
	 *         exista outro produto com o mesmo nome
	 */

	public boolean cadastraProduto(List<Produto> produtos) {
		boolean produtoJaExiste = false;

		produtoJaExiste = verificaProdutoExiste(this.getNome(), produtos);

		if (produtoJaExiste == false) {
			produtos.add(this);
		}

		return produtoJaExiste;
	};

	/**
	 * Remove produto da lista de produtos cadastrados
	 * 
	 * @param produtos lista de produtos cadastrados
	 * @return true caso a rmo��o tenha sido bem sucedida, false caso contr�rio
	 */

	public boolean deletaProduto(List<Produto> produtos) {
		return produtos.remove(this);

	}

}
