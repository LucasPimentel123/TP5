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

public class ViewProdutoCadastroTrufa extends JFrame {

	private JPanel janela;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(33, 60, 176, 19);
		janela.add(textField);

		JLabel titulo_1 = new JLabel("Nome Produto");
		titulo_1.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_1.setBounds(33, 45, 176, 13);
		janela.add(titulo_1);

		JLabel titulo_2 = new JLabel("Quantidade Estoque");
		titulo_2.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_2.setBounds(36, 87, 176, 13);
		janela.add(titulo_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(33, 102, 176, 19);
		janela.add(textField_1);

		JLabel titulo_3 = new JLabel("Preco");
		titulo_3.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_3.setBounds(39, 124, 176, 13);
		janela.add(titulo_3);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(35, 138, 176, 19);
		janela.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(34, 171, 179, 19);
		janela.add(textField_3);
		textField_3.setColumns(10);

		JLabel titulo_4 = new JLabel("Recheio");
		titulo_4.setBounds(34, 157, 107, 13);
		janela.add(titulo_4);

		textField_4 = new JTextField();
		textField_4.setBounds(34, 208, 179, 19);
		janela.add(textField_4);
		textField_4.setColumns(10);

		JLabel titulo_5 = new JLabel("Digite o tipo de chocolate(classica ou artesanal)");
		titulo_5.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_5.setBounds(34, 196, 334, 13);
		janela.add(titulo_5);

		JButton botaoConfirma = new JButton("Confirmar");
		botaoConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean produtoJaExiste;

				Trufa trufa = new Trufa(Double.valueOf(textField_2.getText()), Integer.valueOf(textField_1.getText()),
						textField.getText(), textField_3.getText(), textField_4.getText());

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
		botaoConfirma.setBounds(283, 232, 107, 21);
		janela.add(botaoConfirma);
	}

}
