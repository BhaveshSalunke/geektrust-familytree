package org.geektrust.familytree.model;

import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.entity.Person;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Tree Model of a Family
 */
public class FamilyTree {

    private Family head;

    /**
     * Creates FamilyTree with given family as Head family
     * @param head Family as Head of this Tree
     */
    public FamilyTree(Family head) {
        this.head = head;
    }

    public Family getHead() {
        return this.head;
    }

    /**
     * Gives a Family in FamilyTree having person of given name
     * @param personName Person name to search
     * @return Family search result
     */
    public Family findFamilyByPersonName(String personName) {
        Queue<Family> bfsQueue = new LinkedList<>();
        bfsQueue.add(head);

        while( !bfsQueue.isEmpty() ) {
            Family currentFamily = bfsQueue.remove();
            if ( currentFamily.getFirstPerson().getName().equalsIgnoreCase(personName)
                   || ( currentFamily.getSpouse()!=null
                        && currentFamily.getSpouse().getName().equalsIgnoreCase(personName) ) )
                return currentFamily;
            else bfsQueue.addAll(currentFamily.getChildern());
        }

        return null;
    }

    /**
     * Gives a Person in FamilyTree having person of given name
     * @param personName Person name to search
     * @return Person search result
     */
    public Person findPersonByName(String personName) {
        Queue<Family> bfsQueue = new LinkedList<>();
        bfsQueue.add(head);

        while( !bfsQueue.isEmpty() ) {
            Family currentFamily = bfsQueue.remove();
            if ( currentFamily.getFirstPerson().getName().equalsIgnoreCase(personName)
                    || ( currentFamily.getFirstPerson().getName().contains(personName) ) )
                return currentFamily.getFirstPerson();
            else if ( ( currentFamily.getSpouse()!=null
                    && ( currentFamily.getSpouse().getName().equalsIgnoreCase(personName)
                    ||  currentFamily.getSpouse().getName().contains(personName) ) ) )
                return currentFamily.getSpouse();
            else bfsQueue.addAll(currentFamily.getChildern());
        }

        return null;
    }
}
