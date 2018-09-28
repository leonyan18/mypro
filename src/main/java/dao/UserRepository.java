package dao;

import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @author yan
 * @date 18-9-27 下午4:29
 * @descripition
 */
public interface UserRepository extends JpaRepository<User,String> {
    /**
     * 通过名字查询
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 通过名字查询并排序
     * @param username
     * @return
     */
    List<User> findByUsernameOrderByUidAsc(String username);
}
