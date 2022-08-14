package com.sb.mybatis.persistence;

import com.sb.mybatis.model.UserVO;

import java.util.List;

public interface UserDao {
    public List<UserVO> selectAll();
    public UserVO findById(String username);
    public int insert(UserVO userVO);
    public int update(UserVO userVO);
    public int delete(String username);
}
