import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class parse {
    private static File file;
    public static void loginParseIn(){
        file = new File("./saves/login.txt");
    }
    

    public static void main(String[]args) throws FileNotFoundException{
        loginParseIn();
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
        
    }

}
