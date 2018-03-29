package cn.xu419.library.service;

/**
 * @author bsz
 * Created on 2018/3/27
 */
public interface IBookPersist <T>{
    /*--------------以下是针对Book的增删改操作------------------*/
    /**
     * 添加一本书的信息进数据库
     *
     * @param book
     * 想要添加进数据库的书，必须保证书的isbn和title不为空
     *
     */
    public void addBook(T book);

    /**
     * 更新一本书的数目信息，需要知道书的isbn
     *
     * @param book
     * 更新后新的数目信息
     *
     */
    public void updateBook(T book);

    /**
     * 通过isbn删除数据库中一本书的数目信息
     *
     * @param isbn
     * 需要删除数目信息的isbn
     *
     */
    public void deleteBookByIsbn(String isbn);


}
