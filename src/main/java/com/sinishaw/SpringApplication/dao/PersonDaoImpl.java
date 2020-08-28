package com.sinishaw.SpringApplication.dao;

import com.sinishaw.SpringApplication.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> findEveryone(){
        return DB;
    }
}
