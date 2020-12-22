package org.geektrust.familytree.command;

import org.geektrust.familytree.command.Impl.AddChildCommand;
import org.geektrust.familytree.command.Impl.GetRelationshipCommand;
import org.geektrust.familytree.command.Impl.WeddingCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Manages the Command Objects
 * by creating a HashMap of CommandName key, CommandObject value
 */
public class CommandFactory {

    private HashMap<String, Command> commandHashMap;
    private static CommandFactory commandFactory;

    private CommandFactory() {
        commandHashMap = new HashMap<>();

        List<Command> commands = new ArrayList<>();

        commands.add(new AddChildCommand());
        commands.add(new GetRelationshipCommand());
        commands.add(new WeddingCommand());

        for (Command command : commands)
            commandHashMap.put(command.getCommandName(), command);
    }

    /**
     * Provides Singleton Instance for CommandFactory
     * @return CommandFactory Object
     */
    public static CommandFactory getInstance() {
        if (commandFactory==null) commandFactory = new CommandFactory();
        return commandFactory;
    }

    /**
     * Returns Command Object for given Command Name
     * @param commandName name of command
     * @return Command Object
     */
    public Command getCommand(String commandName) {
        return commandHashMap.get(commandName);
    }
}
