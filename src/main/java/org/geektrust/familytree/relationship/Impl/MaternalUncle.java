package org.geektrust.familytree.relationship.Impl;

import org.geektrust.familytree.relationship.Relationship;
import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.entity.Person;
import org.geektrust.familytree.relationship.RelationshipFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides List of Maternal-Uncles of Given Person in Given Family
 */
public class MaternalUncle implements Relationship {

    @Override
    public String getRelationshipName() {
        return "Maternal-Uncle";
    }

    @Override
    public List<Person> getRelatives(Family family, Person person) {
        if (family.getParentFamily()!=null
                && family.getParentFamily().getFirstPerson().getGender() == Person.Gender.FEMALE)
            return RelationshipFactory.getInstance().getRelationship("Brother")
                    .getRelatives(family.getParentFamily(), person);
        return new ArrayList<>();
    }

}
