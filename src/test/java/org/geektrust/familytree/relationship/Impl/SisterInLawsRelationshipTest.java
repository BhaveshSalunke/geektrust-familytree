package org.geektrust.familytree.relationship.Impl;

import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.entity.Person;
import org.geektrust.familytree.model.FamilyTree;
import org.geektrust.familytree.relationship.Relationship;
import org.geektrust.familytree.relationship.RelationshipFactory;
import org.geektrust.familytree.utility.Initializer;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SisterInLawsRelationshipTest {

    @Test
    public void testSisterInLawsOfSatya() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();
        Person person = familyTree.findPersonByName("Satya");
        Family family = familyTree.findFamilyByPersonName(person.getName());
        Relationship relationship = RelationshipFactory.getInstance().getRelationship("Sister-In-Law");

        //when
        List<Person> relatives = relationship.getRelatives(family, person);

        //then
        Assert.assertEquals(3, relatives.size());
        Assert.assertTrue( relatives.contains(familyTree.findPersonByName("Chitra")) );
        Assert.assertTrue( relatives.contains(familyTree.findPersonByName("Lika")) );
        Assert.assertTrue( relatives.contains(familyTree.findPersonByName("Amba")) );

    }

    @Test
    public void testSisterInLawsOfJaya() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();
        Person person = familyTree.findPersonByName("Jaya");
        Family family = familyTree.findFamilyByPersonName(person.getName());
        Relationship relationship = RelationshipFactory.getInstance().getRelationship("Sister-In-Law");

        //when
        List<Person> relatives = relationship.getRelatives(family, person);

        //then
        Assert.assertEquals(1, relatives.size());
        Assert.assertTrue( relatives.contains(familyTree.findPersonByName("Tritha")) );

    }

}
