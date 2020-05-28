package kr.re.kitri.hello.dao;

import kr.re.kitri.hello.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    void insertUser(User user);
}
