package me.fearme.main.command.commands;

import me.fearme.main.command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by FearMe on 12-2-2018.
 */
public class Ping extends Command {

    public static final String COMMAND = "ping";

    public Ping() {
        super(COMMAND);
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        queueMessage(event, "pong");
    }
}

