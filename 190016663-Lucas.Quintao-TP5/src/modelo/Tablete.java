package modelo;

/**
 * Classe para a definição do objeto Tablete e seus atributos
 * 
 * @author Lucas Pimentel Quintão
 * @version final
 */
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

}
