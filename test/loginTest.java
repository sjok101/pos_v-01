
import java.io.IOException;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class loginTest {
    LinkedList<loginJson> logJ;

      
    @Before
    public void setupTest() throws IOException{
        logJ = JSONwriter.readUsers();

    }

    @Test
    public void getFirstNameTest(){
        String testName = "numpy";
        assertEquals(logJ.get(0).getUser(), testName);
    }

    @Test
    public void setFirstNameTest(){
        String testName = "bumpy";
        logJ.get(0).setUser(testName);
        assertEquals(logJ.get(0).getUser(), testName);
    }

    
    @Test
    public void getLastNameTest(){
        String testName = "password";
        assertEquals(logJ.get(0).getPass(), testName);
    }

    @Test
    public void setLastNameTest(){
        String testName = "Blige";
        logJ.get(0).setPass(testName);
        assertEquals(logJ.get(0).getPass(), testName);
    }
    
    
}
