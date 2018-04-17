package cn.xu419.library.service;



import cn.xu419.library.model.BookModel;
import cn.xu419.library.model.ReaderModel;
import cn.xu419.library.model.RecordModel;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.logging.Logger;




@RunWith(SpringJUnit4ClassRunner.class)

/**
 * @author bsz
 * Created on 2018/3/31
 */

/**
 *
 * 加载Spring的配置文件
 *
 */
@ContextConfiguration("/applicationContext.xml")
public class PersistServiceTest {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource
    private PersistService persistService;

//    @Resource
//    private IBookPersist<BookModel> bookPersist;
//
//    @Resource
//    private IReaderPersist<ReaderModel> readerPersist;
//
//    @Resource
//    private IRecordPersist<RecordModel> recordPersist;

    @Test
    public void addBook() {
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
        logger.info(String.format("%s添加",book.getTitle())+book.toString());
    }

    @Test
    public void updateBook() {
        BookModel book = new BookModel(
                "9787807657651",
                "楚留香新传:1:借尸还魂",
                "古龙",
                "河南文艺出版社",
                Timestamp.valueOf("2013-5-1 00:00:00"),
                Float.valueOf("24.00"),
                "这不是鬼故事，却比世上任何鬼故事都离奇可怖。九月二十八，立冬。这天在掷杯山庄发生的事，楚留香若非亲眼见到，只怕永远也无法相信……",
                "24cm"
        );

        persistService.updateBook(book);
        logger.info(String.format("%s修改",book.getTitle())+book.toString());
    }

    @Test
    public void deleteBookByIsbn() {
        String isbn = "9787807657651";
        persistService.deleteBookByIsbn(isbn);
        logger.info("ISBN:"+isbn+"删除");
    }

    @Test
    public void addReader() {
        ReaderModel reader = new ReaderModel("2015011278",
                "woman",
                "zfr",
                "zfr@qq.com",
                "student");
        persistService.addReader(reader,"987654321");
        logger.info(reader.getName()+"添加"+reader.toString());

    }

    @Test
    public void updateReader() {
        ReaderModel reader = new ReaderModel("2015011278",
                "man",
                "zfr",
                "zfr@qq.com",
                "student");
        persistService.updateReader(reader);
        logger.info(reader.getName()+"修改"+reader.toString());
    }

    @Test
    public void deleteReaderByAccount() {
        String account = "2015011278";
        persistService.deleteReaderByAccount(account);
        logger.info("ACCOUNT:"+account+"删除");
    }

    @Test
    public void addRecord() {
        RecordModel record = new RecordModel(
                "9787517003908",
                "2015011382",
                Timestamp.valueOf("2018-3-30 16:33:25"),
                Timestamp.valueOf("2018-3-31 16:33:23"));
        persistService.addRecord(record);
        logger.info(record.toString());
    }

    @Test
    public void updateRecord() {
        RecordModel record = new RecordModel(
                "9787517003908",
                "2015011382",
                Timestamp.valueOf("2018-3-30 16:33:23"),
                Timestamp.valueOf("2018-3-31 16:33:23"));
        persistService.updateRecord(record);
        logger.info(record.toString());

    }

    @Test
    public void deleteRecord() {
        RecordModel record = new RecordModel(
                "9787517003908",
                "2015011382",
                Timestamp.valueOf("2018-3-30 16:33:23"),
                Timestamp.valueOf("2018-3-31 16:33:23"));
        persistService.deleteRecord(record);
        logger.info(record.toString());
    }

    @Test
    public void updatePassword() {
        String account = "2015011381";
        persistService.updatePassword(account,"123456789","987654321");
        logger.info(account+"密码修改");
    }
}