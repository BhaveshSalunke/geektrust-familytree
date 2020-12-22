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

public class BrothersInLawsRelationshipTest {

    @Test
    public void testBrothersInLawsForChitra() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();
        Person person = familyTree.findPersonByName("Chitra");
        Family family = familyTree.findFamilyByPersonName(person.getName());
        Relationship relationship = RelationshipFactory.getInstance().getRelationship("Brother-In-Law");

        //when
        List<Person> relatives = relationship.getRelatives(family, person);

        //then
        Assert.assertEquals(3, relatives.size());
        Assert.assertTrue( relatives.contains(familyTree.findPersonByName("Chit")) );
        Assert.assertTrue( relatives.contains(familyTree.findPersonByName("Ish")) );
        Assert.assertTrue( relatives.contains(familyTree.findPersonByName("Vich")) );
    }

    @Test
    public void testBrothersInLawsForArit() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();
        Person person = familyTree.findPersonByName("Arit");
        Family family = familyTree.findFamilyByPersonName(person.getName());
        Relationship relationship = RelationshipFactory.getInstance().getRelationship("Brother-In-Law");

        //when
        List<Person> relatives = relationship.getRelatives(family, person);

        //then
        Assert.assertEquals(1, relatives.size());
        Assert.assertTrue( relatives.contains(familyTree.findPersonByName("Ahit")) );
    }

    @Test
    public void testBrothersInLawsForTrita() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();
        Person person = familyTree.findPersonByName("Tritha");
        Family family = familyTree.findFamilyByPersonName(person.getName());
        Relationship relationship = RelationshipFactory.getInstance().getRelationship("Brother-In-Law");

        //when
        List<Person> relatives = relationship.getRelatives(family, person);

        //then
        Assert.assertEquals(1, relatives.size());
        Assert.assertTrue( relatives.contains(familyTree.findPersonByName("Jaya")) );
    }

}
