package trade.axht.springboot.demo.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import trade.axht.springboot.demo.domain.User;
import trade.axht.springboot.demo.repository.UserRepository;
import trade.axht.springboot.demo.service.UserService;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    private MockMvc mvc;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp(){
        mvc= MockMvcBuilders.standaloneSetup(new UserController()).build();
        userService.deleteAllUsers();
    }

    @Test
    public void testUserController() throws Exception {
        RequestBuilder request=null;
        request=get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));

        request=post("/users/")
                    .param("id","1")
                    .param("name","测试大师")
                    .param("age","23");
        mvc.perform(request).andExpect(status().isOk())
                            .andExpect(content().string(equalTo("success")));


    }

    @Test
    public void testJdbcTemplate(){
        userService.create("张三丰",24);
        userService.create("黄飞鸿",27);
        userService.create("李白",35);
        userService.create("张姐",19);
        userService.create("小龙女",18);

        Assert.assertEquals(5,userService.getAllUsers().intValue());

        userService.deleteByName("张姐");
        userService.deleteByName("小龙女");
        Assert.assertEquals(3,userService.getAllUsers().intValue());

    }

    @Test
    public void testSpringDataJpa(){
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGG", 70));
        userRepository.save(new User("HHH", 80));
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));

        Assert.assertEquals(10,userRepository.findAll().size());
        //测试findByName，查询姓名为FFF的User
        Assert.assertEquals(60,userRepository.findByName("FFF").getAge().longValue());
        //测试findUser,查询姓名为FFF的User
        Assert.assertEquals(60,userRepository.findUser("FFF").getAge().longValue());
        //测试findByNameAndAge，查询姓名为FFF且年龄为60的User
        Assert.assertEquals("FFF",userRepository.findByNameAndAge("FFF",60).getName());
        //测试删除姓名为AAA的User
        userRepository.delete(userRepository.findByName("AAA"));
        //测试findAll,查询所有记录，验证上面的删除是否成功
        Assert.assertEquals(9,userRepository.findAll().size());


    }


}
