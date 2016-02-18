/**
 * Created by User on 17/02/16.
 */
import java.io.*;

public class parseRitual {

    public static void main(String [] args) {
        String[][] grid = new String[4][4];
        for(int i = 0; i < grid.length; i ++){
            for( int a = 0; a < grid.length; a++ ){
                grid[i][a] = "";
            }
            System.out.println();
        }
        try {

            String content = "00 YELLOW 10 BLUE 11 BLUE 20 YELLOW \nfood+25 happiness-40";

            File file = new File("tester.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();



        } catch (IOException e) {
            e.printStackTrace();
        }

        //**************************************
        String fileName = "tester.txt";
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            boolean firstLine = true;
            String[] parse = null;
            String[] effect = null;
            while((line = bufferedReader.readLine()) != null) {
                if(firstLine){
                    parse = line.split(" ");
                    int i =0;
                    int a =0;
                    int b =0;
                    while(i< parse.length){
                        if(i%2 ==0){
                             a = (int)parse[i].charAt(0)-48;
                             b = (int)parse[i].charAt(1)-48;
                        }
                        else{
                            grid[a][b] = parse[i];
                        }
                        i++;
                    }
                    firstLine = false;
                }
                else{
                    effect = line.split(" ");

                }
            }
            // Always close files.
            bufferedReader.close();
            for(int i = 0; i < grid.length; i ++){
                for( int a = 0; a < grid.length; a++ ){
                    System.out.print("["+grid[i][a]+ "]");
                }
                System.out.println(" ");
            }
            int k =0;
            while(k < effect.length){
                System.out.println(effect[k]);
                k++;
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");

        }
    }
}
