package tcx.pojo;

public class Lost {
    private String lost_lostdate;
    private String lost_customer;
    private String lost_manager;
    private String lost_reason;

    public Lost() {
    }

    public Lost(String lost_lostdate, String lost_customer, String lost_manager, String lost_reason) {
        this.lost_lostdate = lost_lostdate;
        this.lost_customer = lost_customer;
        this.lost_manager = lost_manager;
        this.lost_reason = lost_reason;
    }

    public String getLost_lostdate() {
        return lost_lostdate;
    }

    public void setLost_lostdate(String lost_lostdate) {
        this.lost_lostdate = lost_lostdate;
    }

    public String getLost_customer() {
        return lost_customer;
    }

    public void setLost_customer(String lost_customer) {
        this.lost_customer = lost_customer;
    }

    public String getLost_manager() {
        return lost_manager;
    }

    public void setLost_manager(String lost_manager) {
        this.lost_manager = lost_manager;
    }

    public String getLost_reason() {
        return lost_reason;
    }

    public void setLost_reason(String lost_reason) {
        this.lost_reason = lost_reason;
    }
}
