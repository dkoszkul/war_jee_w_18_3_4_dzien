package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String helloView() {
        return "index";
    }

    @ModelAttribute("languages")
    public List<String> checkOptions() {
        String[] a = new String[] {"java", "php", "ruby", "python"};
        return Arrays.asList(a);
    }
}
