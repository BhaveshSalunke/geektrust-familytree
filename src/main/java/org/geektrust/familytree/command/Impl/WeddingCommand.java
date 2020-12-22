package org.geektrust.familytree.command.Impl;

import org.geektrust.familytree.command.Command;
import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.entity.Person;
import org.geektrust.familytree.model.FamilyTree;
import org.geektrust.familytree.utility.OutputHandler;

/**
 * Performs marriage and adds given person
 * as spouse to given Family
 * NOTE: This Command is used only for seed initialization
 */
public class WeddingCommand implements Command {
    @Override
    public String getCommandName() {
        return "PERFORM_WEDDING";
    }

    /**
     * Adds person as spouse to Family
     * @param familyTree FamilyTree to operate on
     * @param inputs String[] of inputs
     * @return Status of Wedding
     */
    @Override
    public String execute(FamilyTree familyTree, String[] inputs) {
        String result = "";

        if(inputs.length<3) {
            result = "INVALID_COMMAND_ARGUMENTS";
            OutputHandler.print(result);
            return result;
        }

        Person firstPerson = familyTree.findPersonByName( inputs[0] );

        if (firstPerson != null) {
            Family family = familyTree.findFamilyByPersonName(firstPerson.getName());
            Person.Gender gender = (inputs[2].equals("Male")) ? Person.Gender.MALE : Person.Gender.FEMALE;
            family.weds( new Person(inputs[1], gender) );
            result = "WEDDING_SUCCEEDED";
        }

        else result = "PERSON_NOT_FOUND";

        OutputHandler.print(result);
        return result;
    }
}
