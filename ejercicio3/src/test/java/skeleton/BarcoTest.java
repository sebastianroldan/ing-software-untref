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
}
