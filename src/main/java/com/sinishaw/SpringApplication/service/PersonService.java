package com.sinishaw.SpringApplication.service;

import com.sinishaw.SpringApplication.dao.PersonDao;
import com.sinishaw.SpringApplication.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonDao personDao;
    @Autowired
    public PersonService(@Qualifier("personDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getPersons(){
        return personDao.findEveryone();
    }
}
