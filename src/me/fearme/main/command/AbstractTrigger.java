package me.fearme.main.command;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by FearMe on 5-3-2018.
 */
public abstract class AbstractTrigger {

    public abstract void execute(MessageReceivedEvent event);

    public abstract boolean evaluate(MessageReceivedEvent event, String prefix);

    public static void queueMessage(MessageReceivedEvent event, Message msg) {
        if (event.isFromType(ChannelType.PRIVATE)) {
            event.getAuthor().openPrivateChannel().queue(c -> c.sendMessage(msg).queue(), Throwable::printStackTrace);
        } else {
            event.getChannel().sendMessage(msg).queue();
        }
    }

    public static void queueMessage(MessageReceivedEvent event, String msg) {
        queueMessage(event, new MessageBuilder(msg).build());
    }
}
