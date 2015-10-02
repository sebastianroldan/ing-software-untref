package skeleton;

public class Jugador {
	
	private int numero;
	private Movimiento movimiento;	

	public void setMovimiento(Movimiento movimiento) {
		 this.movimiento = movimiento;		
	}
	
	public Movimiento getMovimiento(){
		return movimiento;		
	}
	
	public void setNumero(int numero) {
		 this.numero = numero;		
	}
	
	public int getNumero(){
		return numero;		
	}

}
