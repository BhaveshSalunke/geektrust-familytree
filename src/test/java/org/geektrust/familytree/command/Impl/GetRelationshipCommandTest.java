package org.geektrust.familytree.command.Impl;

import org.geektrust.familytree.command.Command;
import org.geektrust.familytree.command.CommandFactory;
import org.geektrust.familytree.model.FamilyTree;
import org.geektrust.familytree.utility.Initializer;
import org.junit.Assert;
import org.junit.Test;

public class GetRelationshipCommandTest {

    @Test
    public void testGetRelativesWithInvalidParameters() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();

        //when
        Command command = CommandFactory.getInstance().getCommand("GET_RELATIONSHIP");
        String output = command.execute(familyTree, new String[]{"Lika"});

        //then
        Assert.assertEquals("INVALID_COMMAND_ARGUMENTS", output);
    }

    @Test
    public void testGetRelativesOfUnknownPerson() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();

        //when
        Command command = CommandFactory.getInstance().getCommand("GET_RELATIONSHIP");
        String output = command.execute(familyTree, new String[]{"Mika", "Siblings"});

        //then
        Assert.assertEquals("PERSON_NOT_FOUND", output);
    }

    @Test
    public void testGetRelativesOfKnownPerson() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();

        //when
        Command command = CommandFactory.getInstance().getCommand("GET_RELATIONSHIP");
        String output = command.execute(familyTree, new String[]{"King Shan", "Son"});

        //then
        Assert.assertEquals("Chit Ish Vich Aras", output);
    }
}
