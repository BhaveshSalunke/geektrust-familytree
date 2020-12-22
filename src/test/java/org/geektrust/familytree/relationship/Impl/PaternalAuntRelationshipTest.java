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

public class PaternalAuntRelationshipTest {

    @Test
    public void testPaternalAuntOfAhit() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();
        Person person = familyTree.findPersonByName("Ahit");
        Family family = familyTree.findFamilyByPersonName(person.getName());
        Relationship relationship = RelationshipFactory.getInstance().getRelationship("Paternal-Aunt");

        //when
        List<Person> relatives = relationship.getRelatives(family, person);

        //then
        Assert.assertEquals(1, relatives.size());
        Assert.assertTrue( relatives.contains(familyTree.findPersonByName("Satya")) );
    }

    @Test
    public void testPaternalAuntOfKingShan() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();
        Person person = familyTree.findPersonByName("KING SHAN");
        Family family = familyTree.findFamilyByPersonName(person.getName());
        Relationship relationship = RelationshipFactory.getInstance().getRelationship("Paternal-Aunt");

        //when
        List<Person> relatives = relationship.getRelatives(family, person);

        //then
        Assert.assertEquals(0, relatives.size());
    }

}
