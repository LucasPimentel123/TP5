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

public class ViewProdutoCadastroChocEmPo extends JFrame {

	private JPanel janela;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public ViewProdutoCadastroChocEmPo(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 374);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		// Definição de titulos e TextFields para preencher dados do produto
		JLabel titulo = new JLabel("Cadastro Chocolate em Po\r\n");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(85, 10, 262, 19);
		janela.add(titulo);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(46, 70, 136, 19);
		janela.add(textField);

		JLabel titulo_1 = new JLabel("Nome Produto");
		titulo_1.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_1.setBounds(47, 56, 84, 13);
		janela.add(titulo_1);

		JLabel titulo_2 = new JLabel("Quantidade Estoque");
		titulo_2.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_2.setBounds(45, 91, 102, 13);
		janela.add(titulo_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(49, 141, 136, 19);
		janela.add(textField_1);

		JLabel titulo_3 = new JLabel("Preco");
		titulo_3.setBounds(48, 127, 102, 13);
		janela.add(titulo_3);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(47, 105, 136, 19);
		janela.add(textField_2);

		JLabel titulo_4 = new JLabel("Digite o sabor do chocolate(amargo, ao leite, branco, belga )");
		titulo_4.setBounds(48, 164, 287, 13);
		janela.add(titulo_4);

		textField_3 = new JTextField();
		textField_3.setBounds(48, 177, 137, 19);
		janela.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(48, 219, 137, 19);
		janela.add(textField_4);
		textField_4.setColumns(10);

		JLabel titulo_5 = new JLabel("Digite tipo do chocolate em p\u00F3 (cremoso ou tradicional)");
		titulo_5.setBounds(48, 206, 254, 13);
		janela.add(titulo_5);

		textField_5 = new JTextField();
		textField_5.setBounds(48, 259, 137, 19);
		janela.add(textField_5);
		textField_5.setColumns(10);

		JLabel titulo_6 = new JLabel("Digite o tamanho do saco (pequeno, médio ou grande)");
		titulo_6.setBounds(48, 246, 261, 13);
		janela.add(titulo_6);

		JButton botaoConfirma = new JButton("Confirmar");
		botaoConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean produtoJaExiste;

				ChocolateEmPo chocolateEmPo = new ChocolateEmPo(Double.valueOf(textField_1.getText()),
						Integer.valueOf(textField_2.getText()), textField.getText(), textField_5.getText(),
						textField_4.getText(), textField_3.getText());

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
		botaoConfirma.setBounds(265, 308, 85, 21);
		janela.add(botaoConfirma);
	}

}
