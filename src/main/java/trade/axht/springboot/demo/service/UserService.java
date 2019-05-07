package trade.axht.springboot.demo.service;

public interface UserService {
    /**
     * 新增一个用户
     * @param name 用户名称
     * @param age 用户年龄
     */
    void create(String name,Integer age);

    /**
     * 根据用户name删除一个用户
     * @param name 用户名
     */
    void deleteByName(String name);

    /**
     * 获取用户总数
     * @return
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

}
