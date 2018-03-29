package cn.xu419.library.service;


import cn.xu419.library.mapper.BookMapper;
import cn.xu419.library.mapper.ReaderMapper;
import cn.xu419.library.mapper.RecordMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author bsz
 * Created on 2018/3/27
 */
public abstract class AbstractDao {
    final Logger logger = Logger.getLogger(this.getClass());

    //BookMapper接口
    @Autowired
    protected BookMapper bookMapper;

    @Autowired
    protected ReaderMapper readerMapper;

    @Autowired
    protected RecordMapper recordMapper;

}
