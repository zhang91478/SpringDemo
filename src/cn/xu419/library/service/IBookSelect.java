package cn.xu419.library.service;


import java.util.List;

/**
 * @author bsz
 * Created on 2018/3/27
 */
public interface IBookSelect<T> {
    /*--------------以下是针对Book的查操作------------------*/
    /**
     * 通过isbn,查询书籍，返回结果唯一
     *
     * @param isbn
     * 一本书的isbn
     * @return BookModel
     * 查询返回的书籍，若不存在则为空
     */
    public List<T> getBooksByIsbn(String isbn);

    /**
     * 查询指定作者所著书籍，返回该作者的所有数据的数目信息
     *
     * @param author
     * 所查询的书籍的作者
     * @return List of BookModel;
     *
     */
    public List<T> getBooksByAuthor(String author);

    /**
     * 通过书名查询数目信息
     *
     * @param title
     * 所查询的书籍的书名
     * @return List of BookModel;
     *
     */
    public List<T> getBooksByTitle(String title);







}
