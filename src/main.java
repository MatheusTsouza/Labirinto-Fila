import Utils.ReadFile;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {

        ReadFile ReadFile = new ReadFile();
        String[][] labyrinthArray = ReadFile.RetrivebyArray("labyrinth1.txt");

        Labyrinth labyrinth = new Labyrinth(labyrinthArray);

        labyrinth.RunMaze();




    }

}
