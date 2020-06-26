package com.test.example;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class, name = "DOG"),
        @JsonSubTypes.Type(value = Cat.class, name = "CAT")
})
public class Animal {
    protected String type;
}

class Dog extends Animal {

    Dog() {
        type = "DOG";
    }
}

class Cat extends Animal {

    Cat() {
        type = "CAT";
    }
}

class Zoo {
    public Animal animal;
}
