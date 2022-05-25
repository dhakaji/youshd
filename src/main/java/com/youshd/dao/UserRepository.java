package com.youshd.dao;

import com.youshd.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
//    void deleteAllByUserIdBefore(int userId);
    List<User> findByUserName(String userName);
}
