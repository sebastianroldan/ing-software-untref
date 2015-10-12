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
	public void noDebeHaberBarcosEnPosicionUnoTresTest() throws Exception{
		
		Assert.assertFalse(unTablero.hayBarcosEnPosicion(1,3));		
	}	 
	
	@Test
	public void debePoderPosicionarUnAcorazadoEnUnoUnoHorizontalmenteTest() throws Exception{
		Barco barco = new Acorazado();		
		Posicion posicion = new Posicion(1,1);
		String orientado = "horizontalmente";
		
		Assert.assertTrue(unTablero.ubicarBarco(barco, posicion, orientado));		
	}
	
	@Test
	public void debePoderPosicionarUnAcorazadoEnUnoUnoVerticalmenteTest() throws Exception{
		BarcoFactory fabrica = new BarcoFactory();		
		Posicion posicion = new Posicion(1,1);
		String orientado = "verticalmente";
		
		Barco barco = fabrica.crearBarco("Acorazado");
		
		Assert.assertTrue(unTablero.ubicarBarco(barco, posicion, orientado));		
	}
	
	@Test(expected=Exception.class)
	public void noDebePoderPosicionarUnBarcoEnDiagonalTest() throws Exception{
		BarcoFactory fabrica = new BarcoFactory();		
		Posicion posicion = new Posicion(1,1);
		String orientado = "diagonalmente";
		
		Barco barco = fabrica.crearBarco("Acorazado");
		unTablero.ubicarBarco(barco, posicion, orientado);		
	}
	
	@Test
	public void noDebePoderPosicionarUnBarcoFueraDelTableroTest() throws Exception{
		BarcoFactory fabrica = new BarcoFactory();		
		Posicion posicion = new Posicion(11,1);		
		
		Barco barco = fabrica.crearBarco("Acorazado");
		
		Assert.assertFalse(unTablero.ubicarBarco(barco, posicion, "horizontalmente"));
	}
	
	@Test
	public void noDebePoderPosicionarUnBarcoConCoordenadasNegativasTest() throws Exception{
		BarcoFactory fabrica = new BarcoFactory();		
		Posicion posicion = new Posicion(-2,-3);		
		
		Barco barco = fabrica.crearBarco("Acorazado");
		
		Assert.assertFalse(unTablero.ubicarBarco(barco, posicion, "horizontalmente"));
	}
	
	@Test (expected=Exception.class)
	public void alPreguntaPorPosicionesFueraDelTableroDebeLanzarUnaExceptionTest() throws Exception{
		
		unTablero.hayBarcosEnPosicion(3, 15);
	}

}
