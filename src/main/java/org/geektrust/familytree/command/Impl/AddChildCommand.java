package org.geektrust.familytree.command.Impl;

import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.entity.Person;
import org.geektrust.familytree.model.FamilyTree;
import org.geektrust.familytree.command.Command;
import org.geektrust.familytree.utility.OutputHandler;

/**
 * Adds New Child Family to FamilyTree using Mother's Name
 */
public class AddChildCommand implements Command {

    @Override
    public String getCommandName() {
        return "ADD_CHILD";
    }

    /**
     * @param familyTree FamilyTree to operate on
     * @param inputs String[] of inputs
     * @return Status of Addition operation
     */
    @Override
    public String execute(FamilyTree familyTree, String[] inputs) {
        String result;

        if(inputs.length<3) {
            result = "INVALID_COMMAND_ARGUMENTS";
            OutputHandler.print(result);
            return result;
        }

        Person mother = familyTree.findPersonByName( inputs[0] );

        if ( mother!= null ) {
            if ( mother.getGender() == Person.Gender.FEMALE ) {
                Family family = familyTree.findFamilyByPersonName(mother.getName());
                Person.Gender gender = (inputs[2].equals("Male")) ? Person.Gender.MALE : Person.Gender.FEMALE;
                addChildToFamily(family, new Person(inputs[1], gender));
                result = "CHILD_ADDITION_SUCCEEDED";
            }
            else result = "CHILD_ADDITION_FAILED";
        }

        else result = "PERSON_NOT_FOUND";

        OutputHandler.print(result);
        return result;
    }

    private void addChildToFamily(Family family, Person person) {
        Family childFamily = new Family(person);
        childFamily.ancestorOf(family);
        family.getChildern().add(childFamily);
    }
}
