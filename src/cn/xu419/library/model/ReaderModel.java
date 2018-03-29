package cn.xu419.library.model;

/**
 * 读者信息包含密码
 * @author bsz
 * Created on 2018/3/26
 */
public class ReaderModel {
    private String account;
    private String sex;
    private String name;
    private String email;
    private String position;

    public ReaderModel() {
    }

    public ReaderModel(String account, String sex, String name, String email, String position) {
        this.account = account;
        this.sex = sex;
        this.name = name;
        this.email = email;
        this.position = position;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReaderModel{" +
                "account='" + account + '\'' +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
