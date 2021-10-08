package modelo;

/**
 * Classe para a definição do objeto Trufa e seus atributos
 * 
 * @author Lucas Pimentel Quintão
 * @version final
 */

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

}
