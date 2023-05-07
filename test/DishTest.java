
import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;
public class DishTest {
    private Dish d = null;


    @Before
    public void setupTest() { //setup all variations of tables to test each one
        d = new Dish("orange", 5.5); 
    }


    @Test
    public void setandGetCorrectNameTest() { //checks table setting correctly   
        d.setName("apple");
        assertEquals("apple", d.getName());
    }

    @Test
    public void setandGetBadNameTest() { //checks invalid params 
        d.setName(null);
        assertEquals("orange", d.getName());

    }

    @Test
    public void setandGetCorrectPriceTest() { //checks table setting correctly   
        d.setPrice(3.25);
        assertTrue(3.25==d.getPrice());
    }

    @Test
    public void setandGetBadPriceTest() { //checks invalid params 
        d.setPrice(-4);
        assertTrue(5.5== d.getPrice());
    }

    public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("DishTest");
	}
}