package com.sb.firstboot.repository;

import com.sb.firstboot.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> selectAll();
    public User findById(String username);
}
