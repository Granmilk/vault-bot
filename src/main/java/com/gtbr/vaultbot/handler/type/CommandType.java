package com.gtbr.vaultbot.handler.type;

import lombok.Getter;

import com.gtbr.vaultbot.exception.CommandNotFoundException;

import java.util.Arrays;

@Getter
public enum CommandType {
    USER(),
    VAULT();

    private final String[] commands;

    CommandType(String... commands) {
        this.commands = commands;
    }

    public static CommandType typeFor(String commandFromMessage) {
        for (CommandType value : CommandType.values()) {
            if (Arrays.stream(value.getCommands()).anyMatch(command -> command.equalsIgnoreCase(commandFromMessage)))
                return value;
        }

        throw new CommandNotFoundException("This command wasn't found");
    }
}
