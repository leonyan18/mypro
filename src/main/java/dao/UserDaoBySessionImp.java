package dao;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @author yan
 * @date 18-9-27 下午4:13
 * @descripition 通过SessionFactory来实现PeopleDao
 */
@Repository
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

    public void saveUser(User user) {
        currentSession().persist(user);
    }
}
