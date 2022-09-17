package com.callor.springbootbook.controller;

import com.callor.springbootbook.model.BookVO;
import com.callor.springbootbook.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class HomeController {
    BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required=false, defaultValue="") String isbn) {
        List<BookVO> bookList = bookService.selectAll();

        Optional<BookVO> book = bookService.findById(isbn);
        log.debug("findByData {}", book);

        BookVO bookVO = book.orElse(new BookVO());

        model.addAttribute("value", bookVO);
        model.addAttribute("BOOKLIST", bookList);
        return "index";
    }

    @PostMapping("/")
    public String home(BookVO bookVO) {
        log.debug("받은 데이터 {}", bookVO);
        bookService.insert(bookVO);
        return "redirect:/";
    }
}
