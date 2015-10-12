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

	public boolean hayBarcosEnPosicion(int fila, int columna) throws Exception {
		if ((fila < 0)||(fila >=alto)||(columna <0)||(columna >= ancho)){
			throw new Exception("posicion fuera de tablero");
		}
		return posicionesOcupadas[fila-1][columna-1];
	}	

	public boolean ubicarBarco(Barco barco, Posicion posicionInicial,
			String orientacion) throws Exception {		
		
		Posicion[] posiciones = posicionesAOcuparPorElBarco(barco.getTamanio(), posicionInicial, orientacion);		
		barco.setPosiciones(posiciones);
		if (this.estanDentroDelTablero(posiciones)){
			if (this.estanLibresLasPosiciones(posiciones)){
				this.ocuparPosiciones(posiciones);			
				return true;
			}
		}
		return false;
	}

	private void inicializarPosicionesOcupadas() {
		for (int i=0; i < this.alto; i++){
			for (int j=0; j < this.ancho; j++){
				this.posicionesOcupadas[i][j] = false;
			}
		}
	}

	private boolean estanDentroDelTablero(Posicion[] posiciones) {
		boolean filaValida = false;
		boolean columnaValida = false;
		for (Posicion actual:posiciones){
			filaValida = (actual.getFila() > 0)&&(actual.getFila() <= this.alto);
			columnaValida =(actual.getColumna() > 0)&&(actual.getColumna() <= this.ancho);			
		}
		return (filaValida && columnaValida);
	}

	private void ocuparPosiciones(Posicion[] posicionesOcupadas) {
		for(Posicion actual: posicionesOcupadas){
			this.posicionesOcupadas[actual.getFila()-1][actual.getColumna()-1] = true;			
		}
	}

	private boolean estanLibresLasPosiciones(Posicion[] posiciones) throws Exception {
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
