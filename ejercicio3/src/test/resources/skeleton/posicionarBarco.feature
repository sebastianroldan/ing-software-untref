Feature: Posicionar barcos

Scenario: Ubico mi barco exitosamente
	Given posicion 1,1 esta libre y posicion 1,2 esta libre
	When jugador posiciona un "Acorazado" en la posicion 1,1 "horizontalmente"
	Then barco posicionado exitosamente
