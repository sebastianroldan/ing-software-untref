package skeleton;

public class Posicion{
	
	private int fila;
	private int columna;
	
	public Posicion(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}
	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}
	
	@Override
	public int hashCode() {
		return (int) fila;
	}
	
	@Override
	public boolean equals(Object obj) {
		Posicion posicion = (Posicion) obj;
		return ((this.getFila() == posicion.getFila())&&(this.getColumna() == posicion.getColumna()));	
	}
}
