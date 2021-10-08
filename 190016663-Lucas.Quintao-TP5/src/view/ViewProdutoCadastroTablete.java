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
import modelo.Tablete;
import modelo.Venda;

/**
 * classe para a janela de cadastro de tablete na interface gráfica
 * 
 * @author lucas pimentel quintão
 * @version final
 */

public class ViewProdutoCadastroTablete extends JFrame {

	private JPanel janela;
	private JTextField nomeProduto;
	private JTextField quantProduto;
	private JTextField precoProduto;
	private JTextField tipoProduto;
	private JTextField recheioProduto;
	private JTextField pesoProduto;

	/**
	 * Definição de titulos e TextFields para preencher dados do produto
	 * 
	 * @param produtos ArrayList de produtos
	 * @param clientes ArrayList de clientes
	 * @param vendas   ArrayList de vendas
	 */

	public ViewProdutoCadastroTablete(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 379);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		JLabel titulo = new JLabel("Cadastro Tablete\r\n");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(130, 20, 165, 19);
		janela.add(titulo);

		JLabel titulo_1 = new JLabel("Nome Produto");
		titulo_1.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_1.setBounds(38, 56, 84, 13);
		janela.add(titulo_1);

		nomeProduto = new JTextField();
		nomeProduto.setBounds(38, 72, 136, 19);
		janela.add(nomeProduto);
		nomeProduto.setColumns(10);

		JLabel titulo_2 = new JLabel("Quantidade Estoque");
		titulo_2.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_2.setBounds(37, 97, 102, 13);
		janela.add(titulo_2);

		quantProduto = new JTextField();
		quantProduto.setBounds(38, 112, 136, 19);
		janela.add(quantProduto);
		quantProduto.setColumns(10);

		JLabel titulo_3 = new JLabel("Preco");
		titulo_3.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_3.setBounds(37, 141, 102, 13);
		janela.add(titulo_3);

		precoProduto = new JTextField();
		precoProduto.setBounds(38, 153, 136, 19);
		janela.add(precoProduto);
		precoProduto.setColumns(10);

		JLabel titulo_4 = new JLabel("Tipo de chocolate (ao leite, amargo, branco ...)");
		titulo_4.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_4.setBounds(38, 182, 234, 13);
		janela.add(titulo_4);

		tipoProduto = new JTextField();
		tipoProduto.setBounds(38, 196, 136, 19);
		janela.add(tipoProduto);
		tipoProduto.setColumns(10);

		JLabel titulo_5 = new JLabel("Recheio tablete");
		titulo_5.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_5.setBounds(38, 223, 136, 13);
		janela.add(titulo_5);

		recheioProduto = new JTextField();
		recheioProduto.setBounds(38, 235, 136, 19);
		janela.add(recheioProduto);
		recheioProduto.setColumns(10);

		JLabel titulo_6 = new JLabel("Digite o peso do chocolate (90g/120g/180g)");
		titulo_6.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_6.setBounds(38, 264, 222, 13);
		janela.add(titulo_6);

		pesoProduto = new JTextField();
		pesoProduto.setBounds(38, 276, 136, 19);
		janela.add(pesoProduto);
		pesoProduto.setColumns(10);

		JButton botaoConfirma = new JButton("Confirma");
		botaoConfirma.addActionListener(new ActionListener() {

			/**
			 * Confere se já não existe um produto cadastrado com o mesmo nome, se não
			 * existir cadastra o produto
			 */

			public void actionPerformed(ActionEvent e) {
				boolean produtoJaExiste;

				Tablete tablete = new Tablete(Double.valueOf(precoProduto.getText()),
						Integer.valueOf(quantProduto.getText()), nomeProduto.getText(), pesoProduto.getText(),
						tipoProduto.getText(), recheioProduto.getText());

				produtoJaExiste = tablete.cadastraProduto(produtos);

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
		botaoConfirma.setBounds(289, 290, 85, 21);
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
		botaoVolta.setBounds(289, 320, 85, 21);
		janela.add(botaoVolta);
	}

}
