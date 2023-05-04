import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class OrderTest {
    private Order o1 = null;
    private Dish d1 = null;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private LocalDateTime now = LocalDateTime.now();
    private String timenow = dtf.format(now);

    @Before
    public void setupTest(){
        o1 = new Order(1);
        o1.setOrderID(11);
        d1 = new Dish("Green Beans", 10);
        d1.setPrice(25.25);
        d1.setDescription("Some tasty green beans");
        o1.addDish(d1);
        
    }

    //constructor with normal table number
    @Test
    public void orderConstructorTest1(){
        Order o2 = new Order(1);
        now = LocalDateTime.now();
        timenow = dtf.format(now);
        if(o2.getCreationTime().equals(timenow)){
            assertEquals(o2.getTableNum(), 1);
            return;
        }
        fail();
    }

    

    //constructor with 0 tablen umber
    @Test
    public void orderConstructorTest2(){
        Order o2 = new Order(1);
        now = LocalDateTime.now();
        timenow = dtf.format(now);
        if(o2.getCreationTime().equals(timenow)){
            assertEquals(o2.getTableNum(), 1);
            return;
        }
        fail();
    }


    //constructor withnegative tablenumber
    @Test (expected = IndexOutOfBoundsException.class)
    public void orderConstructorTest4(){
        Order o2 = new Order(-1);
    }

    //get total
    @Test
    public void ordergetTotalTest1(){
        assertEquals(o1.getTotal(), 25.25, 0);

    }

    //set total to normal number
    @Test
    public void ordersetTotal1(){
        o1.setToatl(51.31);
        assertEquals(o1.getTotal(), 51.31, 0);

    }

    //set total to 0
    @Test
    public void ordersetTotal2(){
        o1.setToatl(0.0);
        assertEquals(o1.getTotal(), 0.0, 0);

    }

    //set total to negative number
    @Test (expected = IndexOutOfBoundsException.class)
    public void ordersetTotal3(){
        o1.setToatl(-15.1);
    }

    //get table num
    @Test 
    public void ordergetTableNum(){
        assertEquals(o1.getTableNum(), 1);
    }

    //get order ID
    @Test 
    public void ordergetorderID1(){
        assertEquals(o1.getOrderID(), 11);
    }

    //get creation time
    @Test 
    public void ordergetCreationTime(){
        String partcreate1 = o1.getCreationTime().substring(0,o1.getCreationTime().length()-1);
        String partcreate2 = timenow.substring(0, timenow.length()-1);
        String lastcreate1 = o1.getCreationTime().substring(o1.getCreationTime().length()-1);
        String lastcreate2 = timenow.substring(timenow.length()-1);
        int lastcreate1int1 = Integer.parseInt(lastcreate1);
        int lastcreate1int2 = Integer.parseInt(lastcreate2);
        if((lastcreate1int1 == lastcreate1int2) && (partcreate1.equals(partcreate2))){
            return;
        }
    }

    //set orderID to normal number
    @Test 
    public void ordersetID1(){
        o1.setOrderID(3);
        assertEquals(o1.getOrderID(), 3);
    }

    //set orderID to 0
    @Test 
    public void ordersetID2(){
        o1.setOrderID(0);
        assertEquals(o1.getOrderID(), 0);
    }

    //set orderID to negative
    @Test (expected = IndexOutOfBoundsException.class)
    public void ordersetID3(){
        o1.setOrderID(-5);
    }

    //add dish
    @Test 
    public void orderaddDish1(){
        Dish d2 = new Dish("Mashed Potatoes", 4);
        if(!o1.addDish(d2)){
            fail();
        }
        LinkedList<Dish> dishes1 = new LinkedList<>();
        dishes1.add(d1);
        dishes1.add(d2);
        assertEquals(o1.getDishes(), dishes1);
    }

    //add null
    @Test (expected = NullPointerException.class)
    public void orderaddDish2(){
        Dish d2 = null;
        o1.addDish(d2);
    }

    //remove head of dish list
    @Test 
    public void orderaremoveDish1(){
        Dish d2 = new Dish("Mashed Potatoes", 4);
        if(!o1.addDish(d2)){
            fail();
        }
        if(!o1.removeDish(d1)){
            fail();
        }
        LinkedList<Dish> dishes1 = new LinkedList<>();
        dishes1.add(d2);
        assertEquals(o1.getDishes(), dishes1);
    }

    //remove tail of dish list
    @Test 
    public void orderaremoveDish2(){
        Dish d2 = new Dish("Mashed Potatoes", 4);
        if(!o1.addDish(d2)){
            fail();
        }
        if(!o1.removeDish(d2)){
            fail();
        }
        LinkedList<Dish> dishes1 = new LinkedList<>();
        dishes1.add(d1);
        assertEquals(o1.getDishes(), dishes1);
    }

    //remove middle of dish list
    @Test 
    public void orderaremoveDish3(){
        Dish d2 = new Dish("Mashed Potatoes", 4);
        if(!o1.addDish(d2)){
            fail();
        }
        Dish d3 = new Dish("Steak", 4);
        if(!o1.addDish(d3)){
            fail();
        }
        if(!o1.removeDish(d2)){
            fail();
        }
        LinkedList<Dish> dishes1 = new LinkedList<>();
        dishes1.add(d1);
        dishes1.add(d3);
        assertEquals(o1.getDishes(), dishes1);
    }

    //get order Dishes
    @Test 
    public void ordergetDishes1(){
        LinkedList<Dish> dishes1 = new LinkedList<>();
        dishes1.add(d1);
        assertEquals(o1.getDishes(), dishes1);
    }

    //get order dishes with multiple
    @Test 
    public void ordergetDishes2(){
        Dish d2 = new Dish("Mashed Potatoes", 4);
        if(!o1.addDish(d2)){
            fail();
        }
        LinkedList<Dish> dishes1 = new LinkedList<>();
        dishes1.add(d1);
        dishes1.add(d2);
        assertEquals(o1.getDishes(), dishes1);
    }

}