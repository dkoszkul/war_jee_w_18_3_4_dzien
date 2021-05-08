package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class Validation2Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(Validation2Controller.class);

    private final Validator validator;

    @Autowired
    public Validation2Controller(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    @ResponseBody
    public String validateBookTest() {
        Book book = new Book();
        book.setRating(8);

        Set<ConstraintViolation<Book>> validate = validator.validate(book);

        if (!validate.isEmpty()) {
            // chcemy wypisać wszystkie błędy walidacji do logów
            for (ConstraintViolation<Book> v : validate) {
                LOGGER.info(v.getMessage() + " -> " + v.getPropertyPath());
            }
        } else {

        }


        return "validationResult";
    }
}
