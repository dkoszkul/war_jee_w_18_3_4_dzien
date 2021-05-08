package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;
import pl.coderslab.repository.BookRepository;

import java.util.List;

@Controller
public class BookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books/list/test")
    @ResponseBody
    public String testFindAll() {
//        List<Book> result = bookRepository.findAll();
//        result.forEach(book -> LOGGER.info(book + ""));

        List<Book> result = bookRepository.findByTitle("Title 1981830572");
        LOGGER.info(result.size() + "");
        return "ok";
    }
}
