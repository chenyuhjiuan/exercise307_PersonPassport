package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String index(Model model){
        Person person = new Person();
        person.setName("Nancy Bullock");
        person.setBirthday("01-01-1996");
        Passport passport= new Passport();

        passport.setSsn("200-22-2222");
        person.setPassport(passport);
        personRepository.save(person);

        model.addAttribute("persons",personRepository.findAll());
        return "index";
    }
}
