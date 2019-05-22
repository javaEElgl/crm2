package tcx.pojo;

public class Service {
    private String sv_type;
    private int sv_id;

    public Service() {
    }

    public Service(String sv_type, int sv_id) {
        this.sv_type = sv_type;
        this.sv_id = sv_id;
    }

    public String getSv_type() {
        return sv_type;
    }

    public void setSv_type(String sv_type) {
        this.sv_type = sv_type;
    }

    public int getSv_id() {
        return sv_id;
    }

    public void setSv_id(int sv_id) {
        this.sv_id = sv_id;
    }
}
