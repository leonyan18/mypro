package dao;

import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * @author yan
 * @date 18-9-27 下午4:29
 * @descripition
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * 通过名字查询
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 查询通过名字排序
     * @return
     */
    @Query("FROM User ORDER BY username")
    List<User> findAll();
}
