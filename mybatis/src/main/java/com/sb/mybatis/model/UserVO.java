package com.sb.mybatis.model;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserVO {
    private String username;
    private String password;
    private String realname;
    private String nickname;
}
