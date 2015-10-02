package skeleton;

public class Juego {

	public int ganador(Jugador jugador1, Jugador jugador2) throws Exception {
		int jugadorGanador = 0;
		if (hayGanador(jugador1,jugador2)){
			switch (jugador1.getMovimiento()) {
				case PIEDRA:jugadorGanador = ganadorCuandoJugador1JuegaPiedra(jugador2);
				break;
				case PAPEL:jugadorGanador = ganadorCuandoJugador1JuegaPapel(jugador2);
				break;
				case TIJERA:jugadorGanador = ganadorCuandoJugador1JuegaTijera(jugador2);
				break;
				default:break;
			}				
		}
		return jugadorGanador;
		
	}
	
	private int ganadorCuandoJugador1JuegaPiedra(Jugador jugador2){
		int jugadorGanador = 1;
			if (jugador2.getMovimiento()==Movimiento.PAPEL){				
				jugadorGanador = jugador2.getNumero();
			}		
		return jugadorGanador;
	}
	
	private int ganadorCuandoJugador1JuegaPapel(Jugador jugador2){
		int jugadorGanador = 1;
			if (jugador2.getMovimiento() == Movimiento.TIJERA){
				jugadorGanador = jugador2.getNumero();
			}		
		return jugadorGanador;
	}
	
	private int ganadorCuandoJugador1JuegaTijera(Jugador jugador2){
		int jugadorGanador = 1;
			if (jugador2.getMovimiento() == Movimiento.PIEDRA){
				jugadorGanador = jugador2.getNumero();
			}		
		return jugadorGanador;
	}
	
	public boolean hayGanador(Jugador jugador1, Jugador jugador2){
		return !jugador1.getMovimiento().equals(jugador2.getMovimiento());
	}
	
}
