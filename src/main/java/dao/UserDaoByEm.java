package dao;

import bean.People;
import entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author yan
 * @date 18-9-27 下午4:13
 * @descripition 通过EntityManager来实现PeopleDao
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDaoByEm implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    public User findByUsername(String username) {
        User user=new User();
        user.setUsername(username);
        return entityManager.find(User.class,user);
    }

    public List<User> findAll() {
        return null;
    }
}
