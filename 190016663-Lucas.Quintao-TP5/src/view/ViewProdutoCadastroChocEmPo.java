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

import modelo.ChocolateEmPo;
import modelo.Cliente;
import modelo.Produto;
import modelo.Venda;

/**
 * classe para a janela de cadastro de Chocolate em po na interface gráfica
 * 
 * @author lucas pimentel quintão
 * @version final
 */

public class ViewProdutoCadastroChocEmPo extends JFrame {

	private JPanel janela;
	private JTextField nomeProduto;
	private JTextField precoProduto;
	private JTextField quantidadeEstoque;
	private JTextField chocolate;
	private JTextField tipoProduto;
	private JTextField tamanhoProduto;

	/**
	 * Definição de titulos e TextFields para preencher dados do produto
	 * 
	 * @param produtos ArrayList de produtos
	 * @param clientes ArrayList de clientes
	 * @param vendas   ArrayList de vendas
	 */

	public ViewProdutoCadastroChocEmPo(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 374);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		JLabel titulo = new JLabel("Cadastro Chocolate em Po\r\n");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(85, 10, 262, 19);
		janela.add(titulo);

		JLabel titulo_1 = new JLabel("Nome Produto");
		titulo_1.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_1.setBounds(47, 56, 84, 13);
		janela.add(titulo_1);

		nomeProduto = new JTextField();
		nomeProduto.setColumns(10);
		nomeProduto.setBounds(46, 70, 136, 19);
		janela.add(nomeProduto);

		JLabel titulo_2 = new JLabel("Quantidade Estoque");
		titulo_2.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_2.setBounds(45, 91, 102, 13);
		janela.add(titulo_2);

		quantidadeEstoque = new JTextField();
		quantidadeEstoque.setColumns(10);
		quantidadeEstoque.setBounds(47, 105, 136, 19);
		janela.add(quantidadeEstoque);

		JLabel titulo_3 = new JLabel("Preco");
		titulo_3.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_3.setBounds(48, 127, 102, 13);
		janela.add(titulo_3);

		precoProduto = new JTextField();
		precoProduto.setColumns(10);
		precoProduto.setBounds(49, 141, 136, 19);
		janela.add(precoProduto);

		JLabel titulo_4 = new JLabel("Digite o sabor do chocolate(amargo, ao leite, branco, belga )");
		titulo_4.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_4.setBounds(48, 164, 287, 13);
		janela.add(titulo_4);

		chocolate = new JTextField();
		chocolate.setBounds(48, 177, 137, 19);
		janela.add(chocolate);
		chocolate.setColumns(10);

		JLabel titulo_5 = new JLabel("Digite tipo do chocolate em pó (cremoso ou tradicional)");
		titulo_5.setBounds(48, 206, 254, 13);
		janela.add(titulo_5);

		tipoProduto = new JTextField();
		tipoProduto.setBounds(48, 219, 137, 19);
		janela.add(tipoProduto);
		tipoProduto.setColumns(10);

		JLabel titulo_6 = new JLabel("Digite o tamanho do saco (pequeno, médio ou grande)");
		titulo_6.setBounds(48, 246, 261, 13);
		janela.add(titulo_6);

		tamanhoProduto = new JTextField();
		tamanhoProduto.setBounds(48, 259, 137, 19);
		janela.add(tamanhoProduto);
		tamanhoProduto.setColumns(10);

		JButton botaoConfirma = new JButton("Confirmar");
		botaoConfirma.addActionListener(new ActionListener() {

			/**
			 * Confere se já não existe um produto cadastrado com o mesmo nome, se não
			 * existir cadastra o produto
			 */

			public void actionPerformed(ActionEvent e) {
				boolean produtoJaExiste;

				ChocolateEmPo chocolateEmPo = new ChocolateEmPo(Double.valueOf(precoProduto.getText()),
						Integer.valueOf(quantidadeEstoque.getText()), nomeProduto.getText(), tamanhoProduto.getText(),
						tipoProduto.getText(), chocolate.getText());

				produtoJaExiste = chocolateEmPo.cadastraProduto(produtos);

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
		botaoConfirma.setBounds(265, 280, 100, 21);
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
		botaoVolta.setBounds(265, 310, 85, 21);
		janela.add(botaoVolta);
	}

}
