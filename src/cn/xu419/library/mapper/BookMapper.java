package cn.xu419.library.mapper;

import cn.xu419.library.model.BookModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 数据库中数目信息的管理，增删改查
 *
 * @author bsz
 * Created on 2018/3/26
 */
public interface BookMapper {
    /**
     * 添加一本书的信息进数据库
     *
     * @param book
     * 想要添加进数据库的书，必须保证书的isbn和title不为空
     *
     */
    public void addBook(@Param("book")BookModel book);



    /**
     * 更新一本书的数目信息，需要知道书的isbn
     *
     * @param book
     * 更新后新的数目信息
     *
     */
    public void updateBook(@Param("book") BookModel book);

    /**
     * 通过isbn删除数据库中一本书的数目信息
     *
     * @param isbn
     * 需要删除数目信息的isbn
     *
     */
    public void deleteBookByIsbn(@Param("isbn") String isbn);

    /**
     * 查询指定作者所著书籍，返回该作者的所有数据的数目信息
     *
     * @param author
     * 所查询的书籍的作者
     * @return List of BookModel;
     *
     */
    public List<BookModel> getBooksByAuthor(@Param("author") String author);
    /**
     * 通过书名查询数目信息
     *
     * @param title
     * 所查询的书籍的书名
     * @return List of BookModel;
     *
     */
    public List<BookModel> getBooksByTitle(@Param("title") String title);

    /**
     * 通过isbn,查询书籍，返回结果唯一
     *
     * @param isbn
     * 一本书的isbn
     * @return BookModel
     * 查询返回的书籍，若不存在则为空
     */
    public List<BookModel> getBooksByIsbn(@Param("isbn") String isbn);
}
