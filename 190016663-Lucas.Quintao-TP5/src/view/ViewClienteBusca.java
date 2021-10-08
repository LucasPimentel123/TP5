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
 * classe para a janela de busca do cliente na interface gráfica
 * 
 * @author lucas pimentel quintão
 * @version final
 */

public class ViewClienteBusca extends JFrame {

	private JPanel janela;

	/**
	 * Mostra todos os dados do cliente que o usuário digitou no campo de busca
	 * 
	 * @param produtos  lista de produtos
	 * @param clientes  lista de clientes
	 * @param vendas    lista de vendas
	 * @param nomeBusca String contendo o nome do cliente digitado pelo usuário
	 */

	public ViewClienteBusca(List<Produto> produtos, List<Cliente> clientes, List<Venda> vendas, String nomeBusca) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 390);
		janela = new JPanel();
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		JLabel titulo = new JLabel("Dados do Cliente");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(120, 21, 214, 19);
		janela.add(titulo);

		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getNome().contains(nomeBusca)) {
				int posicao = i;

				JLabel dado = new JLabel("Nome: " + clientes.get(i).getNome());
				dado.setFont(new Font("Arial", Font.PLAIN, 13));
				dado.setBounds(10, 61, 210, 13);
				janela.add(dado);

				JLabel dado_1 = new JLabel("Telefone: " + clientes.get(i).getTelefone());
				dado_1.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_1.setBounds(10, 83, 210, 13);
				janela.add(dado_1);

				JLabel dado_2 = new JLabel("CPF: " + clientes.get(i).getCpf());
				dado_2.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_2.setBounds(10, 105, 210, 13);
				janela.add(dado_2);

				JLabel dado_3 = new JLabel("Tipo de cliente: " + clientes.get(i).getTipo());
				dado_3.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_3.setBounds(10, 127, 210, 13);
				janela.add(dado_3);

				JLabel dado_4 = new JLabel("Unidade Federativa: " + clientes.get(i).getEnderecoCliente().getEstado());
				dado_4.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_4.setBounds(10, 159, 210, 13);
				janela.add(dado_4);

				JLabel dado_5 = new JLabel("Cidade: " + clientes.get(i).getEnderecoCliente().getCidade());
				dado_5.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_5.setBounds(10, 181, 210, 13);
				janela.add(dado_5);

				JLabel dado_6 = new JLabel("CEP: " + clientes.get(i).getEnderecoCliente().getCep());
				dado_6.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_6.setBounds(10, 203, 210, 13);
				janela.add(dado_6);

				JLabel dado_7 = new JLabel("Bairro: " + clientes.get(i).getEnderecoCliente().getBairro());
				dado_7.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_7.setBounds(10, 225, 210, 13);
				janela.add(dado_7);

				JLabel dado_8 = new JLabel("Número: " + clientes.get(i).getEnderecoCliente().getNumero());
				dado_8.setFont(new Font("Arial", Font.PLAIN, 13));
				dado_8.setBounds(10, 247, 210, 13);
				janela.add(dado_8);

				JButton botaoEditar = new JButton("Editar");
				botaoEditar.addActionListener(new ActionListener() {

					// Abre a tela de editar dados do cliente quando o usuario apeta o botão
					public void actionPerformed(ActionEvent e) {
						ViewClienteEdita telaClienteEdita = new ViewClienteEdita(produtos, clientes, vendas,
								clientes.get(posicao));
						dispose();

						telaClienteEdita.setVisible(true);
						telaClienteEdita.setLocationRelativeTo(null);
					}
				});
				botaoEditar.setBounds(30, 309, 85, 21);
				janela.add(botaoEditar);

				JButton botaoDelet = new JButton("Deletar");
				botaoDelet.addActionListener(new ActionListener() {

					// chama a função de deletar o cliente quando o usuário aperta o botão
					public void actionPerformed(ActionEvent e) {
						if (clientes.get(posicao).deletaCliente(clientes)) {
							JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");

							dispose();

							ViewMenu menu = new ViewMenu(clientes, vendas, produtos);
							menu.setVisible(true);
							menu.setLocationRelativeTo(null);
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao deletar cliente!", null,
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
