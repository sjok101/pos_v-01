public class employeeJson {
    private int id;
    private String pin;
	private String firstName;
    private String lastName;
	private String position;
	private double hours;
    private boolean isClocked;
    private String timeIn;
    private String timeOut;
    

    public int getID(){
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
    public String getPin(){
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getPosition(){
        return position;
    }

    public void setPosition(String position){
        this.position = position;
    }
    public double getHours(){
        return hours;
    }

    public void setHours(double hours){
        this.hours = hours;
    }

    public boolean getClocked(){
        return isClocked;
    }
    public void setClocked(boolean clocked){
        this.isClocked=clocked;
    }

    public String getTimeIn(){
        return timeIn;
    }

    public void setTimeIn(String timeIn){
        this.timeIn = timeIn;
    }
    public String getTimeOut(){
        return timeOut;
    }

    public void setTimeOut(String timeOut){
        this.timeOut = timeOut;
    }


    


}
