package config;

import entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author yan
 * @date 2018/10/10 12:43
 * @descripition
 */
@Configuration
public class CacheConfig {
    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        JedisConnectionFactory cf=new JedisConnectionFactory();
        //默认配置如下localhost 和6379端口
        cf.setHostName("127.0.0.1");
        cf.setPort(6379);
        return cf;
    }
    @Bean
    public RedisTemplate<String, User>redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<String, User> redis=new RedisTemplate<String, User>();
        redis.setConnectionFactory(connectionFactory);
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setValueSerializer(new JacksonJsonRedisSerializer<User>(User.class));
        return redis;
    }
    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connectionFactory){
        return new StringRedisTemplate(connectionFactory);
    }
}
