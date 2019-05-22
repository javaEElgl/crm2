package zxh.zxh.util;

public class User {
    private int u_id;
    private String u_name;
    private String u_pwd;
    private int u_role_id;

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(int u_id, String u_name, String u_pwd, int u_role_id) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_pwd = u_pwd;
        this.u_role_id = u_role_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public int getU_role_id() {
        return u_role_id;
    }

    public void setU_role_id(int u_role_id) {
        this.u_role_id = u_role_id;
    }
}
