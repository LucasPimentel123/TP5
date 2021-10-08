package teste;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import modelo.*;

import org.junit.jupiter.api.Test;

class TesteCliente {
	Endereco endTest = new Endereco();
	Cliente c = new Cliente();
	Cliente clienteTeste = new Cliente("lucas", (long)999010737, (long)70673301, "prime", endTest);
	Cliente clienteTeste2 = new Cliente("lucas", (long)999875634, (long)70673301, "tradicional", endTest);
	List<Cliente> clientes = new ArrayList<>();
	
	@Test
	void testVerificaClienteExiste() {
		clientes.add(clienteTeste);
		
		assertTrue(Cliente.verificaClienteExiste("lucas", clientes));
		assertFalse(Cliente.verificaClienteExiste("pedro", clientes));
	}


}
