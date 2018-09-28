package dao;

import bean.People;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/**
 * @author yan
 * @date 18-9-27 下午4:13
 * @descripition 通过SessionFactory来实现PeopleDao
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDaoBySessionImp  implements UserDao {
//    @Autowired
    private SessionFactory sessionFactory;

    public Session  currentSession() {
        return sessionFactory.getCurrentSession();
    }


    public User findByUsername(String name) {
        return null;
    }

    public List<User> findAll() {
        return currentSession().createQuery("from User ").list();
    }
}
