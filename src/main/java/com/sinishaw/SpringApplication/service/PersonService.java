package com.sinishaw.SpringApplication.service;

import com.sinishaw.SpringApplication.dao.PersonDao;
import com.sinishaw.SpringApplication.model.Person;
import com.sinishaw.SpringApplication.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

//    private final PersonDao personDao;
//    @Autowired
//    public PersonService(@Qualifier("personDao") PersonDao personDao) {
//        this.personDao = personDao;
//    }
    @Autowired
    private PersonRepository personRepository;

    public Person addPerson(Person person){
        //return personDao.insertPerson(person);
        return personRepository.save(person);

    }

    public Iterable<Person> getPersons(){
        return personRepository.findAll();
    }

//    public Optional<Person> getPersonByID(UUID id){
//        return personDao.findPersonById(id);
//    }
//
//    public Person updatePerson(UUID id, Person person){
//        return personDao.update(id, person);
//    }
//
//    public int deletePerson(UUID id){
//        return personDao.deletePersonById(id);
//    }
}
