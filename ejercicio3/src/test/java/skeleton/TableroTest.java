package skeleton;

import org.junit.Assert;
import org.junit.Test;

public class TableroTest {
	
	private Tablero unTablero = new Tablero(10,10);
	
	@Test
	public void altoYAnchoDeTableroDebenDevolver10Test(){		
		
		int alto = unTablero.altoDeTablero();
		int ancho = unTablero.anchoDeTablero();
		
		Assert.assertEquals(10, alto);
		Assert.assertEquals(10, ancho);
	}
	
	@Test
	public void noDebeHaberBarcosEnPosicionUnoTresTest(){
		
		Assert.assertFalse(unTablero.hayBarcosEnPosicion(1,3));		
	}	 
	
	@Test
	public void debePoderPosicionarUnAcorazadoEnUnoUnoHorizontalmenteTest() throws Exception{
		Barco barco = new Acorazado();		
		Posicion posicion = new Posicion(1,1);
		String orientado = "horizontalmente";
		
		Assert.assertTrue(unTablero.esPosibleUbicarBarco(barco, posicion, orientado));		
	}
	
	@Test
	public void debePoderPosicionarUnAcorazadoEnUnoUnoVerticalmenteTest() throws Exception{
		BarcoFactory fabrica = new BarcoFactory();		
		Posicion posicion = new Posicion(1,1);
		String orientado = "verticalmente";
		Barco barco = fabrica.crearBarco("Acorazado");
		Assert.assertTrue(unTablero.esPosibleUbicarBarco(barco, posicion, orientado));		
	}
	
	@Test(expected=Exception.class)
	public void noDebePoderPosicionarUnBarcoEnDiagonalTest() throws Exception{
		BarcoFactory fabrica = new BarcoFactory();		
		Posicion posicion = new Posicion(1,1);
		String orientado = "diagonalmente";
		Barco barco = fabrica.crearBarco("Acorazado");
		unTablero.esPosibleUbicarBarco(barco, posicion, orientado);		
	}
}