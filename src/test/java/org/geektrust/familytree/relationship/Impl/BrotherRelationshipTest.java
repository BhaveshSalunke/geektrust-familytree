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

public class BrotherRelationshipTest {

    @Test
    public void testGetBrothersOfChit() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();
        Person person = familyTree.findPersonByName("Chit");
        Family family = familyTree.findFamilyByPersonName(person.getName());
        Relationship relationship = RelationshipFactory.getInstance().getRelationship("Brother");

        //when
        List<Person> relatives = relationship.getRelatives(family, person);

        //then
        Assert.assertNotNull(relatives);
        Assert.assertEquals(3, relatives.size());
        Assert.assertTrue( relatives.contains(familyTree.findPersonByName("Ish")) );
        Assert.assertTrue( relatives.contains(familyTree.findPersonByName("Vich")) );
        Assert.assertTrue( relatives.contains(familyTree.findPersonByName("Aras")) );
    }

}
