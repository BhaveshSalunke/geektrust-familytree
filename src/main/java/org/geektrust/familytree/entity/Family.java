package org.geektrust.familytree.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Family Entity (individual Family)
 * consist of:
 *      firstPerson: Person, with direct relation in FamilyTree
 *      spouse: Person, married to firstPerson
 *      children: List of Family, who are children
 *      parentFamily: Family, Parents to this family
 */
public class Family {

    private Person firstPerson;
    private Person spouse;
    private List<Family> children;
    private Family parentFamily;

    public Family(Person firstPerson) {
        this.firstPerson = firstPerson;
        this.children = new ArrayList<>();
    }

    public Family(Person firstPerson, Person spouse) {
        this.firstPerson = firstPerson;
        this.spouse = spouse;
        this.children = new ArrayList<>();
    }

    public Person getFirstPerson() {
        return firstPerson;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void weds(Person spouse) {
        this.spouse = spouse;
    }

    public List<Family> getChildern() {
        return children;
    }

    public Family getParentFamily() {
        return parentFamily;
    }

    public void ancestorOf(Family parentFamily) {
        this.parentFamily = parentFamily;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(firstPerson, family.firstPerson) &&
                Objects.equals(spouse, family.spouse) &&
                Objects.equals(parentFamily, family.parentFamily);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPerson, spouse, parentFamily);
    }

    public boolean isMarried() {
        return spouse!=null;
    }
}
