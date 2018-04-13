/**
 * File Manager.
 * This is an utility class to manage files.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class fileManager {
    
    /**
     * Read text file.
     * Class responsible for reading text files containing informations to be
     * loaded. It loads strings separated by commas (',') and stores these on a
     * List. Each line read is then added on an List of List. 
     * @param filePath Path of the file to be read.
     * @return The list of list containing the text file read.
     */
    public static ArrayList<ArrayList<String>> readTextFile(String filePath){
        ArrayList<ArrayList<String>> data = new ArrayList();
        String line;
        BufferedReader br = null;
        try{
            //br = new BufferedReader(new FileReader(filePath)); 
            br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(filePath))); 
            while((line = br.readLine()) != null){
                ArrayList<String> temp = new ArrayList<>();
                Scanner scanner = new Scanner(line);
                scanner.useDelimiter(Pattern.compile(";"));
                while(scanner.hasNext()){
                    temp.add(scanner.next());
                }
                data.add(temp);
            }
        }catch (FileNotFoundException e){
        }catch (IOException e){
        }finally {
            try {
                if (br != null) {
                    br.close();
                }
            }catch (IOException e) {
            }
        }
        return data;
    }
}
