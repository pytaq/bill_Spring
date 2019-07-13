package cn.gwj.service.user;

import cn.gwj.dao.UserDao;
import cn.gwj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    private String name;
    public UserServiceImpl() {}
//    public UserServiceImpl(UserDao userDao, String name){
//        this.userDao=userDao;
//        this.name=name;
//    }
    public String add(String name){
        System.out.println("add方法");
//        UserDaoImpl userDao=new UserDaoImpl();
        userDao.add();
        return "添加了"+name;
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(String userCode, String userPassword) {
        // TODO Auto-generated method stub
        User user = null;
        try {
            //user = userDao.getLoginUser(userCode);
            user = userDao.getLoginUser(userCode);
            System.out.println("实现类："+user.getUserPassword());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //MybatisUtil.closeSqlSession(sqlSession);
        }
        //匹配密码
        if(null != user){
            if(!user.getUserPassword().equals(userPassword))
                user = null;
        }
        return user;
    }

}