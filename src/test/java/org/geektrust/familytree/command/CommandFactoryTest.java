package org.geektrust.familytree.command;

import org.geektrust.familytree.command.Impl.AddChildCommand;
import org.geektrust.familytree.command.Impl.GetRelationshipCommand;
import org.geektrust.familytree.command.Impl.WeddingCommand;
import org.junit.Assert;
import org.junit.Test;

public class CommandFactoryTest {

    @Test
    public void testRelationshipFactoryToSingleton() {
        //when
        CommandFactory commandFactory1 = CommandFactory.getInstance();
        CommandFactory commandFactory2 = CommandFactory.getInstance();

        //then
        Assert.assertNotNull(commandFactory1);
        Assert.assertNotNull(commandFactory2);
        Assert.assertEquals(commandFactory1, commandFactory2);
    }

    @Test
    public void testGetRelationshipFromName() {
        //given
        CommandFactory commandFactory = CommandFactory.getInstance();

        //then
        Assert.assertTrue( commandFactory.getCommand("ADD_CHILD") instanceof AddChildCommand);
        Assert.assertTrue( commandFactory.getCommand("GET_RELATIONSHIP") instanceof GetRelationshipCommand);
        Assert.assertTrue( commandFactory.getCommand("PERFORM_WEDDING") instanceof WeddingCommand);
        Assert.assertNull( commandFactory.getCommand("") );
    }
}
