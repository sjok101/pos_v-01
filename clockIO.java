import java.time.LocalDate;
import java.time.LocalDateTime;
public class clockIO {
    LocalDateTime clockIn = null;
    LocalDateTime clockOut = null;
    Employee employee;

    public clockIO(LocalDateTime clockInTime, Employee employee){
        this.clockIn = clockInTime;
        this.employee = employee;
    }

    public void setClockout(LocalDateTime clockOut){
        this.clockOut = clockOut;
        
    }
}
