import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;


public class Labyrinth {
    private String[][] laby, InitialLaby;
    private positionCoordinate currentPosition, entry, exit;
    private boolean finish = false;
    private int countCommand = 0;
    private Queue<String> Queue = new LinkedList<String>();
    public Scanner inputCommands = new Scanner(System.in);

    public Labyrinth(String[][] laby){
        this.laby = laby;
        this.InitialLaby = this.laby;
    }

    public void RunMaze(){
        this.entry = searchEntryorExit(this.laby, "E");
        this.exit = searchEntryorExit(this.laby, "S");
        this.currentPosition = entry;


        ShowLab();
        while (finish == false)
        {
            String Move = inputCommands.nextLine();
            movePosition(Move);

        }
        if(Queue.isEmpty() == true) {
            if(laby[currentPosition.line][currentPosition.col] == laby[exit.line][exit.col])
            {
                System.out.println("Você conseguiu!!!");
            }
        }
    }

    private void movePosition(String Move) {


        positionCoordinate positionDown = new positionCoordinate(currentPosition.line + 1, currentPosition.col);
        positionCoordinate positionUp = new positionCoordinate(currentPosition.line - 1, currentPosition.col);
        positionCoordinate positionLeft = new positionCoordinate(currentPosition.line, currentPosition.col - 1);
        positionCoordinate positionRight = new positionCoordinate(currentPosition.line, currentPosition.col + 1);

        switch (Move) {
            case "Direita":
            case "d":
                Queue.add(positionRight.retriveCordinate() + ";Direita");
                this.currentPosition = positionRight;
                ShowLab();
                break;

            case "Esquerda":
            case "e":
                Queue.add(positionLeft.retriveCordinate() + ";Esquerda");
                this.currentPosition = positionLeft;
                ShowLab();
                break;

            case "Cima":
            case "c":
                Queue.add(positionUp.retriveCordinate() + ";Cima");
                this.currentPosition = positionUp;
                ShowLab();
                break;

            case "Baixo":
            case "b":
                Queue.add(positionDown.retriveCordinate() + ";Baixo");
                this.currentPosition = positionDown;
                ShowLab();
                break;

            case "Reniciar":
            case "r":
                System.out.println("Reiniciando Labirinto");
                CleanQueue();
                break;
            case "Começar":
            case "start":
                while (Queue.isEmpty() == false && finish == false){
                    String[] Actualposition = Queue.peek().split(";");
                    int line = Integer.parseInt(Actualposition[0]);
                    int col = Integer.parseInt(Actualposition[1]);
                    String move = Actualposition[2];
                    WalkInMaze(line,col, move);
                    Queue.remove();
                }

                break;
        }

    }

    private void CleanQueue(){
        while (Queue.isEmpty() == false){
            Queue.remove();
        }
    }

    private void WalkInMaze(int line, int col, String move){
        this.countCommand += 1;
        if(!laby[line][col].equals(laby[exit.line][exit.col]) || !laby[line][col].equals(laby[entry.line][entry.col]) ) {

            if (laby[line][col] == "#")
            {
                CleanQueue();
                this.laby = this.InitialLaby;
                this.countCommand = 0;
                finish = true;
                System.out.println("Que pena, o movimento que você escolheu é invalido!! \n Mas não fique triste, você acaba de ganhar um 'Jogo da Vida'");
            }
            else if (move.equals("Cima") || move.equals("Baixo"))
            {
                laby[line][col] = "|";
            }
            else if (move.equals("Direita") || move.equals("Esquerda"))
            {
                laby[line][col] = "-";
            }
            System.out.println("Comando "+this.countCommand +": " + move);
            PrintArray();
        }
    }

    private void PrintArray(){

        for (int l = 0; l < laby.length; l++)  {
            for (int c = 0; c < laby[0].length; c++)     {
                System.out.print(laby[l][c] + " "); //imprime caracter a caracter
            }
            System.out.println(" "); //muda de linha
        }
    }

    private positionCoordinate searchEntryorExit(String[][] laby, String item){

        boolean found = false;

        for(int i = 0; i < laby.length; i++)
        {
            for(int j = 0; j < laby.length; j++)
            {


                if(Objects.equals(laby[i][j], item)){
                    positionCoordinate response = new positionCoordinate(i,j);
                    found = true;

                    return response;
                }
            }
        }
        if(found == false){
            throw new RuntimeException("Não foi encontrada nenhuma entrada ou saida");
        }
        return new positionCoordinate(-1,-1);
    }

    private void ShowLab()
    {
        PrintArray();
        System.out.println("Programe seus passos para chegar até o 'E'");
        System.out.println("Comandos enfilerados: " + Queue.size());
        System.out.println("Comandos disponiveis: \n" +
                "- Direita / d \n" +
                "- Esquerda / e \n" +
                "- Cima / c \n" +
                "- Baixo / b \n" +
                "- Começar / start \n" +
                "- Reiniciar / r \n"
        );

    }

}
