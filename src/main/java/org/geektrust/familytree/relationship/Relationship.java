package org.geektrust.familytree.relationship;


import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.entity.Person;

import java.util.List;

/**
 * Relationship Interface
 * provides Behaviour of traversal through Family
 */
public interface Relationship {

    /**
     * Gives name of relationship
     * @return String relationship name
     */
    String getRelationshipName();

    /**
     * Traverses through families for finding relatives of given Person
     * and populates result in a Person List
     * @param family Family to traverse through
     * @param person Person to search Relatives for
     * @return List of Person who are relatives of Given Person in this relation
     */
    List<Person> getRelatives(Family family, Person person);

}
