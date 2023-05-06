import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONwriter {
    
    public static LinkedList<employeeJson> readEmployee() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        List<employeeJson> listLog = objectMapper.readValue(new File("C:\\Users\\Joon\\Desktop\\pos_v-01\\test\\employeeTest.json"), new TypeReference<List<employeeJson>>(){});
        LinkedList<employeeJson> logJ = new LinkedList<employeeJson>(listLog);
        return logJ;
    }

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

    private static void writeEmployeesJsonTest() throws IOException{
        LinkedList<employeeJson> log = new LinkedList<employeeJson>();
        employeeJson emp1 = new employeeJson();
        employeeJson emp2 = new employeeJson();
        employeeJson emp3 = new employeeJson();
        emp1.setID(0);
        emp1.setPin("1234");
        emp1.setFirstName("John");
        emp1.setLastName("Doe");
        emp1.setPosition("Manager");
        emp1.setHours(10.5);
        emp1.setClocked(false);
        emp1.setTimeIn("9:45 AM");
        emp1.setTimeOut("4:15 PM");
        emp2.setID(1);
        emp2.setPin("5678");
        emp2.setFirstName("Mary");
        emp2.setLastName("Lamb");
        emp2.setPosition("Server");
        emp2.setHours(0);
        emp2.setClocked(true);
        emp2.setTimeIn("4:30 PM");
        emp3.setID(2);
        emp3.setPin("9012");
        emp3.setFirstName("Carrie");
        emp3.setLastName("Underwood");
        emp3.setPosition("Chef");
        emp3.setHours(40.5);
        emp3.setClocked(false);
        log.add(emp1);
        log.add(emp2);
        log.add(emp3);
        ObjectMapper tableMapper = new ObjectMapper();
        tableMapper.writeValue(new File("saves/employeeTest.json"), log);
    }

    private static void writeTwoMonthOfTickets() throws IOException{
        LinkedList<jsonTicket> log = new LinkedList<jsonTicket>();
        jsonTicket ticket;
        for (int i = 0; i<4; i++){
            ticket = new jsonTicket();
            ticket.setTicketID(String.valueOf(i));
            log.add(ticket);    
        }
        ObjectMapper tableMapper = new ObjectMapper();
        tableMapper.writeValue(new File("saves/ticketTest.json"), log);
    }

    public static void main(String[]args) throws IOException{
       writeTwoMonthOfTickets();
     }

}
