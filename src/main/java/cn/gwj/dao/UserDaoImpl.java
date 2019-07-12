package cn.gwj.dao;

import cn.gwj.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public List<User> selectUserByName(String name) {
        return null;
    }

    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public int modify(User user) {
        return 0;
    }

    @Override
    public int updatePwd(int id, String password) {
        return 0;
    }

    @Override
    public int deleteUserById(int id) {
        return 0;
    }

    @Override
    public List<User> getUserList(String userName, int userRole, int currentPageNo, int PageSize) {
        return null;
    }

    @Override
    public int add() {
        throw new RuntimeException("数据异常");
    }
}
