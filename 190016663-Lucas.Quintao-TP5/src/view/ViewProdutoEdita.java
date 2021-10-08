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
 * classe para a janela de edição dos dados do produto na interface gráfica
 * 
 * @author lucas pimentel quintão
 * @version final
 */

public class ViewProdutoEdita extends JFrame {
	private JPanel janela;
	private JTextField nomeProduto;
	private JTextField quantidadeProduto;
	private JTextField precoProduto;

	/**
	 * Mostra os principais dados do produto em campos de texto com a possibiliadade
	 * do usuário alterá-los
	 * 
	 * @param produtos     ArrayList de produtos
	 * @param clientes     ArrayList de clientes
	 * @param vendas       ArrayList de vendas
	 * @param produtoAtual produto digitado pelo cliente
	 */

	public ViewProdutoEdita(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas, Produto produtoAtual) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 359);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		JLabel titulo = new JLabel("Atualização de dados Produto\r\n");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(93, 10, 191, 19);
		janela.add(titulo);

		JLabel nome = new JLabel("Novo nome Produto:");
		nome.setFont(new Font("Arial", Font.PLAIN, 10));
		nome.setBounds(31, 63, 247, 13);
		janela.add(nome);

		nomeProduto = new JTextField(produtoAtual.getNome(), 200);
		nomeProduto.setColumns(10);
		nomeProduto.setBounds(33, 77, 182, 19);
		janela.add(nomeProduto);

		JLabel quant = new JLabel("Nova quantidade Estoque:");
		quant.setFont(new Font("Arial", Font.PLAIN, 10));
		quant.setBounds(34, 152, 247, 13);
		janela.add(quant);

		quantidadeProduto = new JTextField(String.valueOf(produtoAtual.getQuantidadeEstoque()), 200);
		quantidadeProduto.setColumns(10);
		quantidadeProduto.setBounds(32, 167, 191, 19);
		janela.add(quantidadeProduto);

		JLabel preco = new JLabel("Novo preço:");
		preco.setBounds(33, 105, 247, 13);
		janela.add(preco);

		precoProduto = new JTextField(String.valueOf(produtoAtual.getPreco()), 200);
		precoProduto.setColumns(10);
		precoProduto.setBounds(32, 119, 190, 19);
		janela.add(precoProduto);

		JButton botaoAtualiza = new JButton("Atualizar");
		botaoAtualiza.addActionListener(new ActionListener() {

			/**
			 * Define os dados dos campos textuais como os novos dados do produto
			 */

			public void actionPerformed(ActionEvent e) {

				produtoAtual.setNome(nomeProduto.getText());
				produtoAtual.setQuantidadeEstoque(Integer.valueOf(quantidadeProduto.getText()));
				produtoAtual.setPreco(Double.valueOf(precoProduto.getText()));

				JOptionPane.showMessageDialog(null, "Produto Atualizado!");

				ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				dispose();

			}
		});
		botaoAtualiza.setFont(new Font("Arial", Font.PLAIN, 10));
		botaoAtualiza.setBounds(229, 278, 122, 21);
		janela.add(botaoAtualiza);

	}

}
