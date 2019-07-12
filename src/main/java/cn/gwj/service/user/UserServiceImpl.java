package cn.gwj.service.user;
import cn.gwj.dao.UserDao;
import cn.gwj.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
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
        UserDaoImpl userDao=new UserDaoImpl();
        userDao.add();
        return "添加了"+name;
    }


}