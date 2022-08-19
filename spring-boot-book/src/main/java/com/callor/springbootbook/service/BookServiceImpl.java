package com.callor.springbootbook.service;

import com.callor.springbootbook.model.BookVO;
import com.callor.springbootbook.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Savepoint;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookVO> selectAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<BookVO> findById(String isbn) {
        return bookRepository.findById(isbn);
    }

    @Override
    public int insert(BookVO bookVO) {
        /*
        mybatis에서는 insert를 수행한 후 int값을 return
        이때 return 값은 몇개의 데이터가 추가되었는지 알려주는 지표

        하지만 spring-data에서는 save를 실행한 후 다시 자기 자신을 return
         */
        if(bookRepository.findById(bookVO.getIsbn()).isPresent()){
            throw new DuplicateKeyException("이미 등록된 책입니다");
        }
        BookVO res = bookRepository.save(bookVO);
        return 0;
    }

    @Override
    public int update(BookVO bookVO) {
        if(bookRepository.findById(bookVO.getIsbn()).isEmpty()){
            throw new DuplicateKeyException("등록되지 않은 책입니다");
        }
        bookRepository.save(bookVO);
        return 0;
    }

    @Override
    public int delete(BookVO bookVO) {
        return 0;
    }

    @Override
    public List<BookVO> findByTitle(String title) {
        return null;
    }

    @Override
    public List<BookVO> findByComp(String comp) {
        return null;
    }

    @Override
    public List<BookVO> findByAuthor(String author) {
        return null;
    }
}
