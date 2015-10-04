Feature: Ahorcado

Scenario: Arriesgo "a" y tengo 7 vidas
  Given la palabra secreta es "auto" And me quedan 7 vidas
  When arriesgo "a"
  Then estado es "a***"  And me quedan 7 vidas
  
Scenario: Arriesgo "y" y tengo 7 vidas
  Given la palabra secreta es "auto" And me quedan 7 vidas
  When arriesgo "y"
  Then estado es "****"  And me quedan 6 vidas
  
Scenario: Arriesgo "A" y tengo 4 vidas
  Given la palabra secreta es "auto" And me quedan 4 vidas
  When arriesgo "A"
  Then estado es "a***"  And me quedan 4 vidas  
  
Scenario: Arriesgo "H" y tengo 1 vidas
  Given la palabra secreta es "auto" And me quedan 1 vidas
  When arriesgo "H"
  Then Ahorcado And me quedan 0 vidas