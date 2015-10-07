Feature: Ahorcado

Scenario: Arriesgo y acierto
  Given la palabra secreta es "auto" And me quedan 7 vidas And estado es "****"
  When arriesgo "a"
  Then estado es "a***"  And me quedan 7 vidas
  
Scenario: No acierto entonces pierdo una vida
  Given la palabra secreta es "auto" And me quedan 7 vidas
  When arriesgo "y"
  Then estado es "****"  And me quedan 6 vidas
  
Scenario: Arriesgo en mayuscula y acierto
  Given la palabra secreta es "auto" And me quedan 4 vidas And estado es "****"
  When arriesgo "A"
  Then estado es "a***"  And me quedan 4 vidas  
  
Scenario: Arriesgo "H" , tengo 1 vidas y estado es "****"
  Given la palabra secreta es "auto" And me quedan 1 vidas And estado es "****"
  When arriesgo "H"
  Then Ahorcado And me quedan 0 vidas
  
Scenario: Arriesgo "a", tengo 7 vidas y estado es "**t*"
  Given la palabra secreta es "auto" And me quedan 7 vidas And estado es "**t*"
  When arriesgo "a"
  Then estado es "a*t*"  And me quedan 7 vidas

Scenario: Arriesgo "a" y gano el juego 
  Given la palabra secreta es "auto" And estado es "*uto"
  When arriesgo "a"
  Then estado es "auto"  And Ganaste