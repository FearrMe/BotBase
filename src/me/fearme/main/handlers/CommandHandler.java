package me.fearme.main.handlers;

import me.fearme.main.command.AbstractCommand;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by FearMe on 12-2-2018.
 */
public class CommandHandler extends ListenerAdapter {

    List<AbstractCommand> commands = new ArrayList<>();

    private final String prefix;

    public CommandHandler(String prefix, AbstractCommand... commands) {
        this.prefix = prefix;
        addCommands(commands);
    }

    public CommandHandler(AbstractCommand... commands) {
        this("", commands);
    }

    public void addCommands(AbstractCommand... commands) {
        this.commands.addAll(Arrays.asList(commands));
    }

    public String getPrefix() {
        return prefix;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String msg = event.getMessage().getContentDisplay().toLowerCase();

        if (!msg.startsWith(prefix) || event.getAuthor().isBot()) {
            return;
        }

        for (AbstractCommand command : commands) {
            if (command.evaluate(event, prefix))
                command.execute(event);
        }
    }
}