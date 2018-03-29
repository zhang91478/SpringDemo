package cn.xu419.library.service;


import cn.xu419.library.model.ReaderModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * @author bsz
 * Created on 2018/3/29
 */
@RunWith(SpringJUnit4ClassRunner.class)


 // 加载Spring的配置文件
@ContextConfiguration("/applicationContext.xml")
public class testReader {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource
    private IReaderPersist<ReaderModel> persistService;

    @Resource
    private IReaderSelect<ReaderModel> selectService;


    @Test
    public void testAddReader(){
        ReaderModel reader = new ReaderModel(
                "2015011385",
                "man",
                "lsh",
                "lsh@qq.com",
                "student");
        persistService.addReader(reader,"123456789");
        logger.info(String.format("%s添加成功",reader.getAccount()));
    }

    @Test
    public void testGetReaderByAccount(){
        System.out.println(selectService.getReaderByAccount("2015011381").toString());
    }
}
