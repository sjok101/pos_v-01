import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.rules.Verifier;

public class mainMenuTester {
    
    
    //===========================================//
    //=========Tests for userAccounts==========//
    //===========================================//
    @Test
    public void isUserNull(){
        userAccounts createAcc = new userAccounts("john", "pass123");
        if(createAcc==null){
            throw new NullPointerException();
        }

    }

    @Test
    public void isUserAdded(){
        userAccounts createAcc = new userAccounts("john", "pass123");
        userAccounts.initializeSample(createAcc);
        if(!userAccounts.checkUsers(createAcc)){
            throw new Error("User not instantiated");
        }

    }



    //===========================================//
    //=========Tests for ClockIO==========//
    //===========================================//

    @Test
    public void isClockCreated(){
        clockIO testClock = new clockIO(LocalDateTime.now(), new employee("John", "server", 1, 12, 0));    
        if(testClock.clockIn==null){
            throw new NullPointerException("Clock in not instantiated");
        }
        if(testClock.employee==null){
            throw new NullPointerException("Employee not instantiated");
        }
    }

    @Test
    public void isClockedOut(){
        clockIO testClock = new clockIO(LocalDateTime.now(), new employee("John", "server", 1, 12, 0));    
        testClock.setClockout(LocalDateTime.now());
        if(testClock.clockOut==null){
            throw new NullPointerException("Clock in not instantiated");
        }
    }
    
}