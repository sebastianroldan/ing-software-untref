package skeleton;

public class BarcoFactory {

	private Barco barco;
	
	public Barco crearBarco(String tipoBarco) throws Exception {				
		
		String tipo = tipoBarco.toLowerCase();
		switch (tipo){
			case "acorazado": barco = new Acorazado();			
			break;			
			case "lancha": barco = new Lancha();
			break;
			case "destructor": barco = new Destructor();
			break;
			default: throw new Exception("Tipo de barco desconocido");
		}
		return barco;
	}

}
