package dao;

import entity.User;
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
        return (User) entityManager.createQuery("FROM User where username=:A ").setParameter("A",username).getSingleResult();
    }

    public List<User> findAll() {
        return (List<User>) entityManager.createQuery("FROM User ").getResultList();
    }
    public void saveUser(User user) {
        entityManager.persist(user);
    }
}
