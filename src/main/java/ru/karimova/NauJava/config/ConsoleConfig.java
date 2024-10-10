package ru.karimova.NauJava.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.karimova.NauJava.console.CommandProcessor;

import java.util.Scanner;

@Configuration
public class ConsoleConfig {

    private final CommandProcessor commandProcessor;

    @Autowired
    public ConsoleConfig(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    @Bean
    public CommandLineRunner commandScanner() {
        return args -> {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter a command (create, read, update, delete). Type 'exit' to quit.");
                while (true) {
                    System.out.print("> ");
                    String input = scanner.nextLine();
                    commandProcessor.processCommand(input);
                }
            }
        };
    }
}
