package cn.xu419.library.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;


/**
 * 这是一个查询服务的增强代码
 * @author bsz
 * Created on 2018/3/27
 */
public class SelectAdvice {
    private final Logger logger = Logger.getLogger(this.getClass());


    /**
     *
     *
     *
     *
     */
    public void before(){
        //TODO 调试过后删除此控制台显示
        System.out.println("Before:-------------->");
    }

    public void After(){
        //TODO 调试过后删除此控制台显示
        System.out.println("After:-------------->");
    }
    /**
     * 统计业务的执行时间
     *
     * @param pjp ProceedingJoinPoint
     * @return 业务方法的返回值
     * @throws Throwable Throwable
     */
    public Object recordMethodTime(ProceedingJoinPoint pjp) throws Throwable{
        logger.info("Around:统计时间增强进入");
        long begin = System.currentTimeMillis();
        Object o = pjp.proceed();
        long end = System.currentTimeMillis();
        String s = String.format("业务方法：%s执行花费了%s毫秒",
                pjp.getTarget().getClass()+"."+pjp.getSignature().getName(),
                (end-begin));
        logger.info(s);
        logger.info("Around:统计时间增强结束");
        return o;
    }

}
