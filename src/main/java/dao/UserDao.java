package dao;

import entity.User;

import java.util.List;
/**
 * @author yan
 * @date 18-9-27 下午4:13
 * @descripition 传统有关人员的数据库操作
 */
public interface UserDao{
    /**
     * 通过名字查询
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 获取人员列表
     * @return
     */
    List<User> findAll();

    /**
     * 存储用户
     * @param user
     */
    void saveUser(User user);
}
