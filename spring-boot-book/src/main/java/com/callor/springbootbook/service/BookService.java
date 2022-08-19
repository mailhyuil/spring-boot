package com.callor.springbootbook.service;

import com.callor.springbootbook.model.BookVO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<BookVO> selectAll();
    /*
    findById는 Optional값을 리턴 .get()으로 뽑아줘야한다.
     */
    public Optional<BookVO> findById(String isbn);
    public int insert(BookVO bookVO);
    public int update(BookVO bookVO);
    public int delete(BookVO bookVO);

    public List<BookVO> findByTitle(String title);
    public List<BookVO> findByComp(String comp);
    public List<BookVO> findByAuthor(String author);
}
