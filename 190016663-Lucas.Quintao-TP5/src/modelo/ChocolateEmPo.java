package modelo;

/**
 * Classe para a definição do objeto Chocolate em Pó e seus atributos
 * 
 * @author Lucas Pimentel Quintão
 * @version final
 */

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

}
