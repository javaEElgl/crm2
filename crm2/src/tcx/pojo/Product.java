package tcx.pojo;

public class Product {
    private int p_id;
    private String p_name;
    private String p_type;
    private String p_batch;
    private String p_unit;
    private String p_price;
    private String p_memo;

    public Product() {
    }

    public Product(int p_id, String p_name, String p_type, String p_batch, String p_unit, String p_price, String p_memo) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_type = p_type;
        this.p_batch = p_batch;
        this.p_unit = p_unit;
        this.p_price = p_price;
        this.p_memo = p_memo;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_type() {
        return p_type;
    }

    public void setP_type(String p_type) {
        this.p_type = p_type;
    }

    public String getP_batch() {
        return p_batch;
    }

    public void setP_batch(String p_batch) {
        this.p_batch = p_batch;
    }

    public String getP_unit() {
        return p_unit;
    }

    public void setP_unit(String p_unit) {
        this.p_unit = p_unit;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public String getP_memo() {
        return p_memo;
    }

    public void setP_memo(String p_memo) {
        this.p_memo = p_memo;
    }
}
