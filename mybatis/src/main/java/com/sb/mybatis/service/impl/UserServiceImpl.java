package com.sb.mybatis.service.impl;

import com.sb.mybatis.model.UserVO;
import com.sb.mybatis.persistence.UserDao;
import com.sb.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserVO findSB(String username) {
        return userDao.findById(username);
    }
}
