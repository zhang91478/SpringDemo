package cn.xu419.library.handlers;

import cn.xu419.library.model.ReaderModel;
import cn.xu419.library.model.RecordModel;
import cn.xu419.library.service.IReaderPersist;
import cn.xu419.library.service.IReaderSelect;
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
public class ReaderHandles {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired()
    @Qualifier("selectService")
    IReaderSelect<ReaderModel> selectService;

    @Autowired()
    @Qualifier("persistService")
    IReaderPersist<ReaderModel> persistService;

    /**
     *
     *
     * @param
     *
     * @return
     *
     */
    @RequestMapping("/reader")
    public String register(ReaderModel reader,String password){
        logger.info("用户注册"+reader.toString());
        persistService.addReader(reader,password);
        return "register";
    }

    /**
     * 更新用户密码
     *
     * @param reader
     * 一个用户的个人信息
     * @return ModelAndView
     *
     */
    @RequestMapping("/reader")
    public String updateInfo(ReaderModel reader){
        logger.info("用户信息修改"+reader.toString());
        persistService.updateReader(reader);
        return "updateInfo";
    }

    /**
     * 更改用户密码
     *
     * @param  account
     * 需要更改密码的账户
     * @param oldPassword
     * 用户老的密码
     * @param newPassword
     * 用户新的密码
     * @return ModelAndView
     *
     */
    @RequestMapping("/reader")
    public String updatePassword(String account,String oldPassword,String newPassword){
        logger.info("用户信息修改"+account);
        persistService.updatePassword(account,oldPassword,newPassword);
        return "updatePassword";
    }

    /**
     * 获得一个用户的个人信息
     *
     * @param account
     * 用户账户
     * @return modelAndView
     *
     */
    @RequestMapping("/reader")
    public String getAccount(String account){
        logger.info("查询用户"+account);
        selectService.getReaderByAccount(account);
        return "getAccount";
    }
}
