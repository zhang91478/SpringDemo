package cn.xu419.library.service;


import java.util.List;

/**
 * @author bsz
 * Created on 2018/3/27
 */
public interface IRecordSelect<T>{

    /*--------------以下是针对record的查操作------------------*/

    /**
     * 查询某本书的借书记录
     *
     * @param isbn
     * 书的isbn
     * @return list
     */
    public List<T> getRecordByIsbn(String isbn);

    /**
     * 查询某读者的借书记录
     *
     * @param account
     * 某读者的account
     * @return list
     *
     */
    public List<T> getRecordByAccount(String account);


}
