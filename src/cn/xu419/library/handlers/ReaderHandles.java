package cn.xu419.library.handlers;

import cn.xu419.library.model.BookModel;
import cn.xu419.library.model.ReaderModel;
import cn.xu419.library.model.RecordModel;
import cn.xu419.library.service.*;

import com.sun.prism.impl.Disposer;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author bsz
 * Created on 2018/4/16
 */
@Controller
@SessionAttributes({"nowUser","password"})
public class ReaderHandles {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    @Qualifier("selectService")
    private SelectService selectService;


    @Autowired

    private IRecordSelect<RecordModel> recordService;


    @Autowired
    @Qualifier("persistService")
    private IReaderPersist<ReaderModel> persistService;




    /**
     * 页面跳转到注册页面
     *
     * @return ModelANdView
     *
     */
    @RequestMapping("/registerPage")
    public String toRegister(){
        return "registerPage";
    }


    /**
     * 登陆
     *
     * @param map
     * 一个map
     * @param account
     * 账户
     * @param password
     * 密码
     * @return modelAndView
     *
     */
    @RequestMapping("/login")
    public String login(Map<String,Object> map, String account, String password, HttpSession session) {

        if (account == null || password == null) {
            account = ((ReaderModel) session.getAttribute("nowUser")).getAccount();
            password = (String) session.getAttribute("password");

        }
        ReaderModel readerModel = selectService.login(account, password);

        if (readerModel.getAccount() == null) {
            return "index";
        } else if (!readerModel.getPosition().equals("manage")) {
            session.setAttribute("nowUser", readerModel);
            session.setAttribute("password", password);
            List<BookModel> list = new ArrayList<BookModel>();
            List<RecordModel> list1 = recordService.getRecordByAccount(account);

            for (RecordModel aList1 : list1) {
                List<BookModel> list2 = selectService.getBooksByIsbn(aList1.getIsbn());
                list.addAll(list2);
            }
            map.put("lendInfo", list1);
            map.put("lendBookInfo", list);

            return "readerinfo";
        } else{
            session.setAttribute("nowUser", readerModel);
            session.setAttribute("password", password);

            map.put("allUser",selectService.getReaders());

            return "manage";
        }

    }

    /**
     * 注册一个用户并返回到登陆页面
     *
     * @param reader
     * 用户个人信息
     * @param password
     * 用户密码
     *
     */
    @RequestMapping("/register")
    public String register(ReaderModel reader,@Param("password") String password){
        logger.info("用户注册"+reader.toString());
        persistService.addReader(reader,password);
        return "index";
    }

    /**
     * 更新用户密码
     *
     * @param reader
     * 一个用户的个人信息
     * @return ModelAndView
     *
     */
    @RequestMapping("/reader3")
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
    @RequestMapping("/reader2")
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
    @RequestMapping("/reader1")
    public String getAccount(String account){
        logger.info("查询用户"+account);
        selectService.getReaderByAccount(account);
        return "getAccount";
    }

    /**
     * 删除一个用户
     *
     * @param account
     * 需要删除的用户的账户
     * @return 管理页
     *
     */
    @RequestMapping(value = "/manage",method = RequestMethod.DELETE)
    public String delete1(String account){
        logger.info("删除该用户"+account);
        persistService.deleteReaderByAccount(account);
        return "redirect:login";
    }
    /**
     * 删除一个用户
     *
     * @param account
     * 需要删除的用户的账户
     * @return 管理页
     *
     */
    @RequestMapping(value = "/manage",method = RequestMethod.POST)
    public String delete2(String account){
        // doNothing
        return "index";
    }
}
