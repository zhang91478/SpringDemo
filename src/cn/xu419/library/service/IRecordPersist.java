package cn.xu419.library.service;

/**
 * @author bsz
 * Created on 2018/3/27
 */
public interface IRecordPersist<T>{
    /*--------------以下是针对record的增删改操作------------------*/
    /**
     * 插入一条借书数据
     *
     * @param record
     * 借书记录，除returnTime外其他字段不能为空
     *
     */
    public void addRecord(T record);

    /**
     * 删除一条图书借还记录
     *
     * @param record
     * 完整的借书记录，包括书的isbn,读者的account,借出和归还时间（归还时间可为空）
     *
     */
    public void deleteRecord(T record);

    /**
     * 更新借还记录，可用于还书
     *
     * @param record
     * 完整的借书记录，包括书的isbn,读者的account,借出和归还时间(归还时间可为空)
     *
     */
    public void updateRecord(T record);

}
