package org.geektrust.familytree.command;

import org.geektrust.familytree.model.FamilyTree;

/**
 * Defines how commands are implemented
 */
public interface Command {

    /**
     * Gives name of command
     * @return String name of command
     */
    String getCommandName();

    /**
     * Operates of FamilyTree with given inputs
     * @param familyTree FamilyTree to operate on
     * @param inputs String[] of inputs
     * @return resulting string
     */
    String execute(FamilyTree familyTree, String[] inputs);

}
