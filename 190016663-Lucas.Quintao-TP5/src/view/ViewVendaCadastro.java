package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Produto;
import modelo.Venda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * classe para a janela de cadastro de venda na interface gráfica
 * 
 * @author lucas pimentel quintão
 * @version final
 */

public class ViewVendaCadastro extends JFrame {

	private JPanel janela;
	private JTextField nomeCliente;
	private JTextField nomeProduto;
	private JTextField quantVenda;

	/**
	 * Abre campos textuais para preencher os dados da venda a ser cadastrada
	 * 
	 * @param produtos ArrayList de produtos
	 * @param clientes ArrayList de clientes
	 * @param vendas   ArrayList de produtos
	 */

	public ViewVendaCadastro(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 362);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		JLabel titulo = new JLabel("Cadastro de Venda");
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 20));
		titulo.setBounds(80, 10, 234, 29);
		janela.add(titulo);

		nomeCliente = new JTextField();
		nomeCliente.setBounds(39, 75, 157, 19);
		janela.add(nomeCliente);
		nomeCliente.setColumns(10);

		JLabel titulo_1 = new JLabel("Nome Cliente");
		titulo_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		titulo_1.setBounds(39, 58, 157, 13);
		janela.add(titulo_1);

		JLabel titulo_2 = new JLabel("Nome Produto para venda");
		titulo_2.setBounds(39, 104, 198, 13);
		janela.add(titulo_2);

		nomeProduto = new JTextField();
		nomeProduto.setBounds(39, 120, 157, 19);
		janela.add(nomeProduto);
		nomeProduto.setColumns(10);

		JLabel titulo_3 = new JLabel("Quantidade de produto \r\n");
		titulo_3.setBounds(39, 150, 157, 13);
		janela.add(titulo_3);

		quantVenda = new JTextField();
		quantVenda.setBounds(39, 165, 157, 19);
		janela.add(quantVenda);
		quantVenda.setColumns(10);

		JLabel titulo_4 = new JLabel("Forma de Pagamento");
		titulo_4.setBounds(39, 198, 130, 13);
		janela.add(titulo_4);

		JCheckBox checkBox = new JCheckBox("Credito");
		checkBox.setBounds(39, 217, 93, 21);
		janela.add(checkBox);

		JCheckBox checkBox_1 = new JCheckBox("Debito");
		checkBox_1.setBounds(39, 240, 93, 21);
		janela.add(checkBox_1);

		JCheckBox checkBox_2 = new JCheckBox("Boleto");
		checkBox_2.setBounds(39, 263, 93, 21);
		janela.add(checkBox_2);

		JButton botaoConfirma = new JButton("Confirmar");
		botaoConfirma.addActionListener(new ActionListener() {

			/**
			 * Verifica se o cliente e o produto da venda estão cadastrados, caso estejam
			 * procegue com o cadastro, verificando se há estoque disponível do produto para
			 * a venda. E então definindo o construtor de Venda com os dados preenchidos
			 * pelo usuário. Em caso de erro mostra mensagem na tela.
			 */

			public void actionPerformed(ActionEvent e) {

				if ((Cliente.verificaClienteExiste(nomeCliente.getText().trim().toLowerCase(), clientes))
						&& (Produto.verificaProdutoExiste(nomeProduto.getText().trim().toLowerCase(), produtos))) {
					Cliente clienteAtual = null;
					Produto produtoAtual = null;
					double frete;
					double valorTotal;
					String codigoPedido;
					int quantVendida = Integer.parseInt(quantVenda.getText());
					String formaDePagamento = null;

					for (int i = 0; i < clientes.size(); i++) {
						if (clientes.get(i).getNome().equals(nomeCliente.getText())) {
							clienteAtual = clientes.get(i);
							break;
						}
					}

					for (int i = 0; i < produtos.size(); i++) {
						if (produtos.get(i).getNome().equals(nomeProduto.getText())) {
							produtoAtual = produtos.get(i);
							break;
						}
					}

					if (Venda.verificaEstoque(quantVendida, produtoAtual)) {
						JOptionPane.showMessageDialog(null, "Estoque Insuficiente!", null, JOptionPane.ERROR_MESSAGE);

						ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
						menu.setVisible(true);
						menu.setLocationRelativeTo(null);
						dispose();
					} else {

						frete = Venda.defineValorFrete(clienteAtual);
						codigoPedido = Venda.geraCodigoPedido();
						valorTotal = Venda.defineValorTotal(produtoAtual, quantVendida, frete);

						if (checkBox.isSelected()) {
							formaDePagamento = "credito";
						}
						if (checkBox_1.isSelected()) {
							formaDePagamento = "debito";
						}
						if (checkBox_2.isSelected()) {
							formaDePagamento = "boleto";
						}

						Venda venda = new Venda(formaDePagamento, clienteAtual, produtoAtual, quantVendida,
								codigoPedido, valorTotal, frete);

						venda.cadastraVenda(vendas, produtoAtual, quantVendida);

						if (frete == 0) {
							JOptionPane.showMessageDialog(null, "Venda Cadastrada\nCliente Prime, frete gratis!"
									+ "\nCódigo da Venda: " + venda.getCodigoPedido());
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Venda Cadastrada\n Frete: R$9.99"
									+ "\nCódigo da Venda: " + venda.getCodigoPedido());
							dispose();
						}

						ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
						menu.setVisible(true);
						menu.setLocationRelativeTo(null);
						dispose();
					}
				}

				else {
					if (!(Cliente.verificaClienteExiste(nomeCliente.getText().trim().toLowerCase(), clientes))) {
						JOptionPane.showMessageDialog(null, "Cliente não encontrado!", null, JOptionPane.ERROR_MESSAGE);

					}

					if (!(Produto.verificaProdutoExiste(nomeProduto.getText().trim().toLowerCase(), produtos))) {
						JOptionPane.showMessageDialog(null, "Produto não encontrado!", null, JOptionPane.ERROR_MESSAGE);

					}
				}
			}

		});
		botaoConfirma.setBounds(213, 265, 101, 21);
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
		botaoVolta.setBounds(213, 294, 85, 21);
		janela.add(botaoVolta);
	}
}
