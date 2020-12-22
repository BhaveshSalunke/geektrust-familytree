package org.geektrust.familytree.relationship.Impl;

import org.geektrust.familytree.relationship.Relationship;
import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Provides List of Siblings of Given Person in Given Family
 */
public class Siblings implements Relationship {

    @Override
    public String getRelationshipName() {
        return "Siblings";
    }

    @Override
    public List<Person> getRelatives(Family family, Person person) {
        List<Person> siblings = new ArrayList<>();

        if( family==null || family.getParentFamily()==null) return siblings;

        siblings.addAll(
                family.getParentFamily().getChildern().stream()
                .map(Family::getFirstPerson)
                .collect(Collectors.toList())
        );
        siblings.remove(person);

        return siblings;
    }

}
