package org.geektrust.familytree.relationship.Impl;

import org.geektrust.familytree.relationship.Relationship;
import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.entity.Person;
import org.geektrust.familytree.relationship.RelationshipFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides List of Paternal-Aunts of Given Person in Given Family
 */
public class PaternalAunt implements Relationship {

    @Override
    public String getRelationshipName() {
        return "Paternal-Aunt";
    }

    @Override
    public List<Person> getRelatives(Family family, Person person) {
        if (family.getParentFamily()!=null
                && family.getParentFamily().getFirstPerson().getGender() == Person.Gender.MALE)
            return RelationshipFactory.getInstance().getRelationship("Sister")
                    .getRelatives(family.getParentFamily(), person);
        return new ArrayList<>();
    }

}
