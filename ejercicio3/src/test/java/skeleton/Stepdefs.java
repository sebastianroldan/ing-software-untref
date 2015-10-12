package skeleton;


import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	
	private BatallaNaval batalla1 = new BatallaNaval(10,10);
	private BatallaNaval batalla2 = new BatallaNaval(10,10);
	private BatallaNaval batalla3;
	
	@Given("^posicion (\\d+),(\\d+) esta libre y posicion (\\d+),(\\d+) esta libre$")
	public void posicion_esta_libre_y_posicion_esta_libre(int fila1, int columna1, int fila2, int columna2) throws Throwable {		
		Assert.assertFalse((batalla1.hayBarcosEnPosicion(fila1, columna1))||
				(batalla1.hayBarcosEnPosicion(fila2, columna2)));
	}
	
	@Given("^hay un barco en posicion (\\d+),(\\d+)$")
	public void hay_un_barco_en_posicion(int fila, int columna) throws Throwable {
		batalla2.posicionar("Destructor", fila, columna, "horizontalmente");
		Assert.assertTrue(batalla2.hayBarcosEnPosicion(fila,columna));
	}
	
	@Given("^tablero es de (\\d+) x (\\d+)$")
	public void tablero_es_de_x(int alto, int ancho) throws Throwable {
		batalla3 = new BatallaNaval(alto,ancho);		
	}

	@When("^jugador posiciona un \"(.*?)\" en la posicion (\\d+),(\\d+) \"(.*?)\"$")
	public void jugador_posiciona_un_en_la_posicion(String barco, int fila, int columna, String orientacion) throws Throwable {		
		Assert.assertTrue(batalla1.posicionar(barco,fila,columna,orientacion));
	}
	
	@When("^jugador posiciona un barco en la posicion (\\d+),(\\d+)$")
	public void jugador_posiciona_un_barco_en_la_posicion(int fila, int columna) throws Throwable {
		Assert.assertFalse(batalla2.posicionar("Lancha",fila,columna,"horizontalmente"));
	}
	
	@When("^jugador posiciona un Destructor en la posicion (\\d+),(\\d+), verticalmente$")
	public void jugador_posiciona_un_Destructor_en_la_posicion_verticalmente(int fila, int columna) throws Throwable {		
		Assert.assertFalse(batalla2.posicionar("Destructor",fila,columna,"verticalmente"));
	}
	
	@When("^jugador posiciona un Destructor en la posicion (\\d+),(\\d+)$")
	public void jugador_posiciona_un_Destructor_en_la_posicion(int fila, int columna) throws Throwable {
		Assert.assertFalse(batalla3.posicionar("Destructor",fila,columna,"horizontalmente"));
	}
	
	@Then("^barco posicionado exitosamente$")
	public void barco_posicionado_exitosamente() throws Throwable {
		Assert.assertTrue(batalla1.hayBarcosEnPosicion(1,1));
	}
	
	@Then("^posicion ocupada no se puede ubicar el barco alli$")
	public void posicion_ocupada_no_se_puede_ubicar_el_barco_alli() throws Throwable {
	    Assert.assertTrue(batalla2.hayBarcosEnPosicion(1,1));
	}
	
	@Then("^posicion intermedia ocupada no se puede ubicar el barco alli$")
	public void posicion_intermedia_ocupada_no_se_puede_ubicar_el_barco_alli() throws Throwable {
	    Assert.assertFalse(batalla1.hayBarcosEnPosicion(2,6)); 
	}
	
	@Then("^la posicion elegida no pertenece al tablero$")
	public void la_posicion_elegida_no_pertenece_al_tablero() throws Throwable {
		try{
			batalla3.hayBarcosEnPosicion(11,1);			
		}catch(Exception e){
			Assert.assertTrue(e.getMessage().equals("posicion fuera de tablero"));
		}	
	}
}
