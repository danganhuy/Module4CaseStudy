package huy.module4casestudy.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coach")
@CrossOrigin("*")
public class CoachController {
    @GetMapping("")
    public String coach() {
        return "coach";
    }
}
