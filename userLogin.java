import java.util.Scanner;
public class userLogin {
    private static String user;
    private static String pass;
        public static boolean initLogin(){
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter you username.. then press enter.");
            user = scan.next();
            System.out.println("Now enter you password.. then press enter.");
            pass = scan.next();
            return authenticateAccount(user, pass);

        }

        private static boolean authenticateAccount(String user, String pass){
            if (user.equals())
        }
}
