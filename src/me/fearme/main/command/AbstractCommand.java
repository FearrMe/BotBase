package me.fearme.main.command;

/**
 * Created by FearMe on 12-2-2018.
 */
public abstract class AbstractCommand extends AbstractTrigger {

    private final String command;
    private final boolean caseSensitive;

    public AbstractCommand(String command) {
        this(command, false);
    }

    public AbstractCommand(String command, boolean caseSensitive) {
        this.command = caseSensitive ? command : command.toLowerCase();
        this.caseSensitive = caseSensitive;
    }

    public String getCommand() {
        return command;
    }

    public boolean isCaseSensitive() {
        return caseSensitive;
    }
}
