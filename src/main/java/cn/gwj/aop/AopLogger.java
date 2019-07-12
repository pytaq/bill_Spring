package cn.gwj.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * 增强类
 */
public class AopLogger {
    private Logger logger=Logger.getLogger(AopLogger.class);

    public void before(JoinPoint jp){
        logger.info("执行了"+jp.getTarget()+"的"+jp.getSignature().getName()
                +"的方法，传入了参数"+ Arrays.toString(jp.getArgs()));
    }

    public void after(JoinPoint jp,Object result){
        logger.info("执行了"+jp.getTarget()+"的"+jp.getSignature().getName()
                +"的方法，返回值"+ result);
    }

}
