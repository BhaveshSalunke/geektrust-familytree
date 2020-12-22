package org.geektrust.familytree.command.Impl;

import org.geektrust.familytree.command.Command;
import org.geektrust.familytree.command.CommandFactory;
import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.model.FamilyTree;
import org.geektrust.familytree.utility.Initializer;
import org.junit.Assert;
import org.junit.Test;

public class AddChildCommandTest {

    @Test
    public void testAddChildToLikaWithInvalidParameters() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();
        Command command = CommandFactory.getInstance().getCommand("ADD_CHILD");

        //when
        command.execute(familyTree, new String[]{"Lika", "Mika"});

        //then
        Assert.assertNull( familyTree.findPersonByName("Mika") );
    }

    @Test
    public void testAddChildToLika() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();
        Family likaFamily = familyTree.findFamilyByPersonName("Lika");
        Command command = CommandFactory.getInstance().getCommand("ADD_CHILD");

        //when
        command.execute(familyTree, new String[]{"Lika", "Mika", "Male"});

        //then
        Assert.assertNotNull( familyTree.findPersonByName("Mika") );
        Assert.assertEquals(likaFamily, familyTree.findFamilyByPersonName("Mika").getParentFamily());
    }

    @Test
    public void testAddChildToMika() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();
        Command command = CommandFactory.getInstance().getCommand("ADD_CHILD");

        //when
        command.execute(familyTree, new String[]{"Mika", "Sipa", "Female"});

        //then
        Assert.assertNull( familyTree.findPersonByName("Mika") );
    }

    @Test
    public void testAddChildToKingShan() {
        //given
        Initializer initializer = new Initializer();
        FamilyTree familyTree = initializer.initFamilyTreeFromFile();
        Command command = CommandFactory.getInstance().getCommand("ADD_CHILD");

        //when
        command.execute(familyTree, new String[]{"King Shan", "Mika", "Male"});

        //then
        Assert.assertNull( familyTree.findPersonByName("Mika") );
    }
}
