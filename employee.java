public class employee {

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
    public employee(String name, int id, String address, String email, float dateStarted, float birthday, int wage) {
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

    /**
     * Automatically generated, commented out till needed
     */
    // @Override
    // public boolean equals(Object o) {
    //     if (o == this)
    //         return true;
    //     if (!(o instanceof employee)) {
    //         return false;
    //     }
    //     employee employee = (employee) o;
    //     return Objects.equals(name, employee.name) && id == employee.id && Objects.equals(address, employee.address) && Objects.equals(email, employee.email) && dateStarted == employee.dateStarted && birthday == employee.birthday && wage == employee.wage;
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(name, id, address, email, dateStarted, birthday, wage);
    // }

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
