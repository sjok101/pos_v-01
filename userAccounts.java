import java.util.LinkedList;
public class userAccounts {
    private String username;
    private String password;
    
    public static LinkedList<userAccounts> sampleList= new LinkedList<userAccounts>();
    //sample, to be replaced with json
    public userAccounts(String user, String pass){
        this.username = user;
        this.password = pass;
    }

    public static void initializeSample(userAccounts sampleAccount){
        //to be replaced, for example purposes in creating a sample account
        sampleList.add(sampleAccount);
    }
    
    
    public static boolean checkUsers(userAccounts checkAccount){
        if(sampleList.contains(checkAccount)){
            System.out.println("Login Successful");
            return true;
        }
        else
            System.out.println("Login Failed");
            return false;
    }

}
