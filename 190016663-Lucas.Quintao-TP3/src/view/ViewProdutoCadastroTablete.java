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

public class ViewProdutoCadastroTablete extends JFrame {

	private JPanel janela;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JLabel lblNewLabel_4;
	private JTextField textField_3;
	private JLabel lblNewLabel_5;
	private JTextField textField_4;
	private JLabel lblNewLabel_6;
	private JTextField textField_5;
	private JButton btnNewButton;

	public ViewProdutoCadastroTablete(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 379);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro Tablete\r\n");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(130, 20, 165, 19);
		janela.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(38, 72, 136, 19);
		janela.add(textField);
		textField.setColumns(10);

		lblNewLabel_1 = new JLabel("Nome Produto");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(38, 56, 84, 13);
		janela.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Quantidade Estoque");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(37, 97, 102, 13);
		janela.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(38, 112, 136, 19);
		janela.add(textField_1);
		textField_1.setColumns(10);

		lblNewLabel_3 = new JLabel("Preco");
		lblNewLabel_3.setBounds(37, 141, 102, 13);
		janela.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setBounds(38, 153, 136, 19);
		janela.add(textField_2);
		textField_2.setColumns(10);

		lblNewLabel_4 = new JLabel("Tipo de chocolate (ao leite, amargo, branco ...)");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(38, 182, 234, 13);
		janela.add(lblNewLabel_4);

		textField_3 = new JTextField();
		textField_3.setBounds(38, 196, 136, 19);
		janela.add(textField_3);
		textField_3.setColumns(10);

		lblNewLabel_5 = new JLabel("Recheio tablete");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(38, 223, 136, 13);
		janela.add(lblNewLabel_5);

		textField_4 = new JTextField();
		textField_4.setBounds(38, 235, 136, 19);
		janela.add(textField_4);
		textField_4.setColumns(10);

		lblNewLabel_6 = new JLabel("Digite o peso do chocolate (90g/120g/180g)");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_6.setBounds(38, 264, 222, 13);
		janela.add(lblNewLabel_6);

		textField_5 = new JTextField();
		textField_5.setBounds(38, 276, 136, 19);
		janela.add(textField_5);
		textField_5.setColumns(10);

		btnNewButton = new JButton("Confirma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean produtoJaExiste;

				Tablete tablete = new Tablete(Double.valueOf(textField_2.getText()),
						Integer.valueOf(textField_1.getText()), textField.getText(), textField_5.getText(),
						textField_3.getText(), textField_4.getText());

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
		btnNewButton.setBounds(289, 320, 85, 21);
		janela.add(btnNewButton);
	}

}
