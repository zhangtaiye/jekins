package trade.axht.springboot.demo.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trade.axht.springboot.demo.domain.User;

@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User,Long> {

    @Cacheable
    User findByName(String name);

    User findByNameAndAge(String name,Integer age);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
}
