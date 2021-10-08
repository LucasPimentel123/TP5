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

import modelo.Bombom;
import modelo.Cliente;
import modelo.Produto;
import modelo.Venda;

/**
 * classe para a janela de cadastro de bobom na interface gráfica
 * 
 * @author lucas pimentel quintão
 * @version final
 */

public class ViewProdutoCadastroBombom extends JFrame {

	private JPanel janela;
	private JTextField precoPorduto;
	private JTextField nomeProduto;
	private JTextField quantProduto;
	private JTextField recheioProduto;

	/**
	 * Definição de titulos e TextFields para preencher dados do produto
	 * 
	 * @param produtos ArrayList de produtos
	 * @param clientes ArrayList de clientes
	 * @param vendas   ArrayList de vendas
	 */

	public ViewProdutoCadastroBombom(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 359);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		JLabel titulo = new JLabel("Cadastro Bombom\r\n");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(93, 10, 191, 19);
		janela.add(titulo);

		JLabel titulo_1 = new JLabel("Nome Produto");
		titulo_1.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_1.setBounds(31, 63, 247, 13);
		janela.add(titulo_1);

		nomeProduto = new JTextField();
		nomeProduto.setColumns(10);
		nomeProduto.setBounds(33, 77, 182, 19);
		janela.add(nomeProduto);

		JLabel titulo_2 = new JLabel("Quantidade Estoque");
		titulo_2.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_2.setBounds(34, 152, 247, 13);
		janela.add(titulo_2);

		quantProduto = new JTextField();
		quantProduto.setColumns(10);
		quantProduto.setBounds(32, 167, 191, 19);
		janela.add(quantProduto);

		JLabel titulo_3 = new JLabel("Preco");
		titulo_3.setBounds(33, 105, 247, 13);
		janela.add(titulo_3);

		precoPorduto = new JTextField();
		precoPorduto.setColumns(10);
		precoPorduto.setBounds(32, 119, 190, 19);
		janela.add(precoPorduto);

		JLabel titulo_4 = new JLabel("Recheio");
		titulo_4.setBounds(36, 198, 57, 13);
		janela.add(titulo_4);

		recheioProduto = new JTextField();
		recheioProduto.setBounds(36, 219, 191, 19);
		janela.add(recheioProduto);
		recheioProduto.setColumns(10);

		JButton botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.addActionListener(new ActionListener() {

			/**
			 * Confere se já não existe um produto cadastrado com o mesmo nome, se não
			 * existir cadastra o produto
			 */

			public void actionPerformed(ActionEvent e) {
				boolean produtoJaExiste;

				Bombom bombom = new Bombom(Double.valueOf(precoPorduto.getText()),
						Integer.valueOf(quantProduto.getText()), nomeProduto.getText(), recheioProduto.getText());

				produtoJaExiste = bombom.cadastraProduto(produtos);

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
		botaoConfirmar.setBounds(229, 250, 122, 21);
		janela.add(botaoConfirmar);

		JButton botaoVolta = new JButton("Voltar");
		botaoVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
			}
		});
		botaoVolta.setBounds(229, 280, 85, 21);
		janela.add(botaoVolta);
	}

}
