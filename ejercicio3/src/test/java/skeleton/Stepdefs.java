package skeleton;


import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	
	private BatallaNaval batalla1 = new BatallaNaval(10,10);
	private BatallaNaval batalla2 = new BatallaNaval(10,10);
	private BatallaNaval batalla3 = new BatallaNaval(10,10);
	
	@Given("^posicion (\\d+),(\\d+) esta libre y posicion (\\d+),(\\d+) esta libre$")
	public void posicion_esta_libre_y_posicion_esta_libre(int fila1, int columna1, int fila2, int columna2) throws Throwable {		
		Assert.assertFalse((batalla1.hayBarcosEnPosicion(fila1, columna1))||
				(batalla1.hayBarcosEnPosicion(fila2, columna2)));
	}
	
	@When("^jugador posiciona un \"(.*?)\" en la posicion (\\d+),(\\d+) \"(.*?)\"$")
	public void jugador_posiciona_un_en_la_posicion(String barco, int fila, int columna, String orientacion) throws Throwable {		
		Assert.assertTrue(batalla1.posicionar(barco,fila,columna,orientacion));
	}
	
	@Then("^barco posicionado exitosamente$")
	public void barco_posicionado_exitosamente() throws Throwable {
		Assert.assertTrue(batalla1.hayBarcosEnPosicion(1,1));
	}
	
	@Given("^hay un barco en posicion (\\d+),(\\d+)$")
	public void hay_un_barco_en_posicion(int fila, int columna) throws Throwable {
		batalla2.posicionar("Destructor", fila, columna, "horizontalmente");
		Assert.assertTrue(batalla2.hayBarcosEnPosicion(fila,columna));
	}
	
	@When("^jugador posiciona un barco en la posicion (\\d+),(\\d+)$")
	public void jugador_posiciona_un_barco_en_la_posicion(int fila, int columna) throws Throwable {
		Assert.assertFalse(batalla2.posicionar("Lancha",fila,columna,"horizontalmente"));
	}
	
	@Then("^posicion ocupada no se puede ubicar el barco alli$")
	public void posicion_ocupada_no_se_puede_ubicar_el_barco_alli() throws Throwable {
	    Assert.assertTrue(batalla2.hayBarcosEnPosicion(1,1));
	}
	
	@When("^jugador posiciona un Destructor en la posicion (\\d+),(\\d+), verticalmente$")
	public void jugador_posiciona_un_Destructor_en_la_posicion_verticalmente(int fila, int columna) throws Throwable {		
		Assert.assertFalse(batalla2.posicionar("Destructor",fila,columna,"verticalmente"));
	}
	
	@Then("^posicion intermedia ocupada no se puede ubicar el barco alli$")
	public void posicion_intermedia_ocupada_no_se_puede_ubicar_el_barco_alli() throws Throwable {
		Assert.assertFalse(batalla1.hayBarcosEnPosicion(2,6)); 
	}

	@Given("^tablero es de (\\d+) x (\\d+)$")
	public void tablero_es_de_x(int alto, int ancho) throws Throwable {
		batalla3 = new BatallaNaval(alto,ancho);		
	}
	
	@When("^jugador posiciona un Destructor en la posicion (\\d+),(\\d+)$")
	public void jugador_posiciona_un_Destructor_en_la_posicion(int fila, int columna) throws Throwable {
		Assert.assertFalse(batalla3.posicionar("Destructor",fila,columna,"horizontalmente"));
	}

	@Then("^la posicion elegida no pertenece al tablero$")
	public void la_posicion_elegida_no_pertenece_al_tablero() throws Throwable {
		try{
			batalla3.hayBarcosEnPosicion(11,1);	
			Assert.fail();
		}catch(Exception e){
			Assert.assertTrue(e.getMessage().equals("posicion fuera de tablero"));
		}	
	}
	
	@Given("^no hay barcos en posicion (\\d+),(\\d+)$")
	public void no_hay_barcos_en_posicion(int fila, int columna) throws Throwable {
		Assert.assertFalse((batalla2.hayBarcosEnPosicion(fila, columna)));
	}
	
	@When("^disparo a la posicion (\\d+),(\\d+)$")
	public void disparo_a_la_posicion(int fila, int columna) throws Throwable {
		batalla2.disparar(fila, columna);
	}
	
	@Then("^el disparo dio en el agua$")
	public void el_disparo_dio_en_el_agua() throws Throwable {
		Assert.assertFalse(batalla2.disparar(4,8));
	}
	
	@Then("^el disparo dio en el blanco$")
	public void el_disparo_dio_en_el_blanco() throws Throwable {
	    Assert.assertTrue(batalla2.disparar(5,5));
	}
	
	@Given("^disparo a la posicion (\\d+),(\\d+) And el disparo dio en el blanco$")
	public void disparo_a_la_posicion_And_el_disparo_dio_en_el_blanco(int fila, int columna) throws Throwable {
		Assert.assertTrue(batalla3.posicionar("Acorazado",fila,columna,"horizontalmente"));
		Assert.assertTrue(batalla3.disparar(fila,columna));	
	}
	
	@When("^todas las posiciones del barco han sido destruidas$")
	public void todas_las_posiciones_del_barco_han_sido_destruidas() throws Throwable {
		Assert.assertTrue(batalla3.disparar(1,9));
	}
	
	@Then("^el barco ha sido hundido$")
	public void el_barco_ha_sido_hundido() throws Throwable {
		Assert.assertTrue(batalla3.fueHundidoElBarcoEnLaPosicion(1,8));
	}
	
	@When("^disparo hacia la posicion (\\d+),(\\d+)$")
	public void disparo_hacia_la_posicion(int fila, int columna) throws Throwable {
		try{
			batalla3.disparar(fila, columna);
			Assert.fail();
		}catch(Exception e){
			Assert.assertTrue(e.getMessage().equals("posicion fuera de tablero"));
		}
	}
	
	@Then("^no se puede disparar a esa posicion$")
	public void no_se_puede_disparar_a_esa_posicion() throws Throwable {
		try{
			batalla3.disparar(11,1);
			Assert.fail();
		}catch(Exception e){
			Assert.assertTrue(e.getMessage().equals("posicion fuera de tablero"));
		}
	}
}
