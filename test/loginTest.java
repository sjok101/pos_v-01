import java.io.IOException;
import java.util.*;
import java.util.regex.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Test.*;


import static org.junit.Assert.*;

public class loginTest {


     @Test
    public void checkEmptyFields() throws IOException { //checks table setting correctly   
        boolean test = parse.authUserPass("", "");
    }
    @Test
    public void wrongLogin() { //checks table setting correctly   
    }
    public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("tableTest");
	}

}
