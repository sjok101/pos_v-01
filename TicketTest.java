
import java.io.*;
import java.util.*;
import java.util.regex.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TicketTest {
    
    private Ticket tik1 = null;
    private Ticket tik2 = null;

    @Test 
    public void ticketConstuctorTest1(){

    }



    @Before
    public void setupTest(){
        tik1 = new Ticket(1);
        tik2 = new Ticket(10);
    }

    //normal value
    @Test
    public void setTableNum1(){
        Ticket t = new Ticket(3);
        t.setTableNum(1);
        assertEquals(tik1.getTableNum(), t.getTableNum());

    }

    //larger value
    @Test
    public void setTableNum2(){
        Ticket t = new Ticket(3);
        t.setTableNum(10);
        assertEquals(tik2.getTableNum(), t.getTableNum());

    }

    //negative value
    @Test (expected = IndexOutOfBoundsException.class)
    public void setTableNum3(){
        Ticket t = new Ticket(1);
        t.setTableNum(-10);

    }

    //table number 0
    @Test (expected = IndexOutOfBoundsException.class)
    public void setTableNum4(){
        Ticket t = new Ticket(0);

    }

    

}
