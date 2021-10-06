package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Produto;
import modelo.Venda;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ViewDefineProduto extends JFrame {

	private JPanel janela;
	private JTextField textField;

	public ViewDefineProduto(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		JLabel titulo = new JLabel("Qual Produto deseja cadastrar?");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(73, 23, 312, 24);
		janela.add(titulo);

		JCheckBox checkBox = new JCheckBox("Tablete");
		checkBox.setFont(new Font("Arial", Font.PLAIN, 10));
		checkBox.setBounds(140, 91, 207, 21);
		janela.add(checkBox);

		JCheckBox checkBox_1 = new JCheckBox("Bombom\r\n");
		checkBox_1.setFont(new Font("Arial", Font.PLAIN, 10));
		checkBox_1.setBounds(140, 116, 207, 21);
		janela.add(checkBox_1);

		JCheckBox checkBox_2 = new JCheckBox("Trufa");
		checkBox_2.setFont(new Font("Arial", Font.PLAIN, 10));
		checkBox_2.setBounds(140, 139, 207, 21);
		janela.add(checkBox_2);

		JCheckBox checkBox_3 = new JCheckBox("Chocolate em P\u00F3");
		checkBox_3.setFont(new Font("Arial", Font.PLAIN, 10));
		checkBox_3.setBounds(140, 162, 207, 21);
		janela.add(checkBox_3);

		JLabel titulo_1 = new JLabel("Escolha um:");
		titulo_1.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_1.setBounds(140, 72, 118, 13);
		janela.add(titulo_1);

		JButton botaoConfirma = new JButton("Confirmar");
		botaoConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (checkBox.isSelected()) {
					ViewProdutoCadastroTablete telaTablete = new ViewProdutoCadastroTablete(produtos, clientes, vendas);
					telaTablete.setVisible(true);
					telaTablete.setLocationRelativeTo(null);
					dispose();
				}

				if (checkBox_1.isSelected()) {
					ViewProdutoCadastroBombom telaBombom = new ViewProdutoCadastroBombom(produtos, clientes, vendas);
					telaBombom.setVisible(true);
					telaBombom.setLocationRelativeTo(null);
					dispose();
				}

				if (checkBox_2.isSelected()) {
					ViewProdutoCadastroTrufa telaTrufa = new ViewProdutoCadastroTrufa(produtos, clientes, vendas);
					telaTrufa.setVisible(true);
					telaTrufa.setLocationRelativeTo(null);
					dispose();
				}

				if (checkBox_3.isSelected()) {
					ViewProdutoCadastroChocEmPo telaChoc = new ViewProdutoCadastroChocEmPo(produtos, clientes, vendas);
					telaChoc.setVisible(true);
					telaChoc.setLocationRelativeTo(null);
					dispose();
				}
			}
		});
		botaoConfirma.setBounds(140, 216, 118, 21);
		janela.add(botaoConfirma);
	}

}
