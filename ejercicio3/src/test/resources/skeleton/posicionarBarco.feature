Feature: Posicionar barcos

Scenario: Ubico mi barco exitosamente
	Given posicion 1,1 esta libre y posicion 1,2 esta libre
	When jugador posiciona un "Acorazado" en la posicion 1,1 "horizontalmente"
	Then barco posicionado exitosamente
	
Scenario: No se puede ubicar un barco en una posición ya ocupada
	Given hay un barco en posicion 1,1
	When jugador posiciona un barco en la posicion 1,1
	Then posicion ocupada no se puede ubicar el barco alli
	