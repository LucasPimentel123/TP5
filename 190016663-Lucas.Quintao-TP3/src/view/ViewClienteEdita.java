package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Endereco;
import modelo.Produto;
import modelo.Venda;

public class ViewClienteEdita extends JFrame {
	private JPanel janela;
	private JTextField nomeCliente;
	private JTextField telCliente;
	private JTextField cpfCliente;
	private JTextField tipoCliente;
	private JTextField estadoCliente;
	private JTextField cidadeCliente;
	private JTextField cepCliente;
	private JTextField bairroCliente;
	private JTextField numCliente;

	public ViewClienteEdita(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas, Cliente clienteAtual) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 513);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		JLabel titulo = new JLabel("Atualização de dados Cliente\r\n");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(100, 20, 250, 19);
		janela.add(titulo);

		nomeCliente = new JTextField(clienteAtual.getNome(), 200);
		nomeCliente.setBounds(42, 74, 133, 19);
		janela.add(nomeCliente);
		nomeCliente.setColumns(10);

		JLabel nome = new JLabel("Novo nome do cliente\r\n");
		nome.setFont(new Font("Arial", Font.PLAIN, 10));
		nome.setBounds(42, 54, 200, 13);
		janela.add(nome);

		telCliente = new JTextField(String.valueOf(clienteAtual.getTelefone()), 200);
		telCliente.setBounds(42, 119, 133, 19);
		janela.add(telCliente);
		telCliente.setColumns(10);

		JLabel tel = new JLabel("Novo telefone do cliente\r\n");
		tel.setFont(new Font("Arial", Font.PLAIN, 10));
		tel.setBounds(40, 103, 200, 13);
		janela.add(tel);

		cpfCliente = new JTextField(String.valueOf(clienteAtual.getCpf()), 200);
		cpfCliente.setBounds(42, 163, 133, 19);
		janela.add(cpfCliente);
		cpfCliente.setColumns(10);

		JLabel cpf = new JLabel("Novo CPF do cliente");
		cpf.setFont(new Font("Arial", Font.PLAIN, 10));
		cpf.setBounds(42, 148, 200, 13);
		janela.add(cpf);

		tipoCliente = new JTextField(clienteAtual.getTipo(), 200);
		tipoCliente.setBounds(42, 204, 133, 19);
		janela.add(tipoCliente);
		tipoCliente.setColumns(10);

		JLabel tipo = new JLabel("Novo tipo de cliente (prime ou tradicional)");
		tipo.setFont(new Font("Arial", Font.PLAIN, 10));
		tipo.setBounds(42, 192, 200, 13);
		janela.add(tipo);

		estadoCliente = new JTextField(clienteAtual.getEnderecoCliente().getEstado(), 200);
		estadoCliente.setBounds(42, 253, 133, 19);
		janela.add(estadoCliente);
		estadoCliente.setColumns(10);

		JLabel estado = new JLabel("Nova unidade Federativa do cliente: ");
		estado.setFont(new Font("Arial", Font.PLAIN, 10));
		estado.setBounds(42, 241, 200, 13);
		janela.add(estado);

		JLabel cidade = new JLabel("Nova cidade do cliente: ");
		cidade.setFont(new Font("Arial", Font.PLAIN, 10));
		cidade.setBounds(42, 282, 200, 13);
		janela.add(cidade);

		cidadeCliente = new JTextField(clienteAtual.getEnderecoCliente().getCidade(), 200);
		cidadeCliente.setBounds(42, 296, 133, 19);
		janela.add(cidadeCliente);
		cidadeCliente.setColumns(10);

		JLabel cep = new JLabel("Novo CEP do cliente:");
		cep.setFont(new Font("Arial", Font.PLAIN, 10));
		cep.setBounds(42, 325, 200, 13);
		janela.add(cep);

		cepCliente = new JTextField(String.valueOf(clienteAtual.getEnderecoCliente().getCep()), 200);
		cepCliente.setBounds(42, 337, 133, 19);
		janela.add(cepCliente);
		cepCliente.setColumns(10);

		JLabel bairro = new JLabel("Novo bairro do cliente");
		bairro.setFont(new Font("Arial", Font.PLAIN, 10));
		bairro.setBounds(42, 360, 200, 13);
		janela.add(bairro);

		bairroCliente = new JTextField(clienteAtual.getEnderecoCliente().getBairro(), 200);
		bairroCliente.setBounds(42, 375, 133, 19);
		janela.add(bairroCliente);
		bairroCliente.setColumns(10);

		JLabel num = new JLabel("Novo numero da casa/apartamento:");
		num.setFont(new Font("Arial", Font.PLAIN, 10));
		num.setBounds(42, 399, 200, 13);
		janela.add(num);

		numCliente = new JTextField(String.valueOf(clienteAtual.getEnderecoCliente().getNumero()), 200);
		numCliente.setBounds(42, 411, 133, 19);
		janela.add(numCliente);
		numCliente.setColumns(10);

		JButton botaoAtualiza = new JButton("Atualizar");
		botaoAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean clienteJaExiste = false;

				clienteAtual.setNome(nomeCliente.getText());
				clienteAtual.setTelefone(Long.valueOf(telCliente.getText()));
				clienteAtual.setCpf(Long.valueOf(cpfCliente.getText()));
				clienteAtual.setTipo(tipoCliente.getText());
				clienteAtual.getEnderecoCliente().setEstado(estadoCliente.getText());
				clienteAtual.getEnderecoCliente().setCidade(cidadeCliente.getText());
				clienteAtual.getEnderecoCliente().setBairro(bairroCliente.getText());
				clienteAtual.getEnderecoCliente().setCep(Long.valueOf(cepCliente.getText()));
				clienteAtual.getEnderecoCliente().setNumero(Integer.valueOf(numCliente.getText()));

				dispose();

				JOptionPane.showMessageDialog(null, "Cliente Atualizado!");

				ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);

			}
		});
		botaoAtualiza.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoAtualiza.setBounds(288, 440, 94, 27);
		janela.add(botaoAtualiza);

	}

}
