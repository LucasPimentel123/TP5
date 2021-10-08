package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Endereco;
import modelo.Produto;
import modelo.Venda;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * classe para a janela de cadastro do cliente na interface gráfica
 * 
 * @author lucas pimentel quintão
 * @version final
 */

public class ViewClienteCadastro extends JFrame {

	private JPanel janela;
	private JTextField nomeCliente;
	private JTextField TelCliente;
	private JTextField cpfCliente;
	private JTextField tipoCliente;
	private JTextField estadoCliente;
	private JTextField cidadeCliente;
	private JTextField cepCliente;
	private JTextField bairroCliente;
	private JTextField numCliente;

	/**
	 * Mostra todos os dados do cliente e os campos textuais para serem preenchidos
	 * pelo usuário
	 * 
	 * @param produtos lista de produtos
	 * @param clientes lista de clientes
	 * @param vendas   lista de vendas
	 */

	public ViewClienteCadastro(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 513);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		JLabel titulo = new JLabel("Cadastro Cliente\r\n");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(130, 20, 155, 19);
		janela.add(titulo);

		nomeCliente = new JTextField();
		nomeCliente.setBounds(42, 74, 133, 19);
		janela.add(nomeCliente);
		nomeCliente.setColumns(10);

		JLabel nome = new JLabel("Nome do cliente\r\n");
		nome.setFont(new Font("Arial", Font.PLAIN, 10));
		nome.setBounds(42, 54, 83, 13);
		janela.add(nome);

		TelCliente = new JTextField();
		TelCliente.setBounds(42, 119, 133, 19);
		janela.add(TelCliente);
		TelCliente.setColumns(10);

		JLabel tel = new JLabel("Telefone do cliente\r\n");
		tel.setFont(new Font("Arial", Font.PLAIN, 10));
		tel.setBounds(40, 103, 114, 13);
		janela.add(tel);

		cpfCliente = new JTextField();
		cpfCliente.setBounds(42, 163, 133, 19);
		janela.add(cpfCliente);
		cpfCliente.setColumns(10);

		JLabel cpf = new JLabel("CPF do cliente");
		cpf.setFont(new Font("Arial", Font.PLAIN, 10));
		cpf.setBounds(42, 148, 94, 13);
		janela.add(cpf);

		tipoCliente = new JTextField();
		tipoCliente.setBounds(42, 204, 133, 19);
		janela.add(tipoCliente);
		tipoCliente.setColumns(10);

		JLabel tipo = new JLabel("Tipo de cliente (prime ou tradicional)");
		tipo.setFont(new Font("Arial", Font.PLAIN, 10));
		tipo.setBounds(42, 192, 186, 13);
		janela.add(tipo);

		estadoCliente = new JTextField();
		estadoCliente.setBounds(42, 253, 133, 19);
		janela.add(estadoCliente);
		estadoCliente.setColumns(10);

		JLabel estado = new JLabel("Unidade Federativa do cliente");
		estado.setFont(new Font("Arial", Font.PLAIN, 10));
		estado.setBounds(42, 241, 165, 13);
		janela.add(estado);

		JLabel cidade = new JLabel("Cidade do cliente");
		cidade.setFont(new Font("Arial", Font.PLAIN, 10));
		cidade.setBounds(42, 282, 94, 13);
		janela.add(cidade);

		cidadeCliente = new JTextField();
		cidadeCliente.setBounds(42, 296, 133, 19);
		janela.add(cidadeCliente);
		cidadeCliente.setColumns(10);

		JLabel cep = new JLabel("CEP do cliente");
		cep.setFont(new Font("Arial", Font.PLAIN, 10));
		cep.setBounds(42, 325, 94, 13);
		janela.add(cep);

		cepCliente = new JTextField();
		cepCliente.setBounds(42, 337, 133, 19);
		janela.add(cepCliente);
		cepCliente.setColumns(10);

		JLabel bairro = new JLabel("Bairro do cliente");
		bairro.setFont(new Font("Arial", Font.PLAIN, 10));
		bairro.setBounds(42, 360, 133, 13);
		janela.add(bairro);

		bairroCliente = new JTextField();
		bairroCliente.setBounds(42, 375, 133, 19);
		janela.add(bairroCliente);
		bairroCliente.setColumns(10);

		JLabel num = new JLabel("Numero da casa/apartamento");
		num.setFont(new Font("Arial", Font.PLAIN, 10));
		num.setBounds(42, 399, 165, 13);
		janela.add(num);

		numCliente = new JTextField();
		numCliente.setBounds(42, 411, 133, 19);
		janela.add(numCliente);
		numCliente.setColumns(10);

		JButton botaoConfirma = new JButton("Confirmar");
		botaoConfirma.addActionListener(new ActionListener() {

			/**
			 * chama a função de cadastrar cliente e limita o campo de tipo para apenas as
			 * palavras prime e tradicional caso o cadastro de errado, chama mensagens de
			 * erro para a tela
			 */

			public void actionPerformed(ActionEvent e) {
				if ((tipoCliente.getText().equals("prime")) || (tipoCliente.getText().equals("tradicional"))) {
					boolean clienteJaExiste = false;
					Endereco endereco = new Endereco(estadoCliente.getText(), cidadeCliente.getText(),
							Long.valueOf(cepCliente.getText()), bairroCliente.getText(),
							Integer.valueOf(numCliente.getText()));

					Cliente cliente = new Cliente(nomeCliente.getText().trim().toLowerCase(),
							Long.valueOf(TelCliente.getText()), Long.valueOf(cpfCliente.getText()),
							tipoCliente.getText(), endereco);

					clienteJaExiste = cliente.cadastraCliente(clientes);

					if (clienteJaExiste == false) {
						dispose();

						JOptionPane.showMessageDialog(null, "Cliente Cadastrado");

						ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
						menu.setVisible(true);
						menu.setLocationRelativeTo(null);
					} else {
						dispose();

						JOptionPane.showMessageDialog(null, "Cliente já cadastrado!", null, JOptionPane.ERROR_MESSAGE);

						ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
						menu.setVisible(true);
						menu.setLocationRelativeTo(null);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Digite um tipo de cliente válido (prime ou tradicional)", null,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botaoConfirma.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoConfirma.setBounds(265, 410, 94, 27);
		janela.add(botaoConfirma);

		// botao paar voltar ao menu
		JButton botaoVolta = new JButton("Voltar");
		botaoVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
			}
		});
		botaoVolta.setBounds(265, 445, 85, 21);
		janela.add(botaoVolta);
	}

}