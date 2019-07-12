package cn.gwj.aop;

import cn.gwj.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 增强类
 */
@Aspect
public class AopLogger {
    private Logger logger=Logger.getLogger(AopLogger.class);

    @Pointcut("execution(* cn.gwj.service..*.*(..))")
    public void pt(){}

    @Before("pt()")
    public void before(JoinPoint jp){
        logger.info("前置增强-执行了"+jp.getTarget()+"的"+jp.getSignature().getName()
                +"的方法，传入了参数"+ Arrays.toString(jp.getArgs()));
    }

    @AfterReturning(pointcut = "pt()",returning = "result")
    public void after(JoinPoint jp,Object result){
        logger.info("后置增强执行了"+jp.getTarget()+"的"+jp.getSignature().getName()
                +"的方法，返回值"+ result);
    }

    @After("pt()")
    public void aft(JoinPoint jp){
//        SqlSession sqlSession=(SqlSession)jp.getArgs()[0];
//        MyBatisUtil.closeSqlSession(sqlSession);
        logger.info("最终增强-执行了"+jp.getTarget()+"的"+jp.getSignature().getName()
                +"的方法");
    }

    @AfterThrowing(pointcut = "pt()",throwing = "e")
    public void exc(JoinPoint jp,RuntimeException e){
        logger.info("异常增强-执行了"+jp.getTarget()+"的"+jp.getSignature().getName()
                +"的方法，异常"+ e);
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint pj) throws Throwable {
        logger.info(
                "前置增强-执行了"+pj.getTarget()+"的"+pj.getSignature().getName()+"方法。方法传参"+Arrays.toString(pj.getArgs())
        );
        try{
            Object result=pj.proceed();
            logger.info(
                    "后置增强-执行了"+pj.getTarget()+"的"+pj.getSignature().getName()
                            +"的方法，返回值"+ result
            );
            return result;
        }catch (Throwable e){
            logger.error("环绕增强"+pj.getSignature().getName()+"方法发生异常。");
            throw e;

        }finally {
            logger.info("环绕增强-"+pj.getSignature().getName()+"方法结束执行。");
        }

    }


}
