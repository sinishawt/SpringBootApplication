package com.sinishaw.SpringApplication.api;

import com.sinishaw.SpringApplication.model.Person;
import com.sinishaw.SpringApplication.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
        System.out.println("Person Added");
    }

    @GetMapping
    public List<Person> getAllPersons(){
       return personService.getPersons();
        
    }
}
