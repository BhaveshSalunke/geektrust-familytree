package org.geektrust.familytree.relationship.Impl;

import org.geektrust.familytree.relationship.Relationship;
import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Provides List of Brother-In-Laws of Given Person in Given Family
 */
public class BrotherInLaws implements Relationship {

    @Override
    public String getRelationshipName() {
        return "Brother-In-Law";
    }

    @Override
    public List<Person> getRelatives(Family family, Person person) {
        List<Person> brotherInLaws = new ArrayList<>();
        if ( family.isMarried() && family.getSpouse().equals(person) ) {
            brotherInLaws.addAll( new Brothers().getRelatives(family, family.getFirstPerson()) );
        } else {
            brotherInLaws.addAll(
                family.getParentFamily().getChildern().stream()
                    .filter(currentFamily -> !currentFamily.equals(family)
                            && currentFamily.getFirstPerson().getGender() == Person.Gender.FEMALE
                            && currentFamily.getSpouse()!=null )
                    .map(Family::getSpouse)
                    .collect(Collectors.toList())
            );
        }
        return brotherInLaws;
    }

}
