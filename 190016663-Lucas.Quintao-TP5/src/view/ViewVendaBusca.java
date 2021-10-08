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
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Produto;
import modelo.Venda;

/**
 * classe para a janela de busca de venda na interface gráfica
 * 
 * @author lucas pimentel quintão
 * @version final
 */

public class ViewVendaBusca extends JFrame {
	private JPanel janela;

	/**
	 * Mostra dados da venda buscada pelo usuário com a opção de editá-los ou
	 * deletar a venda
	 * 
	 * @param produtos     ArrayList produtos
	 * @param clientes     ArrayList clientes
	 * @param vendas       ArrayList vendas
	 * @param codigoPedido codigo do pedido digitado pelo usuário
	 */

	public ViewVendaBusca(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas, String codigoPedido) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 390);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		JLabel titulo = new JLabel("Dados da Venda");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(120, 21, 214, 19);
		janela.add(titulo);

		for (int i = 0; i < vendas.size(); i++) {
			if (vendas.get(i).getCodigoPedido().trim().equals(codigoPedido)) {
				int posicao = i;

				JLabel dado = new JLabel("Nome Cliente: " + vendas.get(i).getCliente().getNome());
				dado.setFont(new Font("Arial", Font.PLAIN, 13));
				dado.setBounds(10, 61, 270, 13);
				janela.add(dado);

				JLabel dado_1 = new JLabel("Produto comprado: " + vendas.get(i).getProduto().getNome());
				dado_1.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_1.setBounds(10, 83, 270, 13);
				janela.add(dado_1);

				JLabel dado_2 = new JLabel("Quantidade comprada: " + vendas.get(i).getQuantidadeVendida());
				dado_2.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_2.setBounds(10, 105, 270, 13);
				janela.add(dado_2);

				JLabel dado_3 = new JLabel("Código do pedido: " + vendas.get(i).getCodigoPedido());
				dado_3.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_3.setBounds(10, 127, 270, 13);
				janela.add(dado_3);

				JLabel dado_4 = new JLabel("Valor Frete: R$" + vendas.get(i).getValorFrete());
				dado_4.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_4.setBounds(10, 149, 270, 13);
				janela.add(dado_4);

				JLabel dado_5 = new JLabel("Valor Total: R$" + vendas.get(i).getValorTotal());
				dado_5.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_5.setBounds(10, 171, 270, 13);
				janela.add(dado_5);

				JLabel dado_6 = new JLabel("Forma de Pagamento: " + vendas.get(i).getFormaPagamento());
				dado_6.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_6.setBounds(10, 193, 270, 13);
				janela.add(dado_6);

				JButton botaoDelet = new JButton("Deletar");
				botaoDelet.addActionListener(new ActionListener() {

					// chama o método deletaVenda
					public void actionPerformed(ActionEvent e) {
						if (vendas.get(posicao).deletaVenda(vendas)) {
							JOptionPane.showMessageDialog(null, "Venda deletada com sucesso!");

							dispose();

							ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
							menu.setVisible(true);
							menu.setLocationRelativeTo(null);
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao deletar venda!", null,
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				botaoDelet.setBounds(155, 309, 85, 21);
				janela.add(botaoDelet);

				JButton botaoVolta = new JButton("Voltar");
				botaoVolta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();

						ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
						menu.setVisible(true);
						menu.setLocationRelativeTo(null);
					}
				});
				botaoVolta.setBounds(285, 309, 85, 21);
				janela.add(botaoVolta);

				break;

			}
		}
	}
}
