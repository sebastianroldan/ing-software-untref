package skeleton;

import java.util.HashMap;
import java.util.Map;

public abstract class Barco {

	private int tamanio;
	private Map<Posicion,Boolean> posiciones = new HashMap<Posicion,Boolean>();

	public int getTamanio() {
		
		return this.tamanio;
	}

	public void setTamanio(int tamanio) {		
		
		this.tamanio = tamanio;
	}

	public void setPosiciones(Posicion[] posiciones) {
		for (Posicion pos:posiciones){
			this.posiciones.put(pos, false);
		}		
	}

	public boolean estasEnEstaPosicion(Posicion posicion) {
		
		return this.posiciones.containsKey(posicion);
	}

	public void producirDanio(Posicion posicionDisparo) {
		boolean danio = true;
		this.posiciones.put(posicionDisparo, danio);
	}

	public boolean posicionEstaDaniada(Posicion posicion){
		return this.posiciones.get(posicion);
	}
}
