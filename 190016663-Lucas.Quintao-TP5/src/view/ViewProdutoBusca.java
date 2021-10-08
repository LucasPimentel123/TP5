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

import modelo.Bombom;
import modelo.ChocolateEmPo;
import modelo.Cliente;
import modelo.Produto;
import modelo.Tablete;
import modelo.Trufa;
import modelo.Venda;

/**
 * classe para a janela de busca de produto na interface gráfica
 * 
 * @author lucas pimentel quintão
 * @version final
 */

public class ViewProdutoBusca extends JFrame {
	private JPanel janela;

	/**
	 * Mostra os dados do produto buscado pelo usuário, mostrando diferentes campos
	 * de acordo com a classe do produto
	 * 
	 * @param produtos  ArrayList de produtos
	 * @param clientes  ArrayList de clientes
	 * @param vendas    ArrayList de vendas
	 * @param nomeBusca nome do produto digitado pelo usuário
	 */

	public ViewProdutoBusca(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas, String nomeBusca) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 390);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		JLabel titulo = new JLabel("Dados do Produto");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(120, 21, 214, 19);
		janela.add(titulo);

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getNome().toLowerCase().equals(nomeBusca)) {
				int posicao = i;

				JLabel dado = new JLabel("Nome: " + produtos.get(i).getNome());
				dado.setFont(new Font("Arial", Font.PLAIN, 13));
				dado.setBounds(10, 61, 210, 13);
				janela.add(dado);

				JLabel dado_1 = new JLabel("Preço: " + produtos.get(i).getPreco());
				dado_1.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_1.setBounds(10, 83, 210, 13);
				janela.add(dado_1);

				JLabel dado_2 = new JLabel("Quantidade Estoque: " + produtos.get(i).getQuantidadeEstoque());
				dado_2.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_2.setBounds(10, 105, 210, 13);
				janela.add(dado_2);

				if (produtos.get(i).getClass().getSimpleName().equals("Tablete")) {
					Tablete tablete = (Tablete) produtos.get(i);

					JLabel dado_3 = new JLabel("Peso do Tablete: " + tablete.getPeso());
					dado_3.setFont(new Font("Arial", Font.PLAIN, 13));
					dado_3.setBounds(10, 127, 210, 13);
					janela.add(dado_3);

					JLabel dado_4 = new JLabel("Recheio do Tablete: " + tablete.getRecheio());
					dado_4.setFont(new Font("Arial", Font.PLAIN, 13));
					dado_4.setBounds(10, 149, 270, 13);
					janela.add(dado_4);

					JLabel dado_5 = new JLabel("Tipo de chocolate: " + tablete.getTipoDeChocolate());
					dado_5.setFont(new Font("Arial", Font.PLAIN, 13));
					dado_5.setBounds(10, 171, 250, 13);
					janela.add(dado_5);

				}

				if (produtos.get(i).getClass().getSimpleName().equals("Bombom")) {
					Bombom bombom = (Bombom) produtos.get(i);

					JLabel dado_3 = new JLabel("Recheio do Bombom: " + bombom.getRecheio());
					dado_3.setFont(new Font("Arial", Font.PLAIN, 13));
					dado_3.setBounds(10, 127, 270, 13);
					janela.add(dado_3);

				}

				if (produtos.get(i).getClass().getSimpleName().equals("Trufa")) {
					Trufa trufa = (Trufa) produtos.get(i);

					JLabel dado_3 = new JLabel("Recheio da Trufa: " + trufa.getRecheio());
					dado_3.setFont(new Font("Arial", Font.PLAIN, 13));
					dado_3.setBounds(10, 127, 270, 13);
					janela.add(dado_3);

					JLabel dado_4 = new JLabel("Tipo da Trufa: " + trufa.getTipo());
					dado_4.setFont(new Font("Arial", Font.PLAIN, 13));
					dado_4.setBounds(10, 149, 270, 13);
					janela.add(dado_4);
				}

				if (produtos.get(i).getClass().getSimpleName().equals("ChocolateEmPo")) {
					ChocolateEmPo chocEmPo = (ChocolateEmPo) produtos.get(i);

					JLabel dado_3 = new JLabel("Chocolate: " + chocEmPo.getChocolate());
					dado_3.setFont(new Font("Arial", Font.PLAIN, 13));
					dado_3.setBounds(10, 127, 270, 13);
					janela.add(dado_3);

					JLabel dado_4 = new JLabel("Tamanho do saco: " + chocEmPo.getTamanho());
					dado_4.setFont(new Font("Arial", Font.PLAIN, 13));
					dado_4.setBounds(10, 149, 210, 13);
					janela.add(dado_4);

					JLabel dado_5 = new JLabel("Tipo de chocolate em pó: " + chocEmPo.getTipo());
					dado_5.setFont(new Font("Arial", Font.PLAIN, 13));
					dado_5.setBounds(10, 171, 270, 13);
					janela.add(dado_5);
				}

				// Abre a janela de edição de dados do produto
				JButton botaoEditar = new JButton("Editar");
				botaoEditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ViewProdutoEdita telaProdutoEdita = new ViewProdutoEdita(produtos, clientes, vendas,
								produtos.get(posicao));
						telaProdutoEdita.setVisible(true);
						telaProdutoEdita.setLocationRelativeTo(null);
						dispose();
					}
				});
				botaoEditar.setBounds(30, 309, 85, 21);
				janela.add(botaoEditar);

				// Chama a função deletaPorduto e remove o produto da lista de produtos
				// cadastrados
				JButton botaoDelet = new JButton("Deletar");
				botaoDelet.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (produtos.get(posicao).deletaProduto(produtos)) {
							JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");

							dispose();

							ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
							menu.setVisible(true);
							menu.setLocationRelativeTo(null);
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao deletar produto!", null,
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
