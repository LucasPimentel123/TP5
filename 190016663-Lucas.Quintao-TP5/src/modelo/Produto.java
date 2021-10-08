package modelo;

import java.util.List;
import java.util.Scanner;

/**
 * Definição da classe abstrata Produto e dos metódos e atributos comuns a todos
 * os objetos que herdarão ela
 * 
 * @author Lucas Pimentel Quintão
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
	 * Verifica se o produto em questão já esta na lista de produtos cadastrados
	 * 
	 * @param nomeProduto String contendo o nome do produto para a verificação
	 * @param produtos    lista de produtos cadastrados
	 * @return false caso o produto ainda não tenha sido cadastrado, true caso
	 *         contrário
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
	 * Adiciona o produto na lista de produtos cadastrados, caso não tenha outro
	 * produto com o mesmo nome ja cadastrado
	 * 
	 * @param produtos lista de produtos cadastrados
	 * @return false caso o produto tenha sido adicionado com sucesso, true caso jjá
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
	 * @return true caso a rmoção tenha sido bem sucedida, false caso contrário
	 */

	public boolean deletaProduto(List<Produto> produtos) {
		return produtos.remove(this);

	}

}
