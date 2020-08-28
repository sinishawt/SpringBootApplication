package com.sinishaw.SpringApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Person {

    @Id
    private UUID id;
    @NonNull
    private String name;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public Person(){

    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
