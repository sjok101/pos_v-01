import java.util.*;
import java.util.regex.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Test.*;
import static org.junit.Assert.*;

public class tableTest {

    private int tableNumber;
    private int tableNumber2;
    private int tableNumber3;
    private int numberOfSeats;
    private int numberOfSeats2;
    private int numberOfSeats3;
    private HashMap<Integer,ticket> table = null;
    private HashMap<Integer,ticket> table2 = null;
    private HashMap<Integer,ticket> table3 = null;

    @Before
    public void setupTest() { //setup all variations of tables to test each one
        table = new HashMap<Integer,ticket>();
        table2 = new HashMap<Integer,ticket>();
        table3 = new HashMap<Integer,ticket>();
    }

    @Test
    public void makeTableTest1() { //test for making table 1 which is normal table

    }

    @Test
    public void makeTableTest2() { //test for making table 2 which is 1 seat table

    }

    @Test
    public void makeTableTest3() { //test for making table 3 which is no seat table

    }

    @Test
    public void adjustTableTest1() { //edit table 1 test

    }

    @Test
    public void adjustTableTest2() { // edit table 1 test

    }

    @Test
    public void adjustTableTest3() { // edit table 2 test

    }

    @Test
    public void adjustTableTest4() { // edit table 2 test

    }

    @Test
    public void adjustTableTest5() { // edit table 3 test

    }
    
    @Test
    public void makeTicketTest1() { //make ticket for table 1

    }

    @Test
    public void makeTicketTest2() { //make ticket for table 1

    }

    @Test
    public void makeTicketTest3() { //make ticket for table 2

    }

    @Test
    public void makeTicketTest4() { //make ticket for table 2

    }

    @Test
    public void makeTicketTest5() { //fail to make ticket for table 3

    }

    @Test
    public void removeCustomerTest1() { //pass to remove customer for table 1

    }

    @Test
    public void removeCustomerTest2() { //failto remove customer for table 1

    }

    @Test
    public void removeCustomerTest3() { //pass to remove customer for table 2

    }

    @Test
    public void removeCustomerTest4() { //fail to remove customer for table 2

    }

    @Test
    public void removeCustomerTest5() { //fail to remove customer for table 3

    }

    @Test
    public void addCustomerTest1() { //pass to add customer for table 1

    }

    @Test
    public void addCustomerTest2() { //pass to add customer for table 1

    }

    @Test
    public void addCustomerTest3() { //pass to add customer for table 2

    }

    @Test
    public void addCustomerTest4() { //failto remove customer for table 1 and 2

    }

    @Test
    public void addCustomerTest5() { //pass and fail to add customer for table 3

    }

    @Test
    public void getTicketTest1() {   //get ticket table 1 and then fail to get ticket out of range 
    }

    @Test
    public void getTicketTest2() {   //get ticket table 2 and then fail to get ticket out of range  
    }

    @Test
    public void getTicketTest3() {    //fail to get ticket from table 3 
    }
    
    public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("tableTest");
	}

}
