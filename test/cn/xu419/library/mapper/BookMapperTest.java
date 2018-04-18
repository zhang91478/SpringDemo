package cn.xu419.library.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;

/**
 * @author bsz
 * Created on 2018/4/19
 */
 @ContextConfiguration("/applicationContext.xml") //加载配置文件
public class BookMapperTest {

    @Autowired
    BookMapper bookMapper;
    @Test
    public void getBooksByIsbn() {
        bookMapper.getBooksByIsbn("9787208115040");
    }
}