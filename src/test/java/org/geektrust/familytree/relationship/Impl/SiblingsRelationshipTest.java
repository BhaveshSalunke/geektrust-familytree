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

public class SiblingsRelationshipTest {

    @Test
    public void testSiblibgsOfAsva() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();
        Person person = familyTree.findPersonByName("Asva");
        Family family = familyTree.findFamilyByPersonName(person.getName());
        Relationship relationship = RelationshipFactory.getInstance().getRelationship("Siblings");

        //when
        List<Person> relatives = relationship.getRelatives(family, person);

        //then
        Assert.assertEquals(2, relatives.size());
        Assert.assertTrue( relatives.contains(familyTree.findPersonByName("Vyas")) );
        Assert.assertTrue( relatives.contains(familyTree.findPersonByName("Atya")) );
    }

}
