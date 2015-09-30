package skeleton;

public class Juego {

	public int ganador(Jugador jugador1, Jugador jugador2) throws Exception {
		int jugadorGanador = 0;
		if (hayGanador(jugador1,jugador2)){			
			if (jugador1.getMovimiento().equals("PIEDRA")){
				if (jugador2.getMovimiento().equals("PAPEL")){
					jugadorGanador = jugador2.getNumero();
				}
				else{
					jugadorGanador = jugador1.getNumero();
				}	
			}
			else{
				if (jugador1.getMovimiento().equals("PAPEL")){
					if (jugador2.getMovimiento().equals("TIJERA")){
						jugadorGanador = jugador2.getNumero();
					}else{
						jugadorGanador = jugador1.getNumero();
					}	
				}
				else{
					if (jugador1.getMovimiento().equals("TIJERA")){
						if (jugador2.getMovimiento().equals("PIEDRA")){
							jugadorGanador = jugador2.getNumero();
						}else{
							jugadorGanador = jugador1.getNumero();
						}	
					}
					
				}
			}	
		}
		return jugadorGanador;
		
	}
	
	public boolean hayGanador(Jugador jugador1, Jugador jugador2){
		return !jugador1.getMovimiento().equals(jugador2.getMovimiento());
	}
	
}
