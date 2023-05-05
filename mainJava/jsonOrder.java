public class jsonOrder {
    private String tableNum;
    private String orderID;
    private String total;
    private String creationTime;
    private String dishes;

    public String getTableNum(){
        return this.tableNum;
    }

    public String getOrderID(){
        return this.orderID;
    }

    public String getTotal(){
        return this.total;
    }

    public String getCreationTime(){
        return this.creationTime;
    }

    public String getDishes(){
        return this.dishes;
    }

    public void setTableNum(String tblnum){
        this.tableNum = tblnum;
    }

    public void setOrderID(String ID){
        this.orderID = ID;
    }

    public void setToatl(String tot){
        this.total = tot;
    }

    public void getCreationTime(String ct){
        this.creationTime = ct;
    }

    public void getDishes(String ds){
        this.dishes = ds;
    }    
}
