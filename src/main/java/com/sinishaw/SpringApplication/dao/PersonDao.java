package com.sinishaw.SpringApplication.dao;

import com.sinishaw.SpringApplication.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> findEveryone();

    int deletePersonById(UUID id);

    Person update(UUID id, Person person);

    Optional<Person> findPersonById(UUID id);
}
