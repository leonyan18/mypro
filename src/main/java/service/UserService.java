package service;

import entity.User;

import java.util.List;

/**
 * @author yan
 * @date 2018/10/18 14:56
 * @descripition
 */
public interface UserService {
    /**
     * 查询所有的人员
     * @return
     */
    List<User> findAllUser();

    /**
     * 根据名字查询人员
     * @param username
     * @return
     */
    User findByUsername(String username);
    void cacheClear();
}
