package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Produto;
import modelo.Venda;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * classe para a janela do cliente na interface gráfica
 * 
 * @author lucas pimentel quintão
 * @version final
 */

public class ViewCliente extends JFrame {

	private JPanel janela;
	private JTextField nomeBusca;

	/**
	 * Define botões, campos de texto e titulos na tela
	 * 
	 * @param produtos lista de produtos cadastrados
	 * @param clientes lista de clientes cadastrados
	 * @param vendas   lista de vendas cadastradas
	 */

	public ViewCliente(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 301);
		janela = new JPanel();
		janela.setBackground(Color.LIGHT_GRAY);
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		JLabel titulo = new JLabel("Clientes");
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 30));
		titulo.setBounds(117, 10, 175, 50);
		janela.add(titulo);

		JLabel titulo_1 = new JLabel("Digite o nome do cliente");
		titulo_1.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_1.setBounds(85, 91, 164, 13);
		janela.add(titulo_1);

		JButton boataoCadastrar = new JButton("Cadastrar Novo Cliente\r\n");
		boataoCadastrar.addActionListener(new ActionListener() {

			// abre a dela de cadastro do cliente quando o usuario aperta o botao
			public void actionPerformed(ActionEvent e) {
				ViewClienteCadastro telaClienteCadastro = new ViewClienteCadastro(produtos, clientes, vendas);
				telaClienteCadastro.setVisible(true);
				telaClienteCadastro.setLocationRelativeTo(null);
				dispose();

			}
		});
		boataoCadastrar.setFont(new Font("Arial", Font.PLAIN, 10));
		boataoCadastrar.setBounds(85, 175, 164, 37);
		janela.add(boataoCadastrar);

		nomeBusca = new JTextField();
		nomeBusca.setBounds(85, 102, 164, 27);
		janela.add(nomeBusca);
		nomeBusca.setColumns(10);

		JButton botaoBuscar = new JButton("Buscar Cliente\r\n");
		botaoBuscar.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoBuscar.addActionListener(new ActionListener() {

			/**
			 * Abre a tela de busca de cliente caso o nome do cliente digitado pelo usuário
			 * corresponda ao nome de um cliente cadastrado, caso não correponda abre uma
			 * mensagem de erro
			 */

			public void actionPerformed(ActionEvent e) {
				if (Cliente.verificaClienteExiste(nomeBusca.getText().trim().toLowerCase(), clientes)) {
					ViewClienteBusca telaClienteBusca = new ViewClienteBusca(produtos, clientes, vendas,
							nomeBusca.getText().trim().toLowerCase());
					telaClienteBusca.setVisible(true);
					telaClienteBusca.setLocationRelativeTo(null);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Cliente não encontrado!", null, JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		botaoBuscar.setBounds(273, 102, 106, 27);
		janela.add(botaoBuscar);

		JButton botaoVolta = new JButton("Voltar");
		botaoVolta.addActionListener(new ActionListener() {
			// volta a tela de menu caso o usuário aperte o botão

			public void actionPerformed(ActionEvent e) {
				dispose();

				ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
			}
		});
		botaoVolta.setBounds(300, 190, 85, 21);
		janela.add(botaoVolta);
	}
}
