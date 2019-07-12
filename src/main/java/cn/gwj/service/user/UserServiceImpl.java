package cn.gwj.service.user;
import cn.gwj.dao.UserDao;

public class UserServiceImpl implements UserService{
    private UserDao userDao;
    private String name;
    public UserServiceImpl() {}
    public UserServiceImpl(UserDao userDao, String name){
        this.userDao=userDao;
        this.name=name;
    }
    public String add(String name){
        System.out.println("add方法");
        return "添加了"+name;
    }
}