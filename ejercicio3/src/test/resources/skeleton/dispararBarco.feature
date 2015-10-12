Feature: Disparar 

Scenario: Disparo y toco agua
	Given no hay barcos en posicion 4,8
	When disparo a la posicion 4,8
	Then el disparo dio en el agua
