package modelo;

import java.util.*;

/**
 * Classe para a definição do objeto cliente, seus atributos e métodos
 * 
 * @author Lucas Pimentel Quintão
 * @version final
 */

public class Cliente {
	private String nome;
	private Long telefone;
	private Long cpf;
	private String tipo;
	private Endereco enderecoCliente;

	public Cliente(String n, Long tel, Long cp, String tp, Endereco end) {
		nome = n;
		telefone = tel;
		cpf = cp;
		tipo = tp;
		enderecoCliente = end;

	}

	public String toString() {
		return "Nome do cliente: " + nome + "\n" + "Telefone:" + telefone + "\n" + "Tipo:" + tipo + "\n" + "CPF: " + cpf
				+ "\n";
	}

	public Cliente() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Endereco getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(Endereco enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	/**
	 * Verifica se o cliente ja foi cadastrado, para isso recebe o nome do cliente e
	 * compara com os nomes dos clientes já cadastrados
	 * 
	 * @param nome     string que contém o nome do cliente para que deseja confirmar
	 *                 se já esta cadastrado
	 * @param clientes ArrayList de todos os clientes ja cadastrados para a
	 *                 comparação
	 * @return verdadeiro no caso do cliente já estar cadastrado, caso contrário
	 *         falso
	 */

	public static boolean verificaClienteExiste(String nome, List<Cliente> clientes) {
		boolean clienteExiste = false;

		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getNome().equals(nome)) {
				clienteExiste = true;
			}
		}

		return clienteExiste;
	}

	/**
	 * Sobrecarga do método para verificar se o cliente já está cadastrado, só que
	 * dessa vez rececbendo como parametro um objeto do tipo Cliente
	 * 
	 * @param clienteAtual objeto do tipo cliente para a verificação
	 * @param clientes     lista de clientes cadastrados
	 * @return verdadeiro no caso do cliente já estar cadastrado, caso contrário
	 *         falso
	 */

	public boolean verificaClienteExiste(Cliente clienteAtual, List<Cliente> clientes) {
		boolean clienteExiste = false;

		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getNome().equals(clienteAtual.getNome())
					|| clientes.get(i).getCpf() == clienteAtual.getCpf()) {

				clienteExiste = true;
			}
		}

		return clienteExiste;
	}

	/**
	 * Adiciona o cliente e seus dados na lista de clientes cadastrados, e antes de
	 * adicionar chama outra função para verificar se não existe algum outro cliente
	 * com o mesmo nome ou CPF.
	 * 
	 * @param clientes lista de clientes cadastrados
	 * @return retorna false no caso do cadastro ter sido feito, e true no caso de
	 *         falha
	 */

	public boolean cadastraCliente(List<Cliente> clientes) {

		boolean clienteJaExiste = verificaClienteExiste(this, clientes);

		if (clienteJaExiste == false) {
			clientes.add(this);
		}

		return clienteJaExiste;
	}

	/**
	 * Remove Cliente cadastrado da lista de clientes cadastrados
	 * 
	 * @param clientes ArrayList de clientes cadastrados
	 * @return true no caso da remoção ter sido bem sucedida e false caso contrário
	 */

	public boolean deletaCliente(List<Cliente> clientes) {

		return clientes.remove(this);

	}
}
