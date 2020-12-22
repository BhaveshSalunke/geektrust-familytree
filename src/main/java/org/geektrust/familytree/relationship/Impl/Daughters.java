package org.geektrust.familytree.relationship.Impl;

import org.geektrust.familytree.relationship.Relationship;
import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Provides List of Daughters of Given Person in Given Family
 */
public class Daughters implements Relationship {

    @Override
    public String getRelationshipName() {
        return "Daughter";
    }

    @Override
    public List<Person> getRelatives(Family family, Person person) {
        List<Person> daughters = new ArrayList<>();

        if( family==null ) return daughters;

        daughters.addAll(
                family.getChildern().stream()
                        .filter(currentFamily -> !currentFamily.equals(family)
                                && currentFamily.getFirstPerson().getGender() == Person.Gender.FEMALE)
                        .map(Family::getFirstPerson)
                        .collect(Collectors.toList())
        );

        return daughters;
    }

}
