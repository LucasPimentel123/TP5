package modelo;

import java.util.Scanner;
import java.util.*;

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

	public static boolean verificaClienteExiste(String nome, List<Cliente> clientes) {
		boolean clienteExiste = false;

		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getNome().equals(nome)) {
				clienteExiste = true;
			}
		}

		return clienteExiste;
	}

	public boolean cadastraCliente(List<Cliente> clientes) {

		boolean clienteJaExiste = verificaIgual(this, clientes);

		if (clienteJaExiste == false) {
			clientes.add(this);
		}

		return clienteJaExiste;
	}

	public boolean verificaIgual(Cliente clienteAtual, List<Cliente> clientes) {
		boolean clienteJaExiste = false;

		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getNome().equals(clienteAtual.getNome())
					|| clientes.get(i).getCpf() == clienteAtual.getCpf()) {

				clienteJaExiste = true;
			}
		}

		return clienteJaExiste;
	}

	public boolean deletaCliente(List<Cliente> clientes) {

		return clientes.remove(this);

	}

	public void editaCliente(Cliente clienteEditado) {
		System.out.println("Qual dado deseja alterar?\n" + "1-Nome\n" + "2-Telefone\n" + "3-Tipo\n" + "4-CPF\n"
				+ "5-Voltar ao menu");
		Scanner ler = new Scanner(System.in);
		int opcao = ler.nextInt();

		// laço para permitir varias alterações nos dados do cliente
		while (opcao != 5) {
			switch (opcao) {
			case 1:
				ler.nextLine();
				System.out.println("Digite o novo nome do cliente:");
				String novoNome = ler.nextLine();
				clienteEditado.setNome(novoNome);
				System.out.println("Nome alterado com sucesso!");
				break;

			case 2:
				System.out.println("Digite o novo telefone do cliente:");
				Long novoTelefone = ler.nextLong();
				clienteEditado.setTelefone(novoTelefone);
				;
				System.out.println("Telefone alterado com sucesso!");
				break;

			case 3:
				ler.nextLine();
				System.out.println("Digite o novo tipo do cliente:");
				String novoTipo = ler.nextLine();
				clienteEditado.setTipo(novoTipo);
				;
				System.out.println("Tipo alterado com sucesso!");
				break;

			case 4:
				System.out.println("Digite o novo CPF do cliente:");
				Long novoCPF = ler.nextLong();
				clienteEditado.setCpf(novoCPF);
				System.out.println("CPF alterado com sucesso:");
				break;

			case 5:
				break;
			}

			System.out.println("Deseja alterar mais algum dado?\n" + "1-Nome\n" + "2-Telefone\n" + "3-Tipo\n"
					+ "4-CPF\n" + "5-Voltar ao menu");
			opcao = ler.nextInt();
		}
	}

	public void buscaCliente(List<Cliente> clientes) {
		String nomeParaBusca; // varíavel que será definida pelo usuário para a busca
		boolean clienteExiste = false;

		System.out.println("Digite o nome do cliente que deseja buscar:");
		Scanner ler = new Scanner(System.in);

		nomeParaBusca = ler.nextLine();
		nomeParaBusca = nomeParaBusca.toLowerCase();

		// loop para a comparar e encontrar o nome do cliente digitado pelo usuário
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getNome().contains(nomeParaBusca)) {
				clienteExiste = true;

				System.out.println(clientes.get(i).toString());
				System.out.println(clientes.get(i).getEnderecoCliente().toString());

				System.out.println("Gostaria de alterar/deletar os dados deste cliente?\n" + "1-Alterar dados\n"
						+ "2-Deletar Cliente\n" + "3-Voltar ao menu");
				int opcao = ler.nextInt();

				while (!(opcao == 1 || opcao == 2 || opcao == 3)) {
					System.out.println("Por favor digite uma opção válida");
					opcao = ler.nextInt();
				}

				if (opcao == 1) {
					editaCliente(clientes.get(i));

				}
				if (opcao == 2) {
					deletaCliente(clientes);

				}
				if (opcao == 3) {
					break;

				}

			}

		}

		// Caso do usuário digitar um nome de cliente que não existe
		if (clienteExiste == false) {
			System.out.println("Cliente não encontrado");
		}

	}
}
