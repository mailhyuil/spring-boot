package com.callor.springbootbook.repository;

import com.callor.springbootbook.model.BookVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookVO, String> {

}
