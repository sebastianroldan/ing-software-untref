package skeleton;

public class Tablero {

	private int alto;
	private int ancho;	
	private boolean[][] posicionesOcupadas;

	public Tablero(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;		
		this.posicionesOcupadas = new boolean[alto][ancho];
		this.inicializarPosicionesOcupadas();
	}	

	public int altoDeTablero() {		
		return this.alto;
	}

	public int anchoDeTablero() {	
		return this.ancho;
	}

	public boolean hayBarcosEnPosicion(int fila, int columna) { 
		return posicionesOcupadas[fila][columna];
	}
	
	private void inicializarPosicionesOcupadas() {
		for (int i=0; i < this.alto; i++){
			for (int j=0; j < this.ancho; j++){
				this.posicionesOcupadas[i][j] = false;
			}
		}
	}

	public boolean ubicarBarco(Barco barco, Posicion posicionInicial,
			String orientacion) throws Exception {		
		Posicion[] posiciones = posicionesAOcuparPorElBarco(barco.getTamanio(), posicionInicial, orientacion);		
		if (this.estanLibresLasPosiciones(posiciones)){
			this.ocuparPosiciones(posiciones);			
			return true;
		}
		return false;
	}

	private void ocuparPosiciones(Posicion[] posicionesOcupadas) {
		for(Posicion actual: posicionesOcupadas){
			this.posicionesOcupadas[actual.getFila()][actual.getColumna()] = true;			
		}
	}

	private boolean estanLibresLasPosiciones(Posicion[] posiciones) {
		boolean estanLibres = true;
		for(Posicion actual: posiciones){
			estanLibres = (estanLibres && !this.hayBarcosEnPosicion(actual.getFila(), actual.getColumna()));
		}
		return estanLibres;
	}

	private Posicion[] posicionesAOcuparPorElBarco(int tamanio,
			Posicion posInicial, String orientacion) throws Exception {
		Posicion[] posiciones = new Posicion[tamanio];		
		if (orientacion.toLowerCase().equals("horizontalmente")){
			for (int i=0; i < tamanio; i++){
				posiciones[i]= new Posicion(posInicial.getFila(), posInicial.getColumna()+i);				
			}
		}else{
			if (orientacion.toLowerCase().equals("verticalmente")){
				for (int i=0; i < tamanio; i++){
					posiciones[i]= new Posicion(posInicial.getFila()+i, posInicial.getColumna());
				}
			}else{
				throw new Exception("Orientacion desconocida");
			}
		}
		
		return posiciones;
	}

}
