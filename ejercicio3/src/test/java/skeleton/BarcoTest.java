package skeleton;

import org.junit.Assert;
import org.junit.Test;

public class BarcoTest {
	
	@Test
	public void posicionUnoDosDebeEstarDaniadaTest(){
		Barco unBarco = new Acorazado();
		Posicion[] ubicacion =  new Posicion[2];
		ubicacion[0]= new Posicion(1,2);
		ubicacion[1]= new Posicion(1,3);
		unBarco.setPosiciones(ubicacion);
		unBarco.producirDanio(ubicacion[0]);
		
		Assert.assertTrue(unBarco.posicionEstaDaniada(new Posicion(1,2)));
	}
	
	@Test
	public void debeEstarEnPosicionTresDosTest(){
		
		Barco unBarco = new Acorazado();
		Posicion[] ubicacion =  new Posicion[2];
		ubicacion[0]= new Posicion(3,2);
		ubicacion[1]= new Posicion(4,2);
		unBarco.setPosiciones(ubicacion);		
				
		Assert.assertTrue(unBarco.estasEnEstaPosicion(new Posicion(3,2)));
	}
	
	@Test
	public void posicionEstaDaniadaDeberiaDevolverFalseTest(){
		Barco otroBarco = new Acorazado();		
		Posicion[] posiciones = new Posicion[2];
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		posiciones[0]=(posicion1);
		posiciones[1]=(posicion2);
		
		otroBarco.setPosiciones(posiciones);
		
		Assert.assertFalse(otroBarco.posicionEstaDaniada(posicion1));
	}
	
	@Test
	public void posicionEstaDaniadaDeberiaDevolverTrueTest(){
		Barco otroBarco = new Acorazado();		
		Posicion[] posiciones = new Posicion[2];
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		posiciones[0]=(posicion1);
		posiciones[1]=(posicion2);
		
		otroBarco.setPosiciones(posiciones);
		otroBarco.producirDanio(posicion2);
		
		Assert.assertTrue(otroBarco.posicionEstaDaniada(posicion2));
	}
		
	@Test
	public void estasHundidoDeberiaDevolverFalseTest(){
		Barco otroBarco = new Acorazado();		
		Posicion[] posiciones = new Posicion[2];
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		posiciones[0]=(posicion1);
		posiciones[1]=(posicion2);
		
		otroBarco.setPosiciones(posiciones);
		otroBarco.producirDanio(posicion1);		
		
		Assert.assertFalse(otroBarco.estasHundido());
	}
	
	@Test
	public void estasHundidoDeberiaDevolverTrueTest(){
		Barco otroBarco = new Acorazado();		
		Posicion[] posiciones = new Posicion[2];
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		posiciones[0]=(posicion1);
		posiciones[1]=(posicion2);
		
		otroBarco.setPosiciones(posiciones);
		otroBarco.producirDanio(posicion1);		
		otroBarco.producirDanio(posicion2);
		
		Assert.assertTrue(otroBarco.estasHundido());
	}
}
