package modelo;

/**
 * Classe para a defini��o do objeto Bombom e seus atributos
 * 
 * @author lucas Pimentel Quint�o
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
		return "Nome do Produto: " + nome + "\n" + "Quantidade em estoque: " + quantidadeEstoque + "\n" + "Pre�o: "
				+ preco + "\n" + "Recheio do Bombom: " + recheio;
	}

	public String getRecheio() {
		return recheio;
	}

	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}

}
