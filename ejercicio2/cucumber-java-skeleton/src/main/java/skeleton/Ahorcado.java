package skeleton;

public class Ahorcado {

	private int vidas = 7;
	private String palabraSecreta = "auto";
	private String estado = "****";
	
	public void setVidasRestantes(int vidasRestantes) {
		this.vidas = vidasRestantes;
	}
	
	public void setPalabraSecreta(String palabraSecreta){
		palabraSecreta.toLowerCase();
		this.palabraSecreta = palabraSecreta;
	}

	public void arriesgo(String letra) {
		Character letraEnMinuscula = letra.toLowerCase().toCharArray()[0];
		if (acerto(letraEnMinuscula)){
			modificarEstado(letraEnMinuscula);			
		}
		else{
			descontarVida();
		}
	}

	public int getVidas() {
		
		return this.vidas;
	}
	
	private void descontarVida() {
		this.vidas = this.vidas - 1;
		
	}
	
	public void setEstado(String nuevoEstado) {		
		this.estado = nuevoEstado;
	}

	public String getEstado() {		
		return this.estado;
	}

	private void modificarEstado(Character letra) {		
		char[] nuevoEstado = estado.toCharArray();
		String estadoEnString = "";
		for (int i=0; i < this.palabraSecreta.length(); i++){
			if (letra.equals(palabraSecreta.charAt(i))){
				nuevoEstado[i] = letra;
			}
			estadoEnString = estadoEnString + nuevoEstado[i]; 
		}		
		this.setEstado(estadoEnString);
	}

	private boolean acerto(Character letra) {
		boolean acerto = false;
		for (int i=0; i < this.palabraSecreta.length(); i++){
			if (letra.equals(palabraSecreta.charAt(i))){				
				acerto = true;
			}			
		}
		return acerto;
	}

	public boolean elJugadorAdivinoLaPalabra() {
		
		return this.estado.equals(this.palabraSecreta);
	}

}
