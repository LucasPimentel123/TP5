package teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.Cliente;
import modelo.Endereco;
import modelo.Tablete;
import modelo.Venda;

class TesteVenda {
	Endereco endTest = new Endereco();
	Cliente cTest = new Cliente("lucas", (long)999010737, (long)70673301, "prime", endTest);
	Cliente cTest2 = new Cliente("lucas", (long)999010737, (long)70673301, "tradicional", endTest);
	Tablete tTest = new Tablete(10.00, 100, "tablete", "90g", "amargo", "morango");
	List<Venda> vendas = new ArrayList<>();
	Venda v1 = new Venda("Crédito", cTest, tTest, 10, "0000", 100, 9.99);
	
	@Test
	void testeVerificaVendaExiste() {
		vendas.add(v1);
		assertTrue(Venda.verificaVendaExiste(vendas, "0000"));
		assertFalse(Venda.verificaVendaExiste(vendas, "1111"));
	}
	
	
	@Test
	void testDefineValorTotal() {
		assertEquals(20, Venda.defineValorTotal(tTest, 2, 0));
		assertNotEquals(20, Venda.defineValorTotal(tTest, 25, 9.99));
	}

	@Test
	void testDefineValorFrete() {
		assertEquals(0, Venda.defineValorFrete(cTest));
		assertEquals(9.99, Venda.defineValorFrete(cTest2));
	}

	@Test
	void testVerificaEstoque() {
		assertTrue(Venda.verificaEstoque(10000, tTest));
		assertFalse(Venda.verificaEstoque(10, tTest));
	}

}
