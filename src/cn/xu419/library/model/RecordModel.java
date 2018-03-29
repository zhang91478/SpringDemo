package cn.xu419.library.model;

import java.sql.Timestamp;

/**
 * @author bsz
 * Created on 2018/3/26
 *
 */
public class RecordModel {
    private String isbn;
    private String account;
    private Timestamp lendTime;
    private Timestamp returnTime;

    public RecordModel() {
    }

    public RecordModel(String isbn, String account, Timestamp lendTime, Timestamp returnTime) {
        this.isbn = isbn;
        this.account = account;
        this.lendTime = lendTime;
        this.returnTime = returnTime;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Timestamp getLendTime() {
        return lendTime;
    }

    public void setLendTime(Timestamp lendTime) {
        this.lendTime = lendTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    @Override
    public String toString() {
        return "RecordMapper{" +
                "isbn='" + isbn + '\'' +
                ", account='" + account + '\'' +
                ", lendTime=" + lendTime +
                ", returnTime=" + returnTime +
                '}';
    }
}
