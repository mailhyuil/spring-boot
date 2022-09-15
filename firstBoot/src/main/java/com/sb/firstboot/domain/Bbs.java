package com.sb.firstboot.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@Entity
@Table(name = "bbs")
public class Bbs {
    @Id
    private long id;
    private String title;
    private String username;
    private String date;
    private String time;
    private String content;
    private String img;
    private String original_img;
}
