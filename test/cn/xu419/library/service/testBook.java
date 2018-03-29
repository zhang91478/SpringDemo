package cn.xu419.library.service;

import cn.xu419.library.model.BookModel;
import cn.xu419.library.service.IBookPersist;
import cn.xu419.library.service.IBookSelect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.logging.Logger;

/**
 * @author bsz
 * Created on 2018/3/26
 */


@RunWith(SpringJUnit4ClassRunner.class)

/**
 * 加载Spring的配置文件
 *
 */
@ContextConfiguration("/applicationContext.xml")
public class testBook {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource
    private IBookPersist<BookModel> persistService;

    @Resource
    private IBookSelect<BookModel> selectService;


    @Test
    public void testAddBook(){
        BookModel book = new BookModel(
                "9787807657651",
                "楚留香新传:1:借尸还魂",
                "",
                "河南文艺出版社",
                Timestamp.valueOf("2013-5-1 00:00:00"),
                Float.valueOf("24.00"),
                "这不是鬼故事，却比世上任何鬼故事都离奇可怖。九月二十八，立冬。这天在掷杯山庄发生的事，楚留香若非亲眼见到，只怕永远也无法相信……",
                "24cm"
        );

        persistService.addBook(book);
        logger.info(String.format("%s添加成功",book.getTitle()));

    }

    @Test
    public void testGetBookByIsbn(){
        System.out.println(selectService.getBookByIsbn("9787807657651").toString());
    }
}
