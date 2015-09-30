package skeleton;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	
	private Jugador[] jugadores = new Jugador[2]; 	
	private Juego juego;
	private int ganador = 0;
	
	
    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
        Belly belly = new Belly();
        belly.eat(cukes);
    }
    
    @Given("^jugador(\\d+) juega PIEDRA$")
    public void jugador1_juega_PIEDRA(int numero) throws Throwable {
        jugadores[numero-1] = new Jugador();        
        jugadores[numero-1].setNumero(numero);
        jugadores[numero-1].setMovimiento("PIEDRA");
    }
    
    @When("^jugador(\\d+) juega TIJERA$")
    public void jugador2_juega_TIJERA(int numero) throws Throwable {
    	jugadores[numero-1] = new Jugador();
    	jugadores[numero-1].setNumero(numero);
        jugadores[numero-1].setMovimiento("TIJERA"); 
    }
    
	@When("^jugador(\\d+) juega PAPEL$")
	public void jugador2_juega_PAPEL(int numero) throws Throwable {
		jugadores[numero-1] = new Jugador();    
		jugadores[numero-1].setNumero(numero);
        jugadores[numero-1].setMovimiento("PAPEL");        
	}
	
	@Then("^gana jugador(\\d+)$")
	public void gana_jugador(int jugadorGanador) throws Throwable {
		juego = new Juego();
		ganador = juego.ganador(jugadores[0], jugadores[1]);
		if (ganador != jugadorGanador){
			throw new Exception();
		}
	}
	
	@Then("^hay empate$")
	public void hay_empate() throws Throwable {
		juego = new Juego();
		ganador = juego.ganador(jugadores[0], jugadores[1]);
		if (ganador != 0){
			throw new Exception();
		}
	}
}
