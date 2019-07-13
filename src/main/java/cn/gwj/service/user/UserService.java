package cn.gwj.service.user;

import cn.gwj.entity.User;

public interface UserService {
    String add(String name);
    public User login(String userCode, String userPassword);


}
