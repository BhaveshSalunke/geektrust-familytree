package org.geektrust.familytree;

import org.geektrust.familytree.command.Command;
import org.geektrust.familytree.command.CommandFactory;
import org.geektrust.familytree.model.FamilyTree;
import org.geektrust.familytree.utility.Initializer;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Initializer initializer = new Initializer();
        FamilyTree kingShanFamilyTree = initializer.initFamilyTreeFromFile();

        if (args.length < 1) {
            System.out.println("Invalid Execution! Please specify Input File Path");
            return;
        }

        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));

            for (String inputCommand = scanner.nextLine();
                 inputCommand != null && !inputCommand.isEmpty();
                 inputCommand = scanner.hasNext() ? scanner.nextLine() : null) {

                String[] inputs = inputCommand.split(" ");
                Command command = CommandFactory.getInstance().getCommand(inputs[0]);
                inputs = Arrays.copyOfRange(inputs, 1, inputs.length);
                command.execute(kingShanFamilyTree, inputs);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
