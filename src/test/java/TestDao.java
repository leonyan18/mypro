import config.CacheConfig;
import config.DataConfig;
import dao.UserRepository;
import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;

import java.util.List;

/**
 * @author yan
 * @date 2018/10/10 19:11
 * @descripition
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataConfig.class, CacheConfig.class})
public class TestDao {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Test
    public void testUserDaoByEm(){
        userService.cacheClear();
        List<User> userList=userService.findAllUser();
        for (User user:userList){
            System.out.println(user.getUsername());
            System.out.println(user.getPhone().size());
        }
        System.out.println("==================================");
        userList=userService.findAllUser();
        for (User user:userList){
            System.out.println(user.getUsername());
        }
        System.out.println("==================================");
    }
    @Test
    public void testUserRepository(){
        User user=userRepository.findByUsername("yan");
        System.out.println(user);
    }
}
