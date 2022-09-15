package com.callor.springbootbook.model;

import lombok.*;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@Entity
@Table(name = "tbl_roles")
public class UserRole {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;
    private String username;
    private String rolename;

    
    /*
    name : UserRole.username 칼럼과
    referencedColumnName : UserVO.username 칼럼을 서로 연결
    insertable = false, updatable = false 이 속성을 false로 선언한 이유 :
    tbl_users 나 tbl_authorities 테이블에 insert나 update가 발생할 경우 동시에 실행하지 말라
    읽기 전용으로만 사용하겠다
     */
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private UserVO userVO;
}
