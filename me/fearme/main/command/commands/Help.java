package me.fearme.main.command.commands;

import me.fearme.main.command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by FearMe on 12-2-2018.
 */
public class Help extends Command {

    public static final String COMMAND = "help";

    public Help() {
        super(COMMAND);
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        // TODO: implement help command
    }
}
