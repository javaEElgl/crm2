package tcx.pojo;

public class Level {
    private String cst_name;
    private String cst_level;

    public Level() {
    }

    public Level(String cst_name, String cst_level) {
        this.cst_name = cst_name;
        this.cst_level = cst_level;
    }

    public String getCst_name() {
        return cst_name;
    }

    public void setCst_name(String cst_name) {
        this.cst_name = cst_name;
    }

    public String getCst_level() {
        return cst_level;
    }

    public void setCst_level(String cst_level) {
        this.cst_level = cst_level;
    }
}
