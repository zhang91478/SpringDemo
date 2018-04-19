package cn.xu419.library.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bsz
 * Created on 2018/4/18
 */
@Controller
public class UtilHandles {
    /**
     * 返回开始页
     *
     * @return ModelAndView
     *
     */
    @RequestMapping("index")
    public String returnIndex(){
        return  "index";
    }

    /**
     *
     * 返回个人信息也
     *
     * @return ModeLAndView
     *
     */
    @RequestMapping("readerinfo")
    public String returnReaderInfo(){
        return  "readerinfo";
    }
}
