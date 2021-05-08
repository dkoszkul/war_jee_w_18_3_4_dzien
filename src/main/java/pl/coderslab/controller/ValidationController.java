package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


@Controller
public class ValidationController {
    private static final Logger logger = LoggerFactory.getLogger(ValidationController.class);

    private final Validator validator;

    @Autowired
    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate2")
    public String validateMe(Model model) {
        Book book = new Book();
        book.setPages(1);
        book.setPublisher(new Publisher());


        Set<ConstraintViolation<Book>> violations = validator.validate(book);


        model.addAttribute("violations", violations);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                logger.debug(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }
        } else {
            // save object
        }
        return "validation";
    }
}
