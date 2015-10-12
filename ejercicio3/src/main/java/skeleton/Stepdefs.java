package skeleton;


import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	
	private BatallaNaval batallaNaval = new BatallaNaval(10,10); 
	
	@Given("^posicion (\\d+),(\\d+) esta libre y posicion (\\d+),(\\d+) esta libre$")
	public void posicion_esta_libre_y_posicion_esta_libre(int fila1, int columna1, int fila2, int columna2) throws Throwable {
		Assert.assertFalse((batallaNaval.hayBarcosEnPosicion(fila1, columna1))||
				(batallaNaval.hayBarcosEnPosicion(fila2, columna2)));
	}

	@When("^jugador posiciona un \"(.*?)\" en la posicion (\\d+),(\\d+) \"(.*?)\"$")
	public void jugador_posiciona_un_en_la_posicion(String barco, int fila, int columna, String orientacion) throws Throwable {
		Assert.assertTrue(batallaNaval.posicionar(barco,fila,columna,orientacion));
	}
	
	@Then("^barco posicionado exitosamente$")
	public void barco_posicionado_exitosamente() throws Throwable {
		Assert.assertTrue(batallaNaval.hayBarcosEnPosicion(1,1));
	}
	
}
