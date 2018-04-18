package cn.xu419.library.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.junit.Assert.*;

/**
 * @author bsz
 * Created on 2018/4/19
 */
public class SelectServiceTest {

    private SelectService selectService = new SelectService();
    @Test
    public void getBooksByIsbn() {
        assertNotNull(selectService);
        assertNotNull(selectService.getBooksByIsbn("9787560336190"));

    }

    @Test
    public void getBooksByAuthor() {
    }
}