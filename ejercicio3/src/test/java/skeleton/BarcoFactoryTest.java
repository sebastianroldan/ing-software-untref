package skeleton;

import org.junit.Test;

public class BarcoFactoryTest {
	
	@Test(expected=Exception.class)

	public void noDeberiaCrearUnBarcoDesconocidoTest() throws Exception{
		BarcoFactory fabrica = new BarcoFactory();
		fabrica.crearBarco("Crucero");
	}
}
