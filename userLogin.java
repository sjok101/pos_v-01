import java.util.Scanner;
public class userLogin{
    private static String user;
    private static String pass;
        public static boolean initLogin(){
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter you username.. then press enter.");
            user = scan.next();
            System.out.println("Now enter you password.. then press enter.");
            pass = scan.next();

            //test trigger to test fail
            if(user.equals("test")&&pass.equals("fail"))
            return false;

            return authenticateAccount(user, pass);

        }

        private static boolean authenticateAccount(String user, String pass){
            userAccounts authenticating = new userAccounts(user, pass);        
            authenticating.initializeSample(authenticating);                  //this will initialize a sample user that matches your entry
            if(authenticating.checkUsers(authenticating)==true){
                return true;
            }
            else{
                return false;
            }
            
        }
}
