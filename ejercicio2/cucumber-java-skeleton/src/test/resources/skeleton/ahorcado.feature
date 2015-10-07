Feature: Ahorcado

Scenario: Arriesgo y acierto
  Given la palabra secreta es "auto" And me quedan 7 vidas
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
  
Scenario: Tengo una vida y no acierto
  Given la palabra secreta es "auto" And me quedan 1 vidas
  When arriesgo "H"
  Then Ahorcado And me quedan 0 vidas
  
Scenario: Acierto y se modifica el estado
  Given la palabra secreta es "auto" And estado es "**t*"
  When arriesgo "a"
  Then estado es "a*t*"

Scenario: Arriesgo "a" y gano el juego 
  Given la palabra secreta es "auto" And estado es "*uto"
  When arriesgo "a"
  Then estado es "auto"  And Ganaste

Scenario: Arriesgo una letra que se repite 
  Given la palabra oculta es "cama"
  When arriesgo "a"
  Then estado es "*a*a"