import java.util.Scanner;
public class ui {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Main menu");
            System.out.println("Choose number option");
            int menuChoice = scan.nextInt();
            switch(menuChoice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("Exiting software..");
                    System.exit(0);
            }
        }
    }
}
