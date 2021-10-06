package modelo;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import view.ViewMenu;

public class Venda {
	private int quantidadeVendida;
	private double valorFrete;
	private String codigoPedido;
	private String formaPagamento;
	private Cliente cliente;
	private Produto produto;
	private double valorTotal;

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

	public static boolean verificaVendaExiste(List<Venda> vendas, String codigoPedido) {
		boolean vendaExiste = false;
		
		for (int i = 0; i < vendas.size(); i++) {
			if (vendas.get(i).getCodigoPedido().equals(codigoPedido)) {
				vendaExiste = true;
			}
		}

		return vendaExiste;
	}

	public boolean deletaVenda(List<Venda> vendas) {
		return vendas.remove(this);
	}

	public void cadastraVenda(List<Venda> vendas, Produto produtoAtual, int quantVendida) {
		produtoAtual.setQuantidadeEstoque((produtoAtual.getQuantidadeEstoque() - quantVendida));
		vendas.add(this);
	}

	public static double defineValorTotal(Produto produto, int quantVendida, double frete) {
		double valorTotal = 0;

		valorTotal = produto.getPreco() * quantVendida;

		valorTotal = valorTotal + frete;
		return valorTotal;
	}

	public static double defineValorFrete(Cliente cliente) {
		double valorFrete = 9.99;

		if (cliente.getTipo().contains("prime")) {
			valorFrete = 0;
			return valorFrete;
		}

		return valorFrete;
	}

	public static String geraCodigoPedido() {
		Random gerador = new Random();

		int num = gerador.nextInt(999999);
		
		String codigoPedido = Integer.toString(num);
		
		return codigoPedido;
	}

	public static boolean verificaEstoque(int quantVendida, Produto produtoAtual) {
		if (quantVendida > produtoAtual.getQuantidadeEstoque()) {
			return true;
		} else {
			return false;
		}
	}
}
