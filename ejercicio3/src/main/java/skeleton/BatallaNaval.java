package skeleton;

import java.util.LinkedList;
import java.util.List;

public class BatallaNaval {
	
	private Tablero tablero;	
	private BarcoFactory fabricaBarcos;	
	private List<Barco> barcos;
	
	public BatallaNaval(int ancho, int alto){
		this.tablero = new Tablero(ancho,alto);	
		this.fabricaBarcos = new BarcoFactory();
		this.barcos = new LinkedList<Barco>();
	}

	public boolean hayBarcosEnPosicion(int fila, int columna) throws Exception{		
		return this.tablero.hayBarcosEnPosicion(fila,columna);
	}

	public boolean posicionar(String tipoBarco, int fila, int columna,
										String orientacion) throws Exception {		
		boolean ubicado = false;
		Barco barco = fabricaBarcos.crearBarco(tipoBarco);
		Posicion posicionBarco = new Posicion(fila, columna);			
		if  (this.tablero.ubicarBarco(barco, posicionBarco, orientacion)){
			barcos.add(barco);
			ubicado = true;
		}
		return ubicado;
	}

	public boolean disparar(int fila, int columna) throws Exception {
		
		return dioEnElBlanco(fila, columna);
	}

	private boolean dioEnElBlanco(int fila, int columna) throws Exception {
		boolean acerto = false;
		Posicion disparo = new Posicion(fila, columna);
		if (this.hayBarcosEnPosicion(fila, columna)){
			acerto = true;
			this.actualizarDañoAlBarco(disparo);
		}
		return acerto;
	}

	private void actualizarDañoAlBarco(Posicion posicionDisparo) {		
		for (Barco barco:barcos){
			if (barco.estasEnEstaPosicion(posicionDisparo)){
				barco.producirDanio(posicionDisparo);
			}
		}
	}

	public boolean fueHundidoElBarcoEnLaPosicion(int fila, int columna) {
		boolean hundido = false;
		for (Barco barco:barcos){
			if (barco.estasEnEstaPosicion(new Posicion(fila,columna))){
				hundido = barco.estasHundido();
			}
		}
		return hundido;
	}	

}
