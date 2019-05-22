package tcx.pojo;

public class Order {
    private int or_id;
    private String cst_name;
    private int or_money;

    public Order() {
    }

    public Order(int or_id, String cst_name, int or_money) {
        this.or_id = or_id;
        this.cst_name = cst_name;
        this.or_money = or_money;
    }

    public int getOr_id() {
        return or_id;
    }

    public void setOr_id(int or_id) {
        this.or_id = or_id;
    }

    public String getCst_name() {
        return cst_name;
    }

    public void setCst_name(String cst_name) {
        this.cst_name = cst_name;
    }

    public int getOr_money() {
        return or_money;
    }

    public void setOr_money(int or_money) {
        this.or_money = or_money;
    }
}
