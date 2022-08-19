package com.callor.springbootbook.service;

import com.callor.springbootbook.model.BookVO;
import com.callor.springbootbook.repository.BookRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookServiceImplTest {

    BookRepository bookRepository;

    public BookServiceImplTest(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Test
    void findById() {
        BookVO res = bookRepository.findById("123123").get();
        assertEquals(new BookVO(
                "123123",
                "미드나잇라이브러리",
                "길벗",
                "하이",
                "2020-09-24",
                20000), res);
    }
}