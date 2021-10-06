package modelo;

import java.util.Scanner;
import java.util.*;

public class Endereco {
	private String estado;
	private String cidade;
	private Long cep;
	private String bairro;
	private int numero;

	public Endereco(String e, String c, Long cp, String b, int n) {
		estado = e;
		cidade = c;
		cep = cp;
		bairro = b;
		numero = n;
	}

	public String toString() {
		return "Endereço do cliente:\n" + "Estado: " + estado + "\n" + "Cidade: " + cidade + "\n" + "CEP: " + cep + "\n"
				+ "Bairro: " + bairro + "\n" + "Número: " + numero + "\n";
	}

	public Endereco() {

	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void cadastraEndereco() {

	}

}
