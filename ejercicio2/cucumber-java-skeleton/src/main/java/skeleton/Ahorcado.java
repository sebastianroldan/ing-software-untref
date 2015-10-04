package skeleton;

public class Ahorcado {

	private int vidas = 7;
	private String palabraSecreta = "auto";
	private char[] estado = {'*','*','*','*',};
	
	public void setVidasRestantes(int vidasRestantes) {
		this.vidas = vidasRestantes;
	}
	
	public void setPalabraSecreta(String palabraSecreta){
		palabraSecreta.toLowerCase();
		this.palabraSecreta = palabraSecreta;
	}

	public void arriesgo(Character letra) {
		Character.toLowerCase(letra);
		if (acerto(letra)){
			modificarEstado(letra);			
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

	
	
	private void modificarEstado(Character letra) {		
		for (int i=0; i < this.palabraSecreta.length(); i++){
			if (letra.equals(palabraSecreta.charAt(i))){
				estado[i] = letra;
			}
		}
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
	
	
}
