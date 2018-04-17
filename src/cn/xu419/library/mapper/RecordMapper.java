package cn.xu419.library.mapper;

import cn.xu419.library.model.RecordModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author bsz
 * Created on 2018/3/26
 */
public interface RecordMapper {
    /**
     * 插入一条借书数据
     *
     * @param record
     * 借书记录，所有字段不为空，用returnTime和lendTime想等代表借书未还。
     *
     */
    public void addRecord(@Param("record") RecordModel record);

    /**
     * 删除一条图书借还记录
     *
     * @param record
     * 完整的借书记录，包括书的isbn,读者的account,借出和归还时间（归还时间可为空）
     *
     */
    public void deleteRecord(@Param("record") RecordModel record);

    /**
     * 更新借还记录，用于还书
     *
     * @param record
     * 完整的借书记录，包括书的isbn,读者的account,借出和归还时间(归还时间可为空)
     *
     */
    public void updateRecord(@Param("record") RecordModel record);

    /**
     * 查询某本书的借书记录
     *
     * @param isbn
     * 书的isbn
     * @return list
     */
    public List<RecordModel> getRecordByIsbn(@Param("isbn") String isbn);

    /**
     * 查询某读者的借书记录
     *
     * @param account
     * 某读者的account
     * @return list
     *
     */
    public List<RecordModel> getRecordByAccount(@Param("account") String account);
}
