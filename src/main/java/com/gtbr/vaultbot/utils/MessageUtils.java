package com.gtbr.vaultbot.utils;

import net.dv8tion.jda.api.entities.Message;

import com.gtbr.vaultbot.handler.type.CommandType;

import java.util.Locale;

public class MessageUtils {

    private MessageUtils() {}

    public static boolean hasPrefix(String message, String prefix) {
        return message.startsWith(prefix);
    }

    public static CommandType getCommandType(Message message) {
        return CommandType.typeFor(getCommandFromMessage(message, "&"));
    }

    private static String getCommandFromMessage(Message message, String prefix) {
        return message.getContentRaw().toLowerCase(Locale.ROOT).split(" ")[0].replace(prefix, "");
    }
}
