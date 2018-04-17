package cn.xu419.library.listener;

import org.springframework.web.context.ContextLoaderListener;
import javax.servlet.ServletContextEvent;

import java.util.Map;
import java.util.Set;

/**
 * @author bsz
 * Created on 2018/3/31
 */
public class MyContextLoaderListener extends ContextLoaderListener {
    /**
     *
     * 将所有的线程启动
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        @SuppressWarnings("unchecked")
        /**
         * @param threadMap thread pool
         */
        Map<String, Thread> threadMap = (Map<String, Thread>) getCurrentWebApplicationContext()
        .getBean("jobMap");
        // start Threads
        Set<Map.Entry<String, Thread>> threadMapEntrySet = threadMap.entrySet();
        for (Map.Entry<String, Thread> threadMapEntry : threadMapEntrySet) {
            threadMapEntry.getValue().start();
        }
    }
}
