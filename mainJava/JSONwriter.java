import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONwriter {
    
    private static void writeUsersJson() throws IOException{                
        LinkedList<loginJson> log = new LinkedList<loginJson>();
        loginJson login = new loginJson();
        loginJson login1 = new loginJson();
        login.setUser("numpy");
        login1.setUser("quaso");
        login.setPass("password");
        login1.setPass("croissant");
        log.add(login);
        log.add(login1);
        ObjectMapper tableMapper = new ObjectMapper();
        tableMapper.writeValue(new File("saves/user.json"), log);
    }

    private static void writeEmployeesJson() throws IOException{
        LinkedList<employeeJson> log = new LinkedList<employeeJson>();
        employeeJson emp1 = new employeeJson();
        employeeJson emp2 = new employeeJson();
        employeeJson emp3 = new employeeJson();
        emp1.setID(0);
        emp1.setPin("1234");
        emp1.setFirstName("John");
        emp1.setLastName("Doe");
        emp1.setPosition("Manager");
        emp2.setID(1);
        emp2.setPin("5678");
        emp2.setFirstName("Mary");
        emp2.setLastName("Lamb");
        emp2.setPosition("Server");
        emp3.setID(2);
        emp3.setPin("9012");
        emp3.setFirstName("Carrie");
        emp3.setLastName("Underwood");
        emp3.setPosition("Chef");
        log.add(emp1);
        log.add(emp2);
        log.add(emp3);
        ObjectMapper tableMapper = new ObjectMapper();
        tableMapper.writeValue(new File("saves/employee.json"), log);
    }

    public static void main(String[]args) throws IOException{
       writeEmployeesJson();
  }

}
