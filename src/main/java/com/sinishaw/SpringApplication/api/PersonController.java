package com.sinishaw.SpringApplication.api;

import com.sinishaw.SpringApplication.model.Person;
import com.sinishaw.SpringApplication.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @PatchMapping(path = "{id}")
    public Person update(@PathVariable("id") UUID id, @RequestBody Person person){
        return personService.updatePerson(id, person);
    }

    @DeleteMapping(path = "/{id}")
    public int deletePerson(@PathVariable("id") UUID id){
        return personService.deletePerson(id);
    }

    @GetMapping(path = "/{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonByID(id)
                .orElse(null);
    }
}
