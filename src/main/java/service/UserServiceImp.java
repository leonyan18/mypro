package service;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yan
 * @date 2018/10/18 14:57
 * @descripition
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    @Qualifier("userDaoByEm")
    UserDao userDao;
    @Cacheable(cacheNames = "users",key="'users'")
    public List<User> findAllUser() {
        return userDao.findAll();
    }
    @Cacheable(cacheNames = "user",key = "#result.uid")
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
    @CacheEvict(cacheNames = {"users","user"}, allEntries=true)
    public void cacheClear() {
    }
}
