Feature: Disparar 

Scenario: Disparo y toco agua
	Given no hay barcos en posicion 4,8
	When disparo a la posicion 4,8
	Then el disparo dio en el agua

Scenario: Disparo y toco un barco pero no lo hundo
	Given hay un barco en posicion 5,5
	When disparo a la posicion 5,5
	Then el disparo dio en el blanco