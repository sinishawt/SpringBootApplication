package com.sinishaw.SpringApplication.dao;

import com.sinishaw.SpringApplication.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> person = findPersonById(id);
        if(person.isEmpty()){
            return 0;
        }
         DB.remove(person.get());
        System.out.println("Person Deleted");
        return 1;
    }

    @Override
    public Person update(UUID id, Person person) {
        return findPersonById(id)
                .map(person1 -> {
                    int indexOfPersonToUpdate = DB.indexOf(person1);
                    if (indexOfPersonToUpdate == 0){
                        DB.set(indexOfPersonToUpdate, new Person(id, person.getName()));
                        return person;
                    }
                    return null;
                }).orElse(null);
    }

    @Override
    public Optional<Person> findPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }
}
