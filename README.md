# Labirinto-Fila

Este projeto tem como objetivo descobrir a saída de um labirinto utilizando Fila. Nele é lido um arquivo txt que contém o labirinto (labyrinths/labyrinth1.txt), para descobiri a saida o programa começa pela entrad que é marcada pela letra "E", após isso ele permite o usuario criar uma rota até a saida com os comandos: 
- Direita / d 
- Esquerda / e 
- Cima / c 
- Baixo / b 
- Começar / start 
- Reiniciar / r .

Labirinto inicial e comandos:

![image](https://user-images.githubusercontent.com/39911368/170601299-3febab7e-4ff4-4df2-8bcf-79627d29d981.png)


O labirinto adiciona o comando digitado em uma fila e pede pelo proximo comando: 

![image](https://user-images.githubusercontent.com/39911368/170601568-2ba4e55d-f99a-4199-81e9-397d4bc9c040.png)

Isso ocorre até que o usuario digite o comando "Começar" ou "start":

![image](https://user-images.githubusercontent.com/39911368/170601781-65bf8442-3421-4297-b19c-c21caaa0f0ee.png)

Quando é executado esses comandos, ele mostra o caminho descrito pelo jogador e o tempo que demorou: 

![image](https://user-images.githubusercontent.com/39911368/170601842-9b300405-684a-46e0-acc6-be39f3b8cd93.png)

![image](https://user-images.githubusercontent.com/39911368/170601855-2fbc6936-8aeb-4a3f-8b4d-c6df95d4529b.png)

![image](https://user-images.githubusercontent.com/39911368/170601874-08ee3d64-b855-4ca7-a3ef-e7350ee9217a.png)

![image](https://user-images.githubusercontent.com/39911368/170601897-7e7fd8d9-8314-411d-9f20-c8ed17ace48a.png)


Quando o usuario digita um comando invalido é mostrado a seguinte mensagem:

![image](https://user-images.githubusercontent.com/39911368/170602044-08a25596-90fa-424f-98da-7d63251e4550.png)

Quando o usuario digita um caminho que é aceito, mas que ainda não chegou até a saida ele mostra: 

![image](https://user-images.githubusercontent.com/39911368/170602182-3d82dec9-4f69-4094-8113-3fbd254622db.png)
