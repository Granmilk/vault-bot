package com.gtbr.vaultbot.listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import com.gtbr.vaultbot.handler.CommandHandler;
import com.gtbr.vaultbot.utils.MessageUtils;

import org.jetbrains.annotations.NotNull;

public class MessageListener extends ListenerAdapter {

    private final CommandHandler commandHandler;

    public MessageListener(){
        this.commandHandler = new CommandHandler();
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent messageReceivedEvent) {
        if (!messageReceivedEvent.getAuthor().isBot() && MessageUtils.hasPrefix(messageReceivedEvent.getMessage().getContentRaw(), "&")) {
            commandHandler.handle(messageReceivedEvent.getMessage());
        }
    }
}
