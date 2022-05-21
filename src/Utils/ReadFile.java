package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile{


    public String[][] RetrivebyArray(String directory) {
        String[][] response = new String[50][50];

        try {

            FileReader dir = new FileReader(directory);
            BufferedReader readFile = new BufferedReader(dir);

            String line = readFile.readLine();
            int cont = 0;
            while (line != null){

                for(int i = 0; i < line.length(); i++){

                    response[cont][i] = String.valueOf(line.charAt(i));

                }
                cont += 1;
                line = readFile.readLine();
                    
                }

            return response;


            }
        catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        catch (IOException e){
            e.getMessage();
        }

        return response;
    }

}






