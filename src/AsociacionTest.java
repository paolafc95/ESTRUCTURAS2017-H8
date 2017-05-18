import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * *Byron Mota, 15246
 *Paola Fuentes, 151126
 * Clase para probar los metodos de insercion y busqueda para HashMap.
 */
public class AsociacionTest {
	/* Atributos*/
	public Asociacion<String, String> arbol = new Asociacion<String, String>();
	
	/**
	 * Probar metodo de busqueda.
	 */
	@Test
	public void testGet() {
		arbol.put("nombre", "name");
		assertEquals(arbol.get("nombre"), "name");
	}

	/**
	 * Probar metodo de insercion.
	 */
	@Test
	public void testPut() {
		arbol.put("nombre", "name");
		assertEquals(arbol.contains("nombre"), true);
	}

}
