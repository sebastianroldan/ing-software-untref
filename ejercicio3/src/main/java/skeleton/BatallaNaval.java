package skeleton;

public class BatallaNaval {
	
	private Tablero tablero;	
	private BarcoFactory fabricaBarcos;
	
	public BatallaNaval(int ancho, int alto){
		this.tablero = new Tablero(ancho,alto);
		this.fabricaBarcos = new BarcoFactory();
	}

	public boolean hayBarcosEnPosicion(int fila, int columna) {
		return this.tablero.hayBarcosEnPosicion(fila,columna);
	}

	public boolean posicionar(String tipoBarco, int fila, int columna,
			String orientacion) throws Exception {		
		Barco barco = fabricaBarcos.crearBarco(tipoBarco);
		Posicion posicionBarco = new Posicion(fila, columna);
		System.out.println(posicionBarco.getFila());
		System.out.println(barco.getTamanio());
		boolean resultado = this.tablero.esPosibleUbicarBarco(barco, posicionBarco, orientacion);
		return resultado; 
	}	

}