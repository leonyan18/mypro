package dao;

import bean.People;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class PeopleDaoImp  implements PeopleDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session  currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public People findByName(String name) {
        return null;
    }

    public List<People> findAll() {
        return currentSession().createQuery("from User ").list();
    }
}
