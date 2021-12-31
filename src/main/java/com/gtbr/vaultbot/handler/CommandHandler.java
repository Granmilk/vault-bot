package com.gtbr.vaultbot.handler;

import net.dv8tion.jda.api.entities.Message;

import com.gtbr.vaultbot.utils.MessageUtils;

public class CommandHandler implements Handler{

    @Override
    public void handle(Message message) {
        switch (MessageUtils.getCommandType(message)){
            case USER -> {
                //TODO add specific handler to user
            }
            case VAULT -> {
                //TODO add specific handler to vault
            }
        }
    }
}
