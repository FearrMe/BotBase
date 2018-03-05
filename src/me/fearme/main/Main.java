package me.fearme.main;

import me.fearme.main.command.commands.Help;
import me.fearme.main.command.commands.Ping;
import me.fearme.main.handlers.CommandHandler;
import me.fearme.main.handlers.MessageLogger;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

/**
 * Created by FearMe on 12-2-2018.
 */
public class Main {

    public static JDA jda;
    public static CommandHandler commandHandler = new CommandHandler("b!");
    public static CommandHandler noPrefix = new CommandHandler();

    public static void main(String[] args) throws LoginException, InterruptedException {
        jda = new JDABuilder(AccountType.BOT).setToken("TOKEN").buildBlocking();
        jda.getPresence().setGame(Game.playing("b!help"));

        try {
            jda.addEventListener(new MessageLogger(args[0]));
            System.out.println("LOGGING TO " + args[0]);
        } catch (Exception e) {
            e.printStackTrace();
            jda.addEventListener(new MessageLogger());
            System.out.println("LOGGING OFF");
        }

        commandHandler.addCommands(new Help(), new Ping());
        noPrefix.addCommands();

        jda.addEventListener(commandHandler, noPrefix);

        System.out.println("-------------------------------------");
    }
}

