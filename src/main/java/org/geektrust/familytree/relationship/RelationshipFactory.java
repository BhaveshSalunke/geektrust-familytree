package org.geektrust.familytree.relationship;

import org.geektrust.familytree.relationship.Impl.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RelationshipFactory {

    private HashMap<String, Relationship> relationshipHashMap;
    private static RelationshipFactory relationshipFactory;

    public static RelationshipFactory getInstance() {
        if (relationshipFactory == null) relationshipFactory = new RelationshipFactory();
        return relationshipFactory;
    }

    private RelationshipFactory() {
        relationshipHashMap = new HashMap<>();

        List<Relationship> relationships = new ArrayList<>();

        relationships.add(new PaternalUncle());
        relationships.add(new MaternalUncle());
        relationships.add(new PaternalAunt());
        relationships.add(new MaternalAunt());
        relationships.add(new SisterInLaws());
        relationships.add(new BrotherInLaws());
        relationships.add(new Brothers());
        relationships.add(new Sisters());
        relationships.add(new Sons());
        relationships.add(new Daughters());
        relationships.add(new Siblings());

        for ( Relationship relationship : relationships )
            relationshipHashMap.put(relationship.getRelationshipName(), relationship);
    }

    public Relationship getRelationship(String relationship) {
        return relationshipHashMap.get(relationship);
    }

}
