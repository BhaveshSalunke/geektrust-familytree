package org.geektrust.familytree.command.Impl;

import org.geektrust.familytree.command.Command;
import org.geektrust.familytree.command.CommandFactory;
import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.entity.Person;
import org.geektrust.familytree.model.FamilyTree;
import org.junit.Assert;
import org.junit.Test;

public class WeddingCommandTest {

    @Test
    public void testPerformWeddingWithInvalidArguments() {
        //given
        Person kingShan = new Person("King Shan", Person.Gender.MALE);
        FamilyTree familyTree = new FamilyTree(new Family(kingShan));
        Command command = CommandFactory.getInstance().getCommand("PERFORM_WEDDING");

        //when
        String output = command.execute(familyTree, new String[]{"King Shan", "Queen Agna"});

        //then
        Assert.assertEquals("INVALID_COMMAND_ARGUMENTS", output);
    }

    @Test
    public void testKingShanWedsToQueenAgna() {
        //given
        Person kingShan = new Person("King Shan", Person.Gender.MALE);
        FamilyTree familyTree = new FamilyTree(new Family(kingShan));
        Command command = CommandFactory.getInstance().getCommand("PERFORM_WEDDING");

        //when
        String output = command.execute(familyTree, new String[]{"King Shan", "Queen Agna", "Female"});

        //then
        Assert.assertNotNull(familyTree.getHead().getSpouse());
        Assert.assertEquals("WEDDING_SUCCEEDED", output);
        Assert.assertEquals("Queen Agna", familyTree.getHead().getSpouse().getName());
    }

    @Test
    public void testQueenAgnaWedsToUnknownPerson() {
        //given
        Person kingShan = new Person("King Shan", Person.Gender.MALE);
        FamilyTree familyTree = new FamilyTree(new Family(kingShan));
        Command command = CommandFactory.getInstance().getCommand("PERFORM_WEDDING");

        //when
        String output = command.execute(familyTree, new String[]{"Arit", "Queen Agna", "Female"});

        //then
        Assert.assertEquals("PERSON_NOT_FOUND", output);
    }

}