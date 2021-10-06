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

public class ViewProdutoCadastroBombom extends JFrame {

	private JPanel janela;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public ViewProdutoCadastroBombom(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 359);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		// Definição de titulos e TextFields para preencher dados do produto
		JLabel titulo = new JLabel("Cadastro Bombom\r\n");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(93, 10, 191, 19);
		janela.add(titulo);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(32, 119, 190, 19);
		janela.add(textField);

		JLabel titulo_1 = new JLabel("Nome Produto");
		titulo_1.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_1.setBounds(31, 63, 247, 13);
		janela.add(titulo_1);

		JLabel titulo_2 = new JLabel("Quantidade Estoque");
		titulo_2.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_2.setBounds(34, 152, 247, 13);
		janela.add(titulo_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(33, 77, 182, 19);
		janela.add(textField_1);

		JLabel titulo_3 = new JLabel("Preco");
		titulo_3.setBounds(33, 105, 247, 13);
		janela.add(titulo_3);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(32, 167, 191, 19);
		janela.add(textField_2);

		JLabel titulo_4 = new JLabel("Recheio");
		titulo_4.setBounds(36, 198, 57, 13);
		janela.add(titulo_4);

		textField_3 = new JTextField();
		textField_3.setBounds(36, 219, 191, 19);
		janela.add(textField_3);
		textField_3.setColumns(10);

		JButton botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean produtoJaExiste;

				Bombom bombom = new Bombom(Double.valueOf(textField.getText()), Integer.valueOf(textField_2.getText()),
						textField_1.getText(), textField_3.getText());

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
		botaoConfirmar.setBounds(229, 278, 122, 21);
		janela.add(botaoConfirmar);
	}

}
