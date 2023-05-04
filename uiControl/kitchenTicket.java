package uiControl;


public class kitchenTicket {
    private String orderString;
    private String creationTime;
    private int priority;
    private int tableNum;
    private int ticketID;
    
    kitchenTicket() {
        orderString = "";
        creationTime = "";
        priority = 0;
        tableNum = 0;
        ticketID = 0;
    }

    public void setOrderString(String s) {
        this.orderString = s;
    }

    public void setCreationTime(String s) {
        this.creationTime = s;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void settableNumber(int i) {
        this.tableNum = i;
    }

    public void setTicketid(int i) {
        this.ticketID = i;
    }
    public String getOrderString() {
        return this.orderString;
    }

    public String getCreationTime() {
        return this.creationTime;
    }

    public int getPriority() {
        return this.priority;
    }

    public int gettableNumber() {
        return this.tableNum; 
    }

    public int getTicketid() {
        return this.ticketID;
    }
}
