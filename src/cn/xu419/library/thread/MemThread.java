package cn.xu419.library.thread;

import cn.xu419.library.mapper.MemoryMapper;
import cn.xu419.library.model.MemoryModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

/**
 * @author bsz
 * Created on 2018/3/31
 */
public class MemThread extends Thread{
    private static final Logger logger = Logger.getLogger(MemThread.class);

    @Autowired
    public MemoryMapper memoryMapper;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                MemoryModel memoryModel = new MemoryModel();
                memoryModel.setMaxMemory((int) (Runtime.getRuntime().maxMemory() / 1024 / 1024));
                memoryModel.setTotalMemory((int) (Runtime.getRuntime().totalMemory() / 1024 / 1024));
                memoryModel.setFreeMemory((int) (Runtime.getRuntime().freeMemory() / 1024 / 1024));
                memoryModel.setTime(new Timestamp(System.currentTimeMillis()));

                logger.info("记录一次内存信息"+memoryModel.toString());
                // TODO: 2018/4/17 打印内存 信息 到控制台
                System.out.println(memoryModel.toString());
                if(memoryMapper == null){
                    System.out.println("memoryMapper加载失败");
                }
                memoryMapper.addMemoryInfo(memoryModel);

            } catch (InterruptedException e) {
                logger.error("ERROR", e);
            }
        }
    }
}
