package config;

import entity.User;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author yan
 * @date 2018/10/10 12:43
 * @descripition
 */
@Configuration
@EnableCaching
@ComponentScan(basePackages = "service")
public class CacheConfig {
    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        JedisConnectionFactory cf=new JedisConnectionFactory();
        cf.afterPropertiesSet();
        //默认配置如下localhost 和6379端口
        cf.setHostName("127.0.0.1");
        cf.setPort(6379);
        return cf;
    }
    @Bean
    public RedisTemplate<String, User>redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<String, User> redis=new RedisTemplate<String, User>();
        redis.setConnectionFactory(connectionFactory);
        redis.afterPropertiesSet();
        return redis;
    }
    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connectionFactory){
        return new StringRedisTemplate(connectionFactory);
    }
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        return new RedisCacheManager(redisTemplate);
    }
}
