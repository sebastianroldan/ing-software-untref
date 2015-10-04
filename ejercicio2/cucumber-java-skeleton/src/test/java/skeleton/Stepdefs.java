package skeleton;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	
	private Ahorcado ahorcado;
	
	@Given("^la palabra secreta es \"(.*?)\" And me quedan (\\d+) vidas$")
	public void la_palabra_secreta_es_And_me_quedan_vidas(String palabraSecreta, int vidas) throws Throwable {
		ahorcado = new Ahorcado();
	    ahorcado.setPalabraSecreta(palabraSecreta);
	    ahorcado.setVidasRestantes(vidas);
	}

	@When("^arriesgo \"(.*?)\"$")
	public void arriesgo(String letra) throws Throwable {
	 
	    ahorcado.arriesgo(letra);
	}

	@Then("^estado es \"(.*?)\"  And me quedan (\\d+) vidas$")
	public void estado_es_And_me_quedan_vidas(String estado, int vidasRestantes) throws Throwable {
	    if (ahorcado.getVidas() != vidasRestantes){
	    	 throw new Exception();
	    }
	}
	
}
