package com.sb.firstboot.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String password;
    private String realname;
    private String nickname;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Bbs> bbs = new ArrayList<>();
}
