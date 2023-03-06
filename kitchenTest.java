
import java.util.*;
import java.util.regex.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Test.*;
import static org.junit.Assert.*;

public class kitchenTest {
    private LinkedList<ticket> orders = null;
    private LinkedList<ticket> orders2 = null;
    private LinkedList<ticket> orders3 = null;

    @Before
    public void setupTest() {
        orders = new LinkedList<ticket>(); // > 1 order
        orders2 = new LinkedList<ticket>(); //1 order
        orders3 = new LinkedList<ticket>(); //empty

    }

    @Test
    public void printOrderTest1() { //print out orders 1

    }

    @Test
    public void printOrderTest2() { //printout orders 2
        
    }

    @Test
    public void printOrderTest3() { //printout orders 3
        
    }

    @Test
    public void printOrderTest4() { //printout variation of orders 1
        
    }

    @Test
    public void completeTicketTest1() { //test orders 1 completing all orders
        
    }

    @Test
    public void completeTicketTest2() { //test orders 1 completing some orders
        
    }

    @Test
    public void completeTicketTest3() { //test orders 2 completing all orders
        
    }

    @Test
    public void completeTicketTest4() { //test orders 2 completing no orders
        
    }

    @Test
    public void completeTicketTest5() { //failing/passing orders 3 because it empty
        
    }

    public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("kitchenTest");
	}
    
}
