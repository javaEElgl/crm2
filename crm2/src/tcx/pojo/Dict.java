package tcx.pojo;

public class Dict {
    private int d_id;
    private String d_type;
    private String d_item;
    private String d_value;
    private String p_isedit;

    public Dict() {
    }

    public Dict(int d_id, String d_type, String d_item, String d_value, String p_isedit) {
        this.d_id = d_id;
        this.d_type = d_type;
        this.d_item = d_item;
        this.d_value = d_value;
        this.p_isedit = p_isedit;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_type() {
        return d_type;
    }

    public void setD_type(String d_type) {
        this.d_type = d_type;
    }

    public String getD_item() {
        return d_item;
    }

    public void setD_item(String d_item) {
        this.d_item = d_item;
    }

    public String getD_value() {
        return d_value;
    }

    public void setD_value(String d_value) {
        this.d_value = d_value;
    }

    public String getP_isedit() {
        return p_isedit;
    }

    public void setP_isedit(String p_isedit) {
        this.p_isedit = p_isedit;
    }
}
