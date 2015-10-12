package skeleton;

public class BatallaNaval {
	
	private Tablero tablero;	
	private BarcoFactory fabricaBarcos;
	
	public BatallaNaval(int ancho, int alto){
		this.tablero = new Tablero(ancho,alto);	
		this.fabricaBarcos = new BarcoFactory();
	}

	public boolean hayBarcosEnPosicion(int fila, int columna) throws Exception{		
		return this.tablero.hayBarcosEnPosicion(fila,columna);
	}

	public boolean posicionar(String tipoBarco, int fila, int columna,
										String orientacion) throws Exception {		
		
		Barco barco = fabricaBarcos.crearBarco(tipoBarco);
		Posicion posicionBarco = new Posicion(fila, columna);		
		return this.tablero.ubicarBarco(barco, posicionBarco, orientacion);
	}

	public boolean disparar(int fila, int columna) throws Exception {
		
		return dioEnElBlanco(fila, columna);
	}

	private boolean dioEnElBlanco(int fila, int columna) throws Exception {
		
		return this.hayBarcosEnPosicion(fila, columna);
	}	

}
