import config.DataConfig;
import config.RootConfig;
import dao.UserDao;
import dao.UserDaoByEm;
import dao.UserRepository;
import entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author yan
 * @date 2018/10/10 19:11
 * @descripition
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataConfig.class})
public class TestDao {
    @Autowired
    UserRepository userRepository;
    @Autowired
    @Qualifier("userDaoByEm")
    UserDao userDao;
    @Test
    public void testUserDaoByEm(){
        User user1=userDao.findByUsername("1");
        System.out.println(user1.toString());
        List<User> userList=userRepository.findAll();
//        System.out.println(userList);
        for (User user:userList){
            System.out.println(user.toString());
        }
    }
}
