public class employeeInformation {
    String name;
    int id;
    String address;
    String email;
    float dateStarted;
    float birthday;
    int wage;

    /**
     * Default construtor. Sets the information of the employee.
     * @param name 
     * @param id 
     * @param address 
     * @param email
     * @param dateStarted
     * @param birthday
     * @param wage
     */
    public employeeInformation(String name, int id, String address, String email, float dateStarted, float birthday, int wage) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.email = email;
        this.dateStarted = dateStarted;
        this.birthday = birthday;
        this.wage = wage;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getDateStarted() {
        return this.dateStarted;
    }

    public void setDateStarted(float dateStarted) {
        this.dateStarted = dateStarted;
    }

    public float getBirthday() {
        return this.birthday;
    }

    public void setBirthday(float birthday) {
        this.birthday = birthday;
    }

    public int getWage() {
        return this.wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", id='" + getId() + "'" +
            ", address='" + getAddress() + "'" +
            ", email='" + getEmail() + "'" +
            ", dateStarted='" + getDateStarted() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", wage='" + getWage() + "'" +
            "}";
    }
}
