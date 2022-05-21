import java.util.Objects;
import java.util.Stack;

public class Labyrinth {

    private String[][] laby;
    public Stack stackMove = new Stack();
    public Stack stackCordinate = new Stack<>();
    public positionCoordinate currentPosition;
    public positionCoordinate entry;
    public positionCoordinate exit;

    public Labyrinth(String[][] laby){
        this.laby = laby;
    }

    public void retrivePathToExit(){

        this.entry = searchEntryorExit(this.laby,"E");
        this.exit = searchEntryorExit(this.laby, "S");


        this.currentPosition = entry;

        stackMove.push("Entrada");
        stackCordinate.push(entry.retriveCordinate());



        while (!laby[currentPosition.line][currentPosition.col].equals("S")){
            movePosition(currentPosition);
        }

        showStack();

    }


   public void movePosition(positionCoordinate currentPosition)
   {

       positionCoordinate positionDown = new positionCoordinate(currentPosition.line + 1, currentPosition.col);
       positionCoordinate positionUp = new positionCoordinate(currentPosition.line - 1, currentPosition.col);
       positionCoordinate positionLeft = new positionCoordinate(currentPosition.line, currentPosition.col - 1);
       positionCoordinate positionRight = new positionCoordinate(currentPosition.line, currentPosition.col + 1);




       if(Objects.equals(laby[positionUp.line][positionUp.col], " ") || Objects.equals(laby[positionUp.line][positionUp.col], "S")){
           if(!Objects.equals(laby[positionUp.line][positionUp.col], "S")){
               laby[positionUp.line][positionUp.col] = "=";
           }
           this.currentPosition = positionUp;
           stackMove.push("Moved Up");
           stackCordinate.push(positionUp.retriveCordinate());
           
       } else if (Objects.equals(laby[positionRight.line][positionRight.col], " ") || Objects.equals(laby[positionRight.line][positionRight.col], "S")) {
           if(!Objects.equals(laby[positionRight.line][positionRight.col], "S")){
               laby[positionRight.line][positionRight.col] = "=";
           }
           this.currentPosition = positionRight;
           stackMove.push("Moved Right");
           stackCordinate.push(positionRight.retriveCordinate());
           
       } else if (Objects.equals(laby[positionDown.line][positionDown.col], " ") || Objects.equals(laby[positionDown.line][positionDown.col], "S")) {
           if (!Objects.equals(laby[positionDown.line][positionDown.col], "S")){
               laby[positionDown.line][positionDown.col] = "=";
           }
           this.currentPosition = positionDown;
           stackMove.push("Moved Down");
           stackCordinate.push(positionDown.retriveCordinate());

       } else if (Objects.equals(laby[positionLeft.line][positionLeft.col], " ") || Objects.equals(laby[positionLeft.line][positionLeft.col], "S")) {
           if (!Objects.equals(laby[positionLeft.line][positionLeft.col], "S")){
               laby[positionLeft.line][positionLeft.col] = "=";
           }
           this.currentPosition = positionLeft;
           stackMove.push("Moved left");
           stackCordinate.push(positionLeft.retriveCordinate());

       } else{
           String lastPosition = (String) stackCordinate.peek();
           String[] cord = lastPosition.split(",");

           int line = Integer.parseInt(cord[0]);
           int col = Integer.parseInt(cord[1]);

           this.currentPosition = new positionCoordinate(line,col);
           stackCordinate.pop();
           stackMove.pop();

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

    public void showStack(){
        System.out.println("Cordenadas até a saida:");
        for (Object item: stackCordinate) {
            System.out.println(item.toString());
        }
    }

}
