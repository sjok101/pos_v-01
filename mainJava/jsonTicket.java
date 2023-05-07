import java.util.List;
public class jsonTicket {
    private String tableNum;
    private String ticketID;
    private String total;
    private String creationTime;
    private String closingTime;
    private String togo;
    private String priority;
    private String orders;
    private String employee;
    private List<String> orderList;

    public List<String> getOrderList(){
        return this.orderList;
    }

    public void setOrderList(List<String> orderList){
        this.orderList = orderList;
    }


    public String getEmployee(){
        return this.employee;
    }
    
    public void setEmployee(String employee){
        this.employee = employee;
    }

    public String getTableNum(){
        return this.tableNum;
    }

    public String getTicketID(){
        return this.ticketID;
    }

    public String getTotal(){
        return this.total;
    }

    public String getCreationTime(){
        return this.creationTime;
    }

    public String getClosingTime(){
        return this.closingTime;
    }

    public String getTogo(){
        return this.togo;
    }

    public String getPriority(){
        return this.priority;
    }

    public String getOrders(){
        return this.orders;
    }

    public void setTableNum(String tn){
        this.tableNum = tn;
    }

    public void setTicketID(String id){
        this.ticketID = id;
    }

    public void setTotal(String tot){
        this.total = tot;
    }

    public void setCreationTime(String ct){
        this.creationTime = ct;
    }

    public void setClosingTime(String ct){
        this.closingTime = ct;
    }

    public void setTogo(String tg){
        this.togo = tg;
    }

    public void setPriority(String p){
        this.priority = p;
    }

    public void setOrders(String ordrs){
        this.orders = ordrs;
    }
    
}
