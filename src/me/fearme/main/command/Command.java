package me.fearme.main.command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by FearMe on 12-2-2018.
 */
public abstract class Command extends AbstractCommand {

    public Command(String command) {
        super(command);
    }

    public Command(String command, boolean caseSensitive) {
        super(command, caseSensitive);
    }

    public abstract void execute(MessageReceivedEvent event);

    public boolean evaluate(MessageReceivedEvent event, String prefix) {
        String msg = event.getMessage().getContentDisplay();
        msg = isCaseSensitive() ? msg : msg.toLowerCase();
        return msg.startsWith(prefix + getCommand());
    }

    public String[] getArgs(String msg) {
        return msg.substring(msg.indexOf(getCommand()) + getCommand().length()).trim().split(" ");
    }
}
