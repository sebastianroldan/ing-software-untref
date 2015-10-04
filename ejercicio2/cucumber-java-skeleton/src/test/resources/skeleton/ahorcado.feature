Feature: Ahorcado

Scenario: Arriesgo "a" y tengo 7 vidas
  Given la palabra secreta es "auto" And me quedan 7 vidas
  When arriesgo "a"
  Then estado es "a***"  And me quedan 7 vidas