package com.sb.mybatis.config;

import com.sb.mybatis.persistence.UserDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
//    @Autowired
//    private SqlSessionTemplate sqlSession;
//
//    @Bean
//    public UserDao userDao(){
//        return sqlSession.getMapper(UserDao.class);
//    }
}
