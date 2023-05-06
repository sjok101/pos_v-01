public class employee {
    public String id;
    public  String first;
    public  String last;
    public  String position;
    public  String phone;
    public  String email;
    public  String address;

    public employee(){
        
    }

    public employee(String id,String first, String last, String position, String phone, String email, String address) {
        this.id = id;
        this.first =  first;
        this.last = last;
        this.position =  position;
        this.phone =  phone;
        this.email =  email;
        this.address =  address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
