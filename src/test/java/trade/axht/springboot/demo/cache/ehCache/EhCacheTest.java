package trade.axht.springboot.demo.cache.ehCache;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import trade.axht.springboot.demo.domain.User;
import trade.axht.springboot.demo.repository.UserRepository;

/**
 * 描述:
 * EhCache缓存
 *
 * @outhor Administrator
 * @create 2018-01-05 20:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EhCacheTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void before(){
        userRepository.deleteAll();
        userRepository.save(new User("AaaaAA",10));
    }

    @Test
    public void testEhCache(){
        System.out.println(cacheManager);
        User user=userRepository.findByName("AaaaAA");
        System.out.println("第一次查询："+user.getAge());

        User user2=userRepository.findByName("AaaaAA");
        System.out.println("第二次查询："+user2.getAge());
    }
}
