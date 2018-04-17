package cn.xu419.library.handlers;


import cn.xu419.library.model.RecordModel;
import cn.xu419.library.service.IRecordPersist;
import cn.xu419.library.service.IRecordSelect;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bsz
 * Created on 2018/4/16
 */
public class RecordHandles {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired()
    @Qualifier("selectService")
    IRecordSelect<RecordModel> selectService;

    @Autowired()
    @Qualifier("persistService")
    IRecordPersist<RecordModel> persistService;

    /**
     * 添加一个借书记录到数据库（借书）
     *
     * @param record
     * 一条借书记录
     * @return ModelAndView
     *
     */
    @RequestMapping("/record")
    public String lend(RecordModel record){
        logger.info("添加一个借书记录到数据库");
        persistService.addRecord(record);
        return "lend";
    }

    /**
     * 更新数据库的一条借书记录（还书）
     *
     * @param record
     * 一条借书记录
     * @return ModelAndView
     *
     */
    @RequestMapping("/record")
    public String back(RecordModel record){
        logger.info("更新数据库的一条借书记录"+record);
        persistService.updateRecord(record);
        return "back";
    }


    /**
     * 删除数据库的一个借书记录
     *
     * @param record
     * 一条借书记录
     * @return ModelAndView
     *
     */
    @RequestMapping("/record")
    public String delete(RecordModel record){
        logger.info("删除一条借书记录"+record.toString());
        persistService.deleteRecord(record);
        return "delete";
    }

    /**
     * 查询一位读者的借书记录
     *
     * @param account
     * 一位读者的账号
     * @return ModelAndView
     *
     */
    @RequestMapping("/record")
    public String getRecordByAuthor(String account){
        logger.info("查询一位读者的借书记录 Account:"+account);
        selectService.getRecordByAccount(account);
        return "author";
    }

    /**
     * 查询一本书的借书记录
     *
     * @param isbn
     * 一本书的isbn
     * @return ModelAndView
     *
     */
    @RequestMapping("/record")
    public String getRecordByIsbn(String isbn){
        logger.info("查询一位读者的借书记录 Account:"+isbn);
        selectService.getRecordByIsbn(isbn);
        return "isbn";
    }






}
