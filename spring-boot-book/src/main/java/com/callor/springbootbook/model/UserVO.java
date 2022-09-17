package com.callor.springbootbook.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@Entity
@Table(name = "tbl_users")
public class UserVO implements UserDetails {
    @Id
    private String username;
    private String password;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;

    @Transient
    Collection<? extends GrantedAuthority> authorities;

    @OneToMany(mappedBy = "userVO", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<UserRole> userRoles;


}
