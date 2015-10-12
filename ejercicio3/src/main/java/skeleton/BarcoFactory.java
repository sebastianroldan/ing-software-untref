package skeleton;

public class BarcoFactory {

	private Barco barco;
	
	public Barco crearBarco(String tipoBarco) throws Exception {				

		switch (tipoBarco.toLowerCase()){
			case "acorazado": barco = new Acorazado();			
			break;			
			case "lancha": barco = new Lancha();
			break;
			case "vibora": barco = new Destructor();
			break;
			default: throw new Exception("Tipo de barco desconocido");
		}
		return barco;
	}

}
