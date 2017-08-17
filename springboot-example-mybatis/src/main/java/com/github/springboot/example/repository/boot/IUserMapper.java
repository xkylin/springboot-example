package com.github.springboot.example.repository.boot;

import com.github.springboot.example.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserMapper {

    public int insert(User user);

    public int delete(User user);

    public int update(User user);

    public User selectById(Long id);

    public List<User> selectAll();

    public List<User> selectAllByCondition(User user);
}
