package Utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile{


    public String[][] RetrivebyArray(String directory) throws IOException {

        int contCol = 0;
        String filePath = new File("").getAbsolutePath();
        String Path = filePath +"/labyrinths"+ "/"+ directory;
        FileReader dir = new FileReader(Path);
        Path path = Paths.get(Path);

        BufferedReader readFile = new BufferedReader(dir);
        String line = readFile.readLine();

        String[][] response = new String[(int)Files.lines(path).count()][line.length()];

        while (line != null)
        {
            for(int i = 0; i < line.length(); i++)
            {
                response[contCol][i] = String.valueOf(line.charAt(i));
            }
            contCol += 1;
            line = readFile.readLine();
        }
        return response;
    }

}






