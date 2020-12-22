package org.geektrust.familytree.relationship.Impl;

import org.geektrust.familytree.relationship.Relationship;
import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Provides List of Sister-In-Laws of Given Person in Given Family
 */
public class SisterInLaws implements Relationship {

    @Override
    public String getRelationshipName() {
        return "Sister-In-Law";
    }

    @Override
    public List<Person> getRelatives(Family family, Person person) {
        List<Person> sisterInLaws = new ArrayList<>();
        if (family.isMarried() && family.getSpouse().equals(person)) {
            sisterInLaws.addAll( new Sisters().getRelatives(family, person) );
        } else {
            sisterInLaws.addAll(
                    family.getParentFamily().getChildern().stream()
                            .filter(currentFamily -> !currentFamily.equals(family)
                                    && currentFamily.getFirstPerson().getGender() == Person.Gender.MALE
                                    && currentFamily.getSpouse()!=null )
                            .map(Family::getSpouse)
                            .collect(Collectors.toList())
            );
        }
        return sisterInLaws;
    }

}
