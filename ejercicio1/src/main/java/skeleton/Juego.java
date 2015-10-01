package skeleton;

public class Juego {

	public int ganador(Jugador jugador1, Jugador jugador2) throws Exception {
		int jugadorGanador = 0;
		if (hayGanador(jugador1,jugador2)){				
			if (jugador1.getMovimiento().equals("PIEDRA")){
				jugadorGanador = ganadorCuandoJugador1JuegaPiedra(jugador2);
			}
			else{
				if (jugador1.getMovimiento().equals("PAPEL")){
					jugadorGanador = ganadorCuandoJugador1JuegaPapel(jugador2);
				}
				else{
					if (jugador1.getMovimiento().equals("TIJERA")){
						jugadorGanador = ganadorCuandoJugador1JuegaTijera(jugador2);
					}
					
				}
			}	
		}
		return jugadorGanador;
		
	}
	
	private int ganadorCuandoJugador1JuegaPiedra(Jugador jugador2){
		int jugadorGanador = 1;
			if (jugador2.getMovimiento().equals("PAPEL")){
				jugadorGanador = jugador2.getNumero();
			}		
		return jugadorGanador;
	}
	
	private int ganadorCuandoJugador1JuegaPapel(Jugador jugador2){
		int jugadorGanador = 1;
			if (jugador2.getMovimiento().equals("TIJERA")){
				jugadorGanador = jugador2.getNumero();
			}		
		return jugadorGanador;
	}
	
	private int ganadorCuandoJugador1JuegaTijera(Jugador jugador2){
		int jugadorGanador = 1;
			if (jugador2.getMovimiento().equals("PIEDRA")){
				jugadorGanador = jugador2.getNumero();
			}		
		return jugadorGanador;
	}
	
	public boolean hayGanador(Jugador jugador1, Jugador jugador2){
		return !jugador1.getMovimiento().equals(jugador2.getMovimiento());
	}
	
}
