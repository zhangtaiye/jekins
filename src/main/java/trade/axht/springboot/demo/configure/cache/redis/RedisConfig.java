package trade.axht.springboot.demo.configure.cache.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 描述:
 * Redis通用模板操作
 *
 * @outhor Administrator
 * @create 2017-12-20 21:33
 */
@Configuration
public class RedisConfig {

    @Bean
    @Primary
    JedisConnectionFactory jedisConnection(){
        return new JedisConnectionFactory();
    }

    @Bean
    @Primary
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,Object> template=new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnection());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }

    @Bean
    public RedisTemplate<Object,Object> redisTemplate2(RedisConnectionFactory factory){
        RedisTemplate<Object,Object> template=new RedisTemplate<Object, Object>();
        template.setConnectionFactory(jedisConnection());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }

}
