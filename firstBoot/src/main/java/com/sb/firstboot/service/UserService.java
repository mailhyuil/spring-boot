package com.sb.firstboot.service;

import com.sb.firstboot.domain.User;
import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;

import javax.servlet.http.HttpSession;

public interface UserService {
    public int join(User user) throws DuplicateMemberException;
    public int login(User user, HttpSession session);

}
