package trade.axht.springboot.demo.cache.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import trade.axht.springboot.demo.domain.User;

/**
 * 描述:
 * Redis测试
 *
 * @outhor Administrator
 * @create 2017-12-20 20:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test() throws Exception {

        // 保存对象
        User user = new User(1l,"超人", 20);
        redisTemplate.opsForValue().set(user.getName(), JSON.toJSONString(user).toString());

        user = new User(2l,"蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getName(), JSON.toJSONString(user));

        user = new User(3l,"蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getName(), user);

        /*Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());*/
        System.out.println(redisTemplate.opsForValue().get("超人"));
        System.out.println(redisTemplate.opsForValue().get("超人").toString());
        User user1=JSON.parseObject(redisTemplate.opsForValue().get("超人").toString(),User.class);
        System.out.println(user.getName());
    }

    public  void testJsonConvert(){

        JSONObject json = new JSONObject();
    }

}
