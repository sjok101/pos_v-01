
import java.io.IOException;
import java.util.*;
import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;
public class employeeJsonTest {
    
    LinkedList<employeeJson> logJ;
    
    
    @Before
    public void setupTest() throws IOException{
        logJ = JSONwriter.readEmployee();

    }

    @Test
    public void getFirstNameTest(){
        String testName = "John";
        assertEquals(logJ.get(0).getFirstName(), testName);
    }

    @Test
    public void setFirstNameTest(){
        String testName = "Mary";
        logJ.get(0).setFirstName(testName);
        assertEquals(logJ.get(0).getFirstName(), testName);
    }

    
    @Test
    public void getLastNameTest(){
        String testName = "Doe";
        assertEquals(logJ.get(0).getLastName(), testName);
    }

    @Test
    public void setLastNameTest(){
        String testName = "Blige";
        logJ.get(0).setLastName(testName);
        assertEquals(logJ.get(0).getLastName(), testName);
    }
    
    
    @Test
    public void getIdTest(){
        int testVal = 0;
        assertEquals(logJ.get(0).getID(), testVal);
    }

    @Test
    public void setIdTest(){
        int testVal = 10;
        logJ.get(0).setID(testVal);
        assertEquals(logJ.get(0).getID(), testVal);
    }

    
    @Test
    public void getPinTest(){
        String testVal = "1234";
        assertEquals(logJ.get(0).getPin(), testVal);
    }

    @Test
    public void setPinTest(){
        String testVal = "4444";
        logJ.get(0).setPin(testVal);
        assertEquals(logJ.get(0).getPin(), testVal);
    }

    
    @Test
    public void getPositionTest(){
        String testPosition = "Manager";
        assertEquals(logJ.get(0).getPosition(), testPosition);
    }

    @Test
    public void setPositionTest(){
        String testPosition = "Dishwasher";
        logJ.get(0).setPosition(testPosition);
        assertEquals(logJ.get(0).getPosition(), testPosition);
    }

    
    @Test
    public void getHoursTest(){
        double testVal = 10.5;
        assertEquals(logJ.get(0).getHours(), testVal, 0.01);
        
    }

    @Test
    public void setHoursTest(){
        double testVal = 20.5;
        logJ.get(0).setHours(testVal);
        assertEquals(logJ.get(0).getHours(), testVal, 0.01);
    }

    
    @Test
    public void getClockedTest(){
        boolean testFlag = false;
        assertEquals(logJ.get(0).getClocked(), testFlag);
    }

    @Test
    public void setClockedTest(){
        boolean testFlag = true;
        logJ.get(0).setClocked(testFlag);
        assertEquals(logJ.get(0).getClocked(), testFlag);
    }
    
    @Test
    public void getTimeInTest(){
        String testTime = "9:45 AM";
        assertEquals(logJ.get(0).getTimeIn(), testTime);
    }
    
    @Test
    public void setTimeInTest(){
        String testTime = "8:45 AM";
        logJ.get(0).setTimeIn(testTime);
        assertEquals(logJ.get(0).getTimeIn(), testTime);

    }
    
    @Test
    public void getTimeOutTest(){
        String testTime = "4:15 PM";
        assertEquals(logJ.get(0).getTimeOut(), testTime);
    }

    @Test
    public void setTimeOutTest(){
        String testTime = "5:15 PM";
        logJ.get(0).setTimeOut(testTime);
        assertEquals(logJ.get(0).getTimeOut(), testTime);
    }

}
