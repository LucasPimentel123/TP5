package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Produto;
import modelo.Venda;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

/**
 * classe para a janela de venda na interface gráfica
 * 
 * @author lucas pimentel quintão
 * @version final
 */

public class ViewVenda extends JFrame {

	private JPanel janela;
	private JTextField codigoPedido;

	/**
	 * Definição de titulo, textos auxiliares, botões e suas finalidades
	 * 
	 * @param produtos ArrayList de produtos
	 * @param clientes ArrayList de clientes
	 * @param vendas   ArrayList de vendas
	 */

	public ViewVenda(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		janela = new JPanel();
		janela.setBackground(Color.LIGHT_GRAY);
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		JLabel titulo = new JLabel("Vendas");
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 30));
		titulo.setBounds(139, 6, 175, 50);
		janela.add(titulo);

		JLabel titulo_1 = new JLabel("Digite o Cogido da Venda\r\n");
		titulo_1.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_1.setBounds(81, 66, 144, 13);
		janela.add(titulo_1);

		JButton botaoCadastrarNovaVenda = new JButton("Cadastrar Nova Venda\r\n");
		botaoCadastrarNovaVenda.addActionListener(new ActionListener() {

			// chama a tela de cadastro de vendas
			public void actionPerformed(ActionEvent e) {
				ViewVendaCadastro telaVendaCadastro = new ViewVendaCadastro(produtos, clientes, vendas);
				telaVendaCadastro.setVisible(true);
				telaVendaCadastro.setLocationRelativeTo(null);
				dispose();
			}
		});
		botaoCadastrarNovaVenda.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoCadastrarNovaVenda.setBounds(79, 154, 180, 43);
		janela.add(botaoCadastrarNovaVenda);

		codigoPedido = new JTextField();
		codigoPedido.setColumns(10);
		codigoPedido.setBounds(79, 82, 164, 27);
		janela.add(codigoPedido);

		JButton botaoBusca = new JButton("Buscar Venda\r\n");
		botaoBusca.addActionListener(new ActionListener() {

			/**
			 * Abre a tela de busca no caso do codigo do pedido digitado pelo usuário
			 * corresponder ao codigo de alguma venda cadastrada
			 * 
			 * @param e
			 */

			public void actionPerformed(ActionEvent e) {
				if (Venda.verificaVendaExiste(vendas, codigoPedido.getText().trim())) {

					ViewVendaBusca telaVendaBusca = new ViewVendaBusca(produtos, clientes, vendas,
							codigoPedido.getText().trim());
					telaVendaBusca.setVisible(true);
					telaVendaBusca.setLocationRelativeTo(null);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Pedido não encontrado!", null, JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		botaoBusca.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoBusca.setBounds(257, 81, 106, 27);
		janela.add(botaoBusca);

		JButton botaoVolta = new JButton("Voltar");
		botaoVolta.addActionListener(new ActionListener() {
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
