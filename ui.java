public class ui {
    public static void main(String[] args){
        //this is an login example, users are added as samples upon scan, type "test" as user and "fail" as password to example a mismatched case
        login();
        pos();
        

    }


    public static void pos(){
        while(true){
            mainMenu();
        }
    }

    public static void mainMenu(){

    }

    public static void login(){
        while(!userLogin.initLogin()){
            System.out.println("Please login.");
        }
    }

    public static void shutDown(){

    }
    
}
