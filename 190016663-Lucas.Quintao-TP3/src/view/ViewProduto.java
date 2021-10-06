package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Produto;
import modelo.Venda;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ViewProduto extends JFrame {

	private JPanel janela;
	private JTextField nomeBusca;

	public ViewProduto(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		janela = new JPanel();
		janela.setBackground(Color.LIGHT_GRAY);
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		// Defição de titulos e textos auxiliares
		JLabel titulo = new JLabel("Produtos");
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 30));
		titulo.setBounds(117, 10, 175, 50);
		janela.add(titulo);

		JLabel titulo_1 = new JLabel("Digite o nome do produto\r\n");
		titulo_1.setFont(new Font("Arial", Font.PLAIN, 10));
		titulo_1.setBounds(81, 80, 164, 13);
		janela.add(titulo_1);

		// Definição dos botões e suas respetivas funções
		JButton botaoCadastrarNovoProduto = new JButton("Cadastrar Novo Produto\r\n");
		botaoCadastrarNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewDefineProduto telaDefineProduto = new ViewDefineProduto(produtos, clientes, vendas);
				telaDefineProduto.setVisible(true);
				telaDefineProduto.setLocationRelativeTo(null);
				dispose();
			}
		});
		botaoCadastrarNovoProduto.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoCadastrarNovoProduto.setBounds(81, 162, 164, 37);
		janela.add(botaoCadastrarNovoProduto);

		nomeBusca = new JTextField();
		nomeBusca.setColumns(10);
		nomeBusca.setBounds(81, 97, 176, 27);
		janela.add(nomeBusca);

		JButton botaoBusca = new JButton("Buscar Produto\r\n");
		botaoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Produto.verificaProdutoExiste(nomeBusca.getText().trim().toLowerCase(), produtos)) {
					ViewProdutoBusca telaBuscaProduto = new ViewProdutoBusca(produtos, clientes, vendas,
							nomeBusca.getText().trim().toLowerCase());
					telaBuscaProduto.setVisible(true);
					telaBuscaProduto.setLocationRelativeTo(null);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Produto não encontrado!", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botaoBusca.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoBusca.setBounds(269, 98, 106, 27);
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
