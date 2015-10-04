Feature: Ahorcado

Scenario: Arriesgo "a", tengo 7 vidas y estado es "****"
  Given la palabra secreta es "auto" And me quedan 7 vidas And estado es "****"
  When arriesgo "a"
  Then estado es "a***"  And me quedan 7 vidas
  
Scenario: Arriesgo "y" , tengo 7 vidas y estado es "****"
  Given la palabra secreta es "auto" And me quedan 7 vidas And estado es "****"
  When arriesgo "y"
  Then estado es "****"  And me quedan 6 vidas
  
Scenario: Arriesgo "A" , tengo 4 vidas y estado es "****"
  Given la palabra secreta es "auto" And me quedan 4 vidas And estado es "****"
  When arriesgo "A"
  Then estado es "a***"  And me quedan 4 vidas  
  
Scenario: Arriesgo "H" , tengo 1 vidas y estado es "****"
  Given la palabra secreta es "auto" And me quedan 1 vidas And estado es "****"
  When arriesgo "H"
  Then Ahorcado And me quedan 0 vidas