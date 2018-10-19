import config.CacheConfig;
import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yan
 * @date 2018/10/10 18:35
 * @descripition
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CacheConfig.class)
public class TestRedis {
    @Autowired
    RedisTemplate<String, User> redisTemplate;
    @Test
    public void redisInsert(){
        User user=new User();
        user.setAuthority(true);
        user.setUid(1);
        user.setUsername("yan");
        user.setPassword("132156");
        redisTemplate.opsForValue().set("first2",user);
        System.out.println(redisTemplate.opsForValue().get("first2").getUsername());
    }
}
