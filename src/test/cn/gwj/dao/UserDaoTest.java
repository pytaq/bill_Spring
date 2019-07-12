package cn.gwj.dao;

import cn.gwj.entity.User;
import cn.gwj.service.user.UserService;
import cn.gwj.service.user.UserServiceImpl;
import cn.gwj.util.MyBatisUtil;
import javafx.application.Application;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/*    
    Created by IntelliJ IDEA.
    Package:cn.gwj.dao
    User:1093499975@qq.com
    Date:2019/7/6 0006
    Time:15:59
*/

public class UserDaoTest {
    private Logger logger=Logger.getLogger(UserDaoTest.class);
    @Test
    public void count(){
        SqlSession sqlSession=null;
        List<User> list=new ArrayList<>();
        try {
//            //加载mybatis的配置文件
//            InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
//            //通过sqlSession工厂创建者build出一个数据库会话工程
//            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
            //打开一个数据库会话
            sqlSession=MyBatisUtil.createSqlSession();
            int count=sqlSession.selectOne("cn.gwj.dao.UserDao.count");
            logger.info("统计：" + count);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

//    @Test
//    public void findAll(){
//        SqlSession sqlSession=null;
//        List<User> list=new ArrayList<>();
//        try {
////            //加载mybatis的配置文件
////            InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
////            //通过sqlSession工厂创建者build出一个数据库会话工程
////            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
//            //打开一个数据库会话
//            sqlSession=MyBatisUtil.createSqlSession();
//            //第一种方式:调用selectList方法执行查询操作
//            //  list=sqlSession.selectList("cn.cxh.dao.UserMapper.selectAll");
//            //第二种方式:调用getMapper(Mapper.class)执行UserMapper dao接口方法来实现对数据库的查询操作
//            list=sqlSession.getMapper(UserDao.class).selectAll();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            MyBatisUtil.closeSqlSession(sqlSession);
//        }
//        for (User user:list ) {
//            logger.info("User："+user.getUserName());
//        }
//    }

    @Test
    public void selectUserByName(){
        SqlSession sqlSession=null;
        List<User> list=new ArrayList<>();
        try{
            sqlSession=MyBatisUtil.createSqlSession();
            list=sqlSession.getMapper(UserDao.class).selectUserByName("孙");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        for (User user:list ) {
            logger.info("User："+user.getUserName());
        }
    }

    @Test
    public void getUserList(){
        SqlSession sqlSession=MyBatisUtil.createSqlSession();
        List<User> list=new ArrayList<>();
        try{
            sqlSession=MyBatisUtil.createSqlSession();
            list=sqlSession.getMapper(UserDao.class).getUserList("李明",1,0,1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        for (User user:list){
            logger.info(user.getUserName());
        }
    }

    @Test
    public void TestSpring(){
        //通过ClassPathXmlApplicationContext实例化Spring的上下文
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");

        //通过ApplicationContext的getBean()方法，根据id来获取bean的实例
        User user=(User)applicationContext.getBean("user");
        user.setUserCode("asda");
        logger.info(user.getUserName());
        logger.info(user.getUserCode());
        logger.info(user.getRole().getRoleCode());
    }

    @Test
    public void testAop(){
        //通过ClassPathXmlApplicationContext实例化Spring的上下文
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        //通过ApplicationContext的getBean()方法，根据id来获取bean的实例
        UserService userService=(UserService)applicationContext.getBean("userService");
        userService.add("张三");

    }

}