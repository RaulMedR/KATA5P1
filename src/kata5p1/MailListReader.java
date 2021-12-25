package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {
    public static List<String> read(String nameFile) throws FileNotFoundException{
        List<String> list = new ArrayList<>();
        
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File(nameFile)));
            while(true){
                String line = reader.readLine();
                if(line == null) break;
                if(MailListReader.isMail(line)) list.add(line);
            }
        }
        catch(FileNotFoundException exception){
            System.out.println("ERROR MailListReader::read (FileNotFound)" + exception.getMessage());
        }
        catch(IOException exception){
            System.out.println("ERROR MailListReader::read (IO)" + exception.getMessage());
        }
        return list;
    }
    
    public static boolean isMail(String line){
        return line.matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
    }

}
