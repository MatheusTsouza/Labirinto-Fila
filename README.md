# Labirinto-Pilha
Este projeto tem como objetivo descobrir a saída de um labirinto utilizando pilha. Nele é lido um arquivo txt que contém o labirinto (Files/labyrinth1.txt), o programa começa pela coordenada inicial(E) e tenta achar um caminho até a coordenada final(S).

Labirinto inicial:
![image](https://user-images.githubusercontent.com/39911368/164867910-93c80a65-be49-477b-b09c-a99143afdaab.png)


Será considerado caminho livre se alguma posição adjacente da posição atual seja igual a um espaço vazio.


![image](https://user-images.githubusercontent.com/39911368/164868196-f56bf196-7a02-4039-9b52-714f4e26f14b.png)


Quando a posição é visitada é marcada com um "=", isso ocorre até chegar na saída.


![image](https://user-images.githubusercontent.com/39911368/164868564-bb8f2aee-3374-47eb-bcd9-12659d937fff.png)


caso a posição atual não tenha caminhos adjacentes validos, ele retorna para última posição que passou e desempilha o caminho encurralado.

![image](https://user-images.githubusercontent.com/39911368/164868923-4a96e847-544e-4b7d-b47f-3a3029222114.png)
