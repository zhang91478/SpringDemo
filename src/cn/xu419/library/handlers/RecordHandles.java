package cn.xu419.library.handlers;


import cn.xu419.library.model.RecordModel;
import cn.xu419.library.service.IRecordPersist;
import cn.xu419.library.service.IRecordSelect;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;

/**
 * @author bsz
 * Created on 2018/4/16
 */
@Controller
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
     * @param account
     * 一个用户的账号
     * @param isbn
     * 一本书的
     * 一条借书记录
     * @return ModelAndView
     *
     */
    @RequestMapping(value = "/record",method = RequestMethod.PUT)
    public String lend(String account,String isbn){

        System.out.println("record--------------->POST-------------->readerinfo");

        if(account!=null){
            RecordModel record = new RecordModel();
            record.setAccount(account);
            record.setIsbn(isbn);
            record.setLendTime(new Timestamp(System.currentTimeMillis()));
            record.setReturnTime(new Timestamp(System.currentTimeMillis()));
            persistService.addRecord(record);
        }else {
            logger.info(String.format("未登陆，ISBN-%s的书籍无法借阅",isbn));
        }
        logger.info("添加一个借书记录到数据库");
        return "index";
    }

    @RequestMapping(value = "/record",method = RequestMethod.POST)
    public String doPost(){
        System.out.println("record--------------->PUT-------------->donothing");
        return "index";
    }

    @RequestMapping(value = "/record",method = RequestMethod.GET)
    public String doGET(){
        System.out.println("record--------------->GET-------------->donothing");
        return "index";
    }

    /**
     * 更新数据库的一条借书记录（还书）
     *
     * @param record
     * 一条借书记录
     * @return ModelAndView
     *
     */
    @RequestMapping("/record1")
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
    @RequestMapping("/record2")
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
    @RequestMapping("/record3")
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
    @RequestMapping("/record4")
    public String getRecordByIsbn(String isbn){
        logger.info("查询一位读者的借书记录 Account:"+isbn);
        selectService.getRecordByIsbn(isbn);
        return "isbn";
    }






}
