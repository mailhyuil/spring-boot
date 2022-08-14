package com.sb.firstboot.service.impl;

import com.sb.firstboot.domain.User;
import com.sb.firstboot.repository.UserRepository;
import com.sb.firstboot.service.UserService;
import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public int join(User user) throws DuplicateMemberException {

        if(userRepository.findById(user.getUsername()).isEmpty()){
            userRepository.save(user);
        } else {
            throw new DuplicateMemberException("이미 존재하는 회원입니다");
        }
        return 0;
    }

    @Override
    public int login(User user, HttpSession session) {
        Optional<User> foundUser = userRepository.findById(user.getUsername());
        if (foundUser.isPresent() && user.getPassword().equals(foundUser.get().getPassword())) {
            session.setAttribute("USER", foundUser.get());
            return 1;
        }
        return 0;
    }
}
