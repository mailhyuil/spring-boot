package com.callor.springbootbook.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.border.TitledBorder;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_books", schema = "bootdb")
public class BookVO {
    @Id
    @Column(length = 13)
    private String isbn;

    @Column(length = 125, nullable = false)
    private String title;

    private String comp;
    private String author;

    @Column(length = 25)
    private String pubdate;

    @Column(nullable = true)
    private int price;
}
