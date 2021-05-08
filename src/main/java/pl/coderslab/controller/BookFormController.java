package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.BookRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("books")
public class BookFormController {

    private final BookRepository bookRepository;
    private final PublisherDao publisherDao;

    @Autowired
    public BookFormController(BookRepository bookRepository, PublisherDao publisherDao) {
        this.bookRepository = bookRepository;
        this.publisherDao = publisherDao;
    }

    @ModelAttribute("publishers")
    public List<Publisher> publisherList(){

        List<Book> allBooks = bookRepository.findAll();

        return publisherDao.findAll();
    }

    @GetMapping("add")
    public String createNewBook(Model model) {
        Book book = new Book();
        book.setPublisher(new Publisher());
        model.addAttribute("book", book);
        return "newBookForm";
    }

    @PostMapping("add")
    public String addNewBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "newBookForm";
        }
        return "redirect:/success";
    }

    @GetMapping("testAdd")
    @ResponseBody
    public String addNewBookTest() {
        Book book = new Book();
        book.setTitle("Title " + new Random().nextInt());
        book.setPages(2);
        book.setDescription("sfdsf");
        book.setRating(4);

        Publisher publisher = new Publisher();
        publisher.setName("Name");
        book.setPublisher(publisher);
//
//        List<Book> name = bookRepository.findByPublisherName("Name");
//        System.out.println(name.size());

        return bookRepository.save(book).getId().toString();
    }
}
