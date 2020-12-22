package org.geektrust.familytree.relationship.Impl;

import org.geektrust.familytree.relationship.Relationship;
import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Provides List of Sisters of Given Person in Given Family
 */
public class Sisters implements Relationship {

    @Override
    public String getRelationshipName() {
        return "Sister";
    }

    @Override
    public List<Person> getRelatives(Family family, Person person) {
        List<Person> sisters = new ArrayList<>();

        if( family==null || family.getParentFamily()==null) return sisters;

        sisters.addAll(
                family.getParentFamily().getChildern().stream()
                        .filter(currentFamily -> !currentFamily.equals(family)
                                && currentFamily.getFirstPerson().getGender() == Person.Gender.FEMALE )
                        .map(Family::getFirstPerson)
                        .collect(Collectors.toList())
        );

        return sisters;
    }

}
