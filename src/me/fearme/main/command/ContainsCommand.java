package me.fearme.main.command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by FearMe on 12-2-2018.
 */
public abstract class ContainsCommand extends AbstractCommand {

    public ContainsCommand(String command, boolean caseSensitive) {
        super(command, caseSensitive);
    }

    public ContainsCommand(String command) {
        super(command);
    }

    public abstract void execute(MessageReceivedEvent event);

    @Override
    public boolean evaluate(MessageReceivedEvent event, String prefix) {
        String msg = event.getMessage().getContentDisplay();
        msg = isCaseSensitive() ? msg : msg.toLowerCase();
        return msg.contains(getCommand());
    }
}
