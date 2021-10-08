package modelo;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import view.ViewMenu;

/**
 * Classe para a defini��o do objeto Venda, seus atributos e m�todos
 * 
 * @author Lucas Pimentel Quint�o
 * @version final
 */

public class Venda {
	private int quantidadeVendida;
	private double valorFrete;
	private String codigoPedido;
	private String formaPagamento;
	private Cliente cliente;
	private Produto produto;
	private double valorTotal;

	/**
	 * Construtor da classe Venda
	 * 
	 * @param formaPag
	 * @param c              cliente que fez a compra
	 * @param produtoVendido produto vendido
	 * @param quantVend      quantidade vendida
	 * @param codigo         codigo do pedido
	 * @param valor          valor total
	 * @param frete          frete a ser pago
	 */

	public Venda(String formaPag, Cliente c, Produto produtoVendido, int quantVend, String codigo, double valor,
			double frete) {
		formaPagamento = formaPag;
		cliente = c;
		produto = produtoVendido;
		quantidadeVendida = quantVend;
		codigoPedido = codigo;
		valorFrete = frete;
		valorTotal = valor;

	}

	public String toString() {
		return "Cliente: " + cliente.getNome() + "\n" + "Frete: R$" + getValorFrete() + "\n" + "Forma de Pagamento: "
				+ getFormaPagamento() + "\n" + "Valor total do pedido: R$" + getValorTotal();

	}

	/**
	 * construtor padr�o
	 */

	public Venda() {

	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}

	public double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * Verifica se o c�digo do pedido digitado pelo usu�rio corresponde ao de uma
	 * venda cadastrada
	 * 
	 * @param vendas       lista de vendas cadastradas
	 * @param codigoPedido String contendo o c�digo da venda que ser� verificada
	 * @return true caso exita uma venda cadastrada com o c�digo passado, false caso
	 *         contr�rio
	 */

	public static boolean verificaVendaExiste(List<Venda> vendas, String codigoPedido) {
		boolean vendaExiste = false;

		for (int i = 0; i < vendas.size(); i++) {
			if (vendas.get(i).getCodigoPedido().equals(codigoPedido)) {
				vendaExiste = true;
			}
		}

		return vendaExiste;
	}

	/**
	 * Remove a venda da lista de vendas cadastradas
	 * 
	 * @param vendas lista de vendas cadastradas
	 * @return true caso a remo��o tenha sido bem sucedida, false caso contr�rio
	 */

	public boolean deletaVenda(List<Venda> vendas) {
		return vendas.remove(this);
	}

	/**
	 * Adiciona a venda na lista de vendas cadastradas e abate a quantidade vendida
	 * do produto do estoque
	 * 
	 * @param vendas       lista de vendas cadastradas
	 * @param produtoAtual produto vendido
	 * @param quantVendida quantidade do produto vendido
	 */

	public void cadastraVenda(List<Venda> vendas, Produto produtoAtual, int quantVendida) {
		produtoAtual.setQuantidadeEstoque((produtoAtual.getQuantidadeEstoque() - quantVendida));
		vendas.add(this);
	}

	/**
	 * Realiza o calculo do valor total da compra, multiplicando o pre�o do produto
	 * pela quantidade vendida e adicionando o valor do frete
	 * 
	 * @param produto      objeto do tipo Produto que foi vendido ao cliente
	 * @param quantVendida quantidade de produto vendido
	 * @param frete        valor do frete pago pelo cliente
	 * @return double do valor total da compra
	 */

	public static double defineValorTotal(Produto produto, int quantVendida, double frete) {
		double valorTotal = 0;

		valorTotal = produto.getPreco() * quantVendida;

		valorTotal = valorTotal + frete;
		return valorTotal;
	}

	/**
	 * Define o valor a ser pago pelo cliente dependendo do tipo de cliente que ele
	 * � (clientes prime n�o pagam frete)
	 * 
	 * @param cliente cliente que efetuou a compra
	 * @return double igual ao valor do frete que ser� pago pelo cliente
	 */

	public static double defineValorFrete(Cliente cliente) {
		double valorFrete = 9.99;

		if (cliente.getTipo().contains("prime")) {
			valorFrete = 0;
			return valorFrete;
		}

		return valorFrete;
	}

	/**
	 * gera um n�mero aleat�rio e depois o transforma para uma string, este n�mero
	 * corresponde ao c�digo do pedido realizado
	 * 
	 * @return String contendo o c�digo do pedido gerado
	 */

	public static String geraCodigoPedido() {
		Random gerador = new Random();

		int num = gerador.nextInt(999999);

		String codigoPedido = Integer.toString(num);

		return codigoPedido;
	}

	/**
	 * verifica se a quantidade solicitada do produto pelo cliente � correnpondente
	 * a quantidade de estoque dispon�vel daquele produto
	 * 
	 * @param quantVendida inteiro contendo a quantidade de produto solicitado pelo
	 *                     cliente
	 * @param produtoAtual produto comprado
	 * @return true caso o estoque seja insuficiente, false caso contr�tio
	 */

	public static boolean verificaEstoque(int quantVendida, Produto produtoAtual) {
		if (quantVendida > produtoAtual.getQuantidadeEstoque()) {
			return true;
		} else {
			return false;
		}
	}
}
