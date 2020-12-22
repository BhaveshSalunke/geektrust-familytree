package org.geektrust.familytree.command.Impl;

import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.relationship.Relationship;
import org.geektrust.familytree.entity.Person;
import org.geektrust.familytree.model.FamilyTree;
import org.geektrust.familytree.command.Command;
import org.geektrust.familytree.utility.OutputHandler;
import org.geektrust.familytree.relationship.RelationshipFactory;

import java.util.List;

/**
 * Traverses through FamilyTree to get relatives
 * for given relation and given person
 */
public class GetRelationshipCommand implements Command {

    @Override
    public String getCommandName() {
        return "GET_RELATIONSHIP";
    }

    /**
     * @param familyTree FamilyTree to operate on
     * @param inputs String[] of inputs
     * @return String of result of person names
     */
    @Override
    public String execute(FamilyTree familyTree, String[] inputs) {
        if (inputs.length<2) {
            OutputHandler.print("INVALID_COMMAND_ARGUMENTS");
            return "INVALID_COMMAND_ARGUMENTS";
        }

        Person person = familyTree.findPersonByName(inputs[0]);
        StringBuilder result = new StringBuilder("NONE");

        if ( person!=null ) {
            Relationship relationship = RelationshipFactory.getInstance().getRelationship(inputs[1]);
            Family family = familyTree.findFamilyByPersonName(person.getName());
            List<Person> relatives = relationship.getRelatives(family, person);

            if (relatives.size() > 0) result = new StringBuilder();
            for (Person currentPerson : relatives) result.append(currentPerson.getName()).append(" ");
            result = new StringBuilder(result.toString().trim());
        }

        else result = new StringBuilder("PERSON_NOT_FOUND");

        OutputHandler.print(result.toString());
        return result.toString();
    }

}
