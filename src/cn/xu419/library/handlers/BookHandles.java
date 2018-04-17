package cn.xu419.library.handlers;

import cn.xu419.library.model.BookModel;
import cn.xu419.library.service.IBookPersist;
import cn.xu419.library.service.IBookSelect;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author bsz
 * Created on 2018/3/31
 */
@Controller
public class BookHandles {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    IBookSelect<BookModel> selectService;

    @Autowired()
    @Qualifier("persistService")
    IBookPersist<BookModel> persistService;

    /**
     * 通过书名查询数目信息
     *
     * @param map
     * 模型数据
     * @param search
     * 查询选项
     * 查询关键字
     * @return ModelAndView
     */
    @RequestMapping("/books")
    public String list(Map<String,Object> map, String search, String searchType){
        logger.info("开始调用books");
        if(searchType.equals("title")){
            map.put("books",selectService.getBooksByTitle(search));

            List <BookModel> list = selectService.getBooksByTitle(search);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }

        }else if(searchType.equals("author")){
            map.put("books",selectService.getBooksByAuthor(search));
        }else if(searchType.equals("isbn")){
            map.put("books",selectService.getBooksByIsbn(search));
        }
        return "bookList";
    }


    /**
     * 添加一本书到数据库
     *
     * @param bookModel
     * 需要添加的书籍
     * @return ModelAndView
     */
    @RequestMapping("/addBook")
    public String addBook(BookModel bookModel){
        logger.info("添加book"+bookModel.toString());
        persistService.addBook(bookModel);
        return "addBook";
    }

    /**
     * 通过isbn删除一本书
     *
     * @param isbn
     * 需删除数目的isbn
     * @return ModelAndView
     *
     */
    @RequestMapping("/delBook")
    public String delBook(String isbn){
        logger.info("删除book ISBN："+isbn);
        persistService.deleteBookByIsbn(isbn);
        return "delBook";
    }

    /**
     * 更新数据库里的一本书
     *
     * @param bookModel
     * 需要添加的书籍
     * @return ModelAndView
     */
    @RequestMapping("/updateBook")
    public String updateBook(BookModel bookModel){
        logger.info("更新book"+bookModel.toString());
        persistService.updateBook(bookModel);
        return "updateBook";
    }
}
