
import java.io.*;
import java.util.*;
import java.util.regex.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TicketTest {
    
    private Ticket tik1 = null;
    private Ticket tik2 = null;
    private Ticket tik3 = null;



    @Before
    public void setupTest(){
        tik1 = new Ticket(1);
        tik2 = new Ticket(10);
        tik3 = new Ticket(25);
    }

    //normal value
    @Test
    public void setTableNum1(){
        Ticket t = new Ticket(0);
        t.setTableNum(1);
        assertEquals(tik1.getTableNum(), t.getTableNum());

    }

    //larger value
    @Test
    public void setTableNum2(){
        Ticket t = new Ticket(0);
        t.setTableNum(10);
        assertEquals(tik2.getTableNum(), t.getTableNum());

    }

    //negative value
    @Test (expected = IndexOutOfBoundsException.class)
    public void setTableNum3(){
        Ticket t = new Ticket(0);
        t.setTableNum(-10);

    }

    //table number 0
    @Test
    public void setTableNum4(){
        Ticket t = new Ticket(0);
        t.setTableNum(1);
        assertEquals(tik1.getTableNum(), t.getTableNum());

    }

    @Test
    public void setTableNum5(){
        Ticket t = new Ticket(0);
        t.setTableNum(1);
        assertEquals(tik1.getTableNum(), t.getTableNum());

    }

}
