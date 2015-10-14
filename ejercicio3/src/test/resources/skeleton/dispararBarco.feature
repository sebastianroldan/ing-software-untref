Feature: Disparar 

Scenario: Disparo y toco agua
	Given no hay barcos en posicion 4,8
	When disparo a la posicion 4,8
	Then el disparo dio en el agua

Scenario: Disparo y toco un barco pero no lo hundo
	Given hay un barco en posicion 5,5
	When disparo a la posicion 5,5
	Then el disparo dio en el blanco
	
Scenario: Disparo toco un barco y lo hundo
	Given disparo a la posicion 1,8 And el disparo dio en el blanco
	When todas las posiciones del barco han sido destruidas
	Then el barco ha sido hundido

Scenario: No se puede disparar fuera del tablero
	Given tablero es de 10 x 10
	When disparo hacia la posicion 11,1
	Then no se puede disparar a esa posicion
	