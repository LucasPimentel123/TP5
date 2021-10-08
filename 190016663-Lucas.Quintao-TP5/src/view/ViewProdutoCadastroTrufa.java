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
import modelo.Produto;
import modelo.Trufa;
import modelo.Venda;

/**
 * classe para a janela de cadastro de trufa na interface gráfica
 * 
 * @author lucas pimentel quintão
 * @version final
 */

public class ViewProdutoCadastroTrufa extends JFrame {

	private JPanel janela;
	private JTextField nomeProduto;
	private JTextField quantProduto;
	private JTextField precoProduto;
	private JTextField recheioProduto;
	private JTextField tipoProduto;

	/**
	 * Definição de titulos e TextFields para preencher dados do produto
	 * 
	 * @param produtos ArrayList de produtos
	 * @param clientes ArrayList de clientes
	 * @param vendas   ArrayList de vendas
	 */

	public ViewProdutoCadastroTrufa(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		JLabel titulo = new JLabel("Cadastro Trufa\r\n");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(119, 10, 147, 19);
		janela.add(titulo);

		JLabel titulo_1 = new JLabel("Nome Produto");
		titulo_1.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_1.setBounds(33, 45, 176, 13);
		janela.add(titulo_1);

		nomeProduto = new JTextField();
		nomeProduto.setColumns(10);
		nomeProduto.setBounds(33, 60, 176, 19);
		janela.add(nomeProduto);

		JLabel titulo_2 = new JLabel("Quantidade Estoque");
		titulo_2.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_2.setBounds(36, 87, 176, 13);
		janela.add(titulo_2);

		quantProduto = new JTextField();
		quantProduto.setColumns(10);
		quantProduto.setBounds(33, 102, 176, 19);
		janela.add(quantProduto);

		JLabel titulo_3 = new JLabel("Preco");
		titulo_3.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_3.setBounds(39, 124, 176, 13);
		janela.add(titulo_3);

		precoProduto = new JTextField();
		precoProduto.setColumns(10);
		precoProduto.setBounds(35, 138, 176, 19);
		janela.add(precoProduto);

		JLabel titulo_4 = new JLabel("Recheio:");
		titulo_4.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_4.setBounds(34, 157, 107, 13);
		janela.add(titulo_4);

		recheioProduto = new JTextField();
		recheioProduto.setBounds(34, 171, 179, 19);
		janela.add(recheioProduto);
		recheioProduto.setColumns(10);

		JLabel titulo_5 = new JLabel("Digite o tipo de chocolate(classica ou artesanal)");
		titulo_5.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_5.setBounds(34, 196, 334, 13);
		janela.add(titulo_5);

		tipoProduto = new JTextField();
		tipoProduto.setBounds(34, 208, 179, 19);
		janela.add(tipoProduto);
		tipoProduto.setColumns(10);

		JButton botaoConfirma = new JButton("Confirmar");
		botaoConfirma.addActionListener(new ActionListener() {

			/**
			 * Confere se já não existe um produto cadastrado com o mesmo nome, se não
			 * existir cadastra o produto
			 */

			public void actionPerformed(ActionEvent e) {
				boolean produtoJaExiste;

				Trufa trufa = new Trufa(Double.valueOf(precoProduto.getText()), Integer.valueOf(quantProduto.getText()),
						nomeProduto.getText(), recheioProduto.getText(), tipoProduto.getText());

				produtoJaExiste = trufa.cadastraProduto(produtos);

				if (produtoJaExiste == false) {
					dispose();

					JOptionPane.showMessageDialog(null, "Produto Cadastrado");

					ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
					menu.setVisible(true);
					menu.setLocationRelativeTo(null);
				} else {
					JOptionPane.showMessageDialog(null, "Produto já cadastrado!", null, JOptionPane.ERROR_MESSAGE);

					ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
					menu.setVisible(true);
					menu.setLocationRelativeTo(null);
				}

			}
		});
		botaoConfirma.setBounds(283, 190, 107, 21);
		janela.add(botaoConfirma);

		JButton botaoVolta = new JButton("Voltar");
		botaoVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
			}
		});
		botaoVolta.setBounds(283, 220, 85, 21);
		janela.add(botaoVolta);
	}

}
