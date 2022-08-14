package com.sb.mybatis.service;

import com.sb.mybatis.model.UserVO;
import com.sb.mybatis.persistence.UserDao;

public interface UserService {
    public UserVO findSB(String username);
}
