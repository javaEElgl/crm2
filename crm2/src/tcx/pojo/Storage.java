package tcx.pojo;

public class Storage {
    private int p_id;
    private String p_name;
    private String p_storagename;
    private String p_ware;
    private String p_count;
    private String p_memo;

    public Storage() {
    }

    public Storage(int p_id, String p_name, String p_storagename, String p_ware, String p_count, String p_memo) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_storagename = p_storagename;
        this.p_ware = p_ware;
        this.p_count = p_count;
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

    public String getP_storagename() {
        return p_storagename;
    }

    public void setP_storagename(String p_storagename) {
        this.p_storagename = p_storagename;
    }

    public String getP_ware() {
        return p_ware;
    }

    public void setP_ware(String p_ware) {
        this.p_ware = p_ware;
    }

    public String getP_count() {
        return p_count;
    }

    public void setP_count(String p_count) {
        this.p_count = p_count;
    }

    public String getP_memo() {
        return p_memo;
    }

    public void setP_memo(String p_memo) {
        this.p_memo = p_memo;
    }
}