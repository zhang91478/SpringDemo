package cn.xu419.library.service;

import cn.xu419.library.model.BookModel;
import cn.xu419.library.model.ReaderModel;
import cn.xu419.library.model.RecordModel;


import java.util.List;


/**
 * @author bsz
 * Created on 2018/3/27
 */
public class SelectService extends AbstractDao
        implements IBookSelect<BookModel>,IReaderSelect<ReaderModel>,IRecordSelect<RecordModel>{


    /**
     * 通过isbn,查询书籍，返回结果唯一
     *
     * @param isbn 一本书的isbn
     * @return BookModel
     * 查询返回的书籍，若不存在则为空
     */
    @Override
    public BookModel getBookByIsbn(String isbn) {
        try {
            return bookMapper.getBookByIsbn(isbn);
        } catch (Exception e){
            logger.error("ERROR",e);
            return null;
        }
    }

    /**
     * 查询指定作者所著书籍，返回该作者的所有数据的数目信息
     *
     * @param author 所查询的书籍的作者
     * @return List of BookModel;
     */
    @Override
    public List<BookModel> getBooksByAuthor(String author) {
        try {
            return bookMapper.getBooksByAuthor(author);
        } catch (Exception e){
            logger.error("ERROR",e);
            return null;
        }

    }

    /**
     * 通过书名查询数目信息
     *
     * @param title 所查询的书籍的书名
     * @return List of BookModel;
     */
    @Override
    public List<BookModel> getBooksByTitle(String title) {
        try {
            return bookMapper.getBooksByTitle(title);
        } catch (Exception e){
            logger.error("ERROR",e);
            return null;
        }
    }

    /**
     * 获得一个读者除密码外的个人信息
     *
     * @param account 所查询读者的账号
     */
    @Override
    public ReaderModel getReaderByAccount(String account) {
        try {
            return readerMapper.getReaderByAccount(account);
        } catch (Exception e){
            logger.error("ERROR",e);
            return null;
        }
    }


    /**
     * 查询某本书的借书记录
     *
     * @param isbn 书的isbn
     * @return list
     */
    @Override
    public List<RecordModel> getRecordByIsbn(String isbn) {
        try {
            return recordMapper.getRecordByIsbn(isbn);
        } catch (Exception e){
            logger.error("ERROR",e);
            return null;
        }
    }

    /**
     * 查询某读者的借书记录
     *
     * @param account 某读者的account
     * @return list
     */
    @Override
    public List<RecordModel> getRecordByAccount(String account) {
        try {
            return recordMapper.getRecordByAccount(account);
        } catch (Exception e){
            logger.error("ERROR",e);
            return null;
        }
    }
}
