


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

    kitchenTicket(String s, int x, int y, int z,String c) {
        creationTime = s;
        priority = x;
        tableNum = y;
        ticketID = z;
        orderString = c;
    }

    public void setOrderString(String s) {
        if(s == null) {
            this.orderString = "";
        }
        else {
            this.orderString = s; 
        }
    }

    public void setCreationTime(String s) {
        if(s == null) {
            this.creationTime = "";
        }
        else {
            this.creationTime = s; 
        }
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void settableNum(int i) {
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

    public int getTableNum() {
        return this.tableNum; 
    }

    public int getTicketid() {
        return this.ticketID;
    }
}
