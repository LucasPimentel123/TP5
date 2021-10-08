package modelo;

/**
 * Classe para a definição do objeto Bombom e seus atributos
 * 
 * @author lucas Pimentel Quintão
 * @version final
 */
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

}
