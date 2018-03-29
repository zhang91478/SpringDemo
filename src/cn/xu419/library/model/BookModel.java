package cn.xu419.library.model;

import java.sql.Timestamp;

/**
 * @author bsz
 * Created on 2018/3/26
 * description 此model不包含数据库中的id字段，自增id字段为数据库的物理主键，逻辑上并没有意义。
 */
public class BookModel {
    private String isbn;
    private String title;
    private String author;
    private String press;
    private Timestamp publicationDate;
    private Float price;
    private String introduction;
    private String size;

    public BookModel() {
    }

    public BookModel(String isbn,
                     String title,
                     String author,
                     String press,
                     Timestamp publicationDate,
                     Float price,
                     String introduction,
                     String size) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.press = press;
        this.publicationDate = publicationDate;
        this.price = price;
        this.introduction = introduction;
        this.size = size;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Timestamp getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Timestamp publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", publicationDate=" + publicationDate +
                ", price=" + price +
                ", introduction='" + introduction + '\'' +
                ", size='" + size + '\'' +
                '}';
    }


}
