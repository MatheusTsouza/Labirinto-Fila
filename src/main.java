import Utils.ReadFile;

import java.util.Stack;

public class main {

    public static void main(String[] args) {

        ReadFile ReadFile = new ReadFile();
        String[][] labyrinthArray = ReadFile.RetrivebyArray("C:\\Users\\Matheus\\IdeaProjects\\LabirintoPilha\\Files\\labyrinth1.txt");

        Labyrinth labyrinth = new Labyrinth(labyrinthArray);

        labyrinth.retrivePathToExit();









    }

}
