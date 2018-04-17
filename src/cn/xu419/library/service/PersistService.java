package cn.xu419.library.service;

import cn.xu419.library.model.BookModel;
import cn.xu419.library.model.ReaderModel;
import cn.xu419.library.model.RecordModel;
import cn.xu419.library.util.Md5Utils;

/**
 * @author bsz
 * Created on 2018/3/27
 */
public class PersistService extends AbstractDao
        implements IBookPersist<BookModel>,IReaderPersist<ReaderModel>,IRecordPersist<RecordModel> {

    public PersistService() {
        super();
        System.out.println("PersistService调用无参构造方法");
    }

    /**
     * 添加一本书的信息进数据库
     *
     * @param book 想要添加进数据库的书，必须保证书的isbn和title不为空
     */
    @Override
    public void addBook(BookModel book) {
        try {
            bookMapper.addBook(book);
        } catch (Exception e){
            logger.error("ERROR",e);
        }
    }

    /**
     * 更新一本书的数目信息，需要知道书的isbn
     *
     * @param book 更新后新的数目信息
     */
    @Override
    public void updateBook(BookModel book) {
        try {
            bookMapper.updateBook(book);
        } catch (Exception e){
            logger.error("ERROR",e);
        }
    }

    /**
     * 通过isbn删除数据库中一本书的数目信息
     *
     * @param isbn 需要删除数目信息的isbn
     */
    @Override
    public void deleteBookByIsbn(String isbn) {
        try {
            bookMapper.deleteBookByIsbn(isbn);
        } catch (Exception e){
            logger.error("ERROR",e);
        }
    }

    /**
     * 新添加一个读者
     *
     * @param reader   读者除密码外的其他信息
     * @param password
     * 用户密码
     */
    @Override
    public void addReader(ReaderModel reader, String password) {
        try {
            if(super.isSexLegal(reader.getSex())&&super.isPositionLegal(reader.getPosition())){
                readerMapper.addReader(reader, Md5Utils.transToMd5(password));
            } else {
                String string = String.format("记录%s无法添加!", reader.toString());
                logger.warn(string);
            }

        } catch (Exception e){
            logger.error("ERROR",e);
        }
    }

    /**
     * 更新一个读者的个人信息
     *
     * @param reader 更新一个读者的个人信息
     */
    @Override
    public void updateReader(ReaderModel reader) {
        try {
            readerMapper.updateReader(reader);
        } catch (Exception e){
            logger.error("ERROR",e);
        }
    }

    /**
     * 通过账号删除一个读者，白名单读者不允许删除
     *
     * @param account 一个读者的账号
     */
    @Override
    public void deleteReaderByAccount(String account) {
        try {
            //白名单不允许删除
            if(super.checkWhitePermission(account)){
                String string = String.format("记录%s无法删除!", account);
                logger.warn(string);
                return;
            }
            readerMapper.deleteReaderByAccount(account);
        } catch (Exception e){
            logger.error("ERROR",e);
        }
    }

    /**
     * 插入一条借书数据，黑名单用户不允许借书
     *
     * @param record 借书记录，除returnTime外其他字段不能为空
     */
    @Override
    public void addRecord(RecordModel record) {
        try {
            //黑名单不允许借书
            if (super.checkBlackPermission(record.getAccount())){
                String string = String.format("记录%s无法删除!", record.getAccount());
                logger.warn(string);
                return;
            }
            recordMapper.addRecord(record);
        } catch (Exception e){
            logger.error("ERROR",e);
        }
    }

    /**
     * 删除一条图书借还记录
     *
     * @param record 完整的借书记录，包括书的isbn,读者的account,借出和归还时间（归还时间可为空）
     */
    @Override
    public void deleteRecord(RecordModel record) {
        try {
            recordMapper.deleteRecord(record);
        } catch (Exception e){
            logger.error("ERROR",e);
        }
    }

    /**
     * 更新借还记录，可用于还书
     *
     * @param record 完整的借书记录，包括书的isbn,读者的account,借出和归还时间(归还时间可为空)
     */
    @Override
    public void updateRecord(RecordModel record) {
        try {
            recordMapper.updateRecord(record);
        } catch (Exception e){
            logger.error("ERROR",e);
        }
    }

    /**
     * 修改用户密码
     *
     * @param oldPassWord 用户老密码
     * @param newPassWord 用户新密码
     */
    @Override
    public void updatePassword(String account,String oldPassWord, String newPassWord) {
        try {
            readerMapper.updatePassword(account,Md5Utils.transToMd5(oldPassWord),Md5Utils.transToMd5(newPassWord));
        } catch (Exception e){
            logger.error("ERROR",e);
        }

    }
}
