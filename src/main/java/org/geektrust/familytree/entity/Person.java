package org.geektrust.familytree.entity;

import java.util.Objects;

/**
 * Person Entity (individual Person)
 * consist of:
 *      name: Name of Person
 *      gender: Gender of person
 */
public class Person {

    private String name;
    private Gender gender;

    public enum Gender {
        MALE, FEMALE
    }

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }
    
    public String getName() {
        return name;
    }
    
    public Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equalsIgnoreCase(person.name) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }
}
