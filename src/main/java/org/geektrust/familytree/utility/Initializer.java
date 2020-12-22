package org.geektrust.familytree.utility;

import org.geektrust.familytree.command.Command;
import org.geektrust.familytree.command.CommandFactory;
import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.entity.Person;
import org.geektrust.familytree.model.FamilyTree;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Initializer creates FamilyTree of King Shan Family
 * Note: Only to create FamilyTree given in Problem Statement
 *       Is not unit used anywhere except Application Class
 */
public class Initializer {

    /**
     * Creates King Shan FamilyTree From Provided File
     * @return King Shan's Family Tree
     */
    public FamilyTree initFamilyTreeFromFile() {
        FamilyTree familyTree = null;

        Scanner scanner = new Scanner(this.getClass().getResourceAsStream("/King-Shan-Family.txt"));
        String input = scanner.nextLine();

        familyTree = new FamilyTree( createFamily(input.split(",")) );

        OutputHandler.disablePrint();
        for (String inputCommand = scanner.nextLine();
             inputCommand != null && !inputCommand.isEmpty();
             inputCommand = scanner.hasNext() ? scanner.nextLine() : null) {

            String[] inputs = inputCommand.split(" ");
            Command command = CommandFactory.getInstance().getCommand(inputs[0]);
            inputs = Arrays.copyOfRange(inputs, 1, inputs.length);
            command.execute(familyTree, inputs);

        }
        OutputHandler.enablePrint();

        return familyTree;
    }

    private Family createFamily(String[] inputs) {
        Person.Gender gender = inputs[1].trim().equals("Male") ?
                Person.Gender.MALE : Person.Gender.FEMALE;
        Family family = new Family(new Person(inputs[0].trim(), gender));
        gender = inputs[3].trim().equals("Male") ?
                Person.Gender.MALE : Person.Gender.FEMALE;
        family.weds(new Person(inputs[2].trim(), gender));
        return family;
    }

}
