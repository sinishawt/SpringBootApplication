package com.sinishaw.SpringApplication.dao;

import com.sinishaw.SpringApplication.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DataAccessService implements PersonDao {
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> findEveryone() {
        return null;
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public Person update(UUID id, Person person) {
        return null;
    }

    @Override
    public Optional<Person> findPersonById(UUID id) {
        return Optional.empty();
    }
}
