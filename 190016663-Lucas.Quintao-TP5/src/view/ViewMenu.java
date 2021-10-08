package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Produto;
import modelo.Venda;

/**
 * classe para a janela de menu na interface gráfica
 * 
 * @author lucas pimentel quintão
 * @version final
 */

public class ViewMenu extends JFrame {

	private JPanel janela;

	public ViewMenu(List<Cliente> clientes, List<Venda> vendas, List<Produto> produtos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		janela = new JPanel();
		janela.setBackground(Color.LIGHT_GRAY);
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		// Definição do titulo
		JLabel titulo = new JLabel("MENU");
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 25));
		titulo.setBounds(160, 10, 115, 36);
		janela.add(titulo);

		// Definição dos botões e suas respectivas ações
		JButton botaoCliente = new JButton("CLIENTE");
		botaoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCliente telaCliente = new ViewCliente(produtos, clientes, vendas);
				telaCliente.setVisible(true);
				telaCliente.setLocationRelativeTo(null);
				dispose();
			}
		});
		botaoCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		botaoCliente.setBounds(106, 70, 200, 27);
		janela.add(botaoCliente);

		JButton botaoProduto = new JButton("PRODUTO");
		botaoProduto.setFont(new Font("Arial", Font.PLAIN, 15));
		botaoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewProduto telaProduto = new ViewProduto(produtos, clientes, vendas);
				telaProduto.setVisible(true);
				telaProduto.setLocationRelativeTo(null);
				dispose();
			}
		});
		botaoProduto.setBounds(106, 120, 200, 27);
		janela.add(botaoProduto);

		JButton botaoVenda = new JButton("VENDAS");
		botaoVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewVenda telaVenda = new ViewVenda(produtos, clientes, vendas);
				telaVenda.setVisible(true);
				telaVenda.setLocationRelativeTo(null);
				dispose();
			}
		});
		botaoVenda.setForeground(Color.BLACK);
		botaoVenda.setFont(new Font("Arial", Font.PLAIN, 15));
		botaoVenda.setBounds(106, 170, 200, 27);
		janela.add(botaoVenda);

	}
}
