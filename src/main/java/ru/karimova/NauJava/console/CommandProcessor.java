package ru.karimova.NauJava.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.karimova.NauJava.services.AddressService;

@Component
public class CommandProcessor {

    private final AddressService addressService;

    @Autowired
    public CommandProcessor(AddressService addressService) {
        this.addressService = addressService;
    }

    public void processCommand(String input) {
        String[] cmd = input.split(" ");

        switch (cmd[0].toLowerCase()) {
            case "create" -> {
                if (cmd.length == 5) {
                    Long id = Long.valueOf(cmd[1]);
                    String street = cmd[2];
                    String city = cmd[3];
                    String postalCode = cmd[4];
                    addressService.createAddress(id, street, city, postalCode);
                } else {
                    System.out.println("Invalid input. Use: create <id> <street> <city> <postalCode>");
                }
            }
            case "read" -> {
                if (cmd.length == 2) {
                    Long id = Long.valueOf(cmd[1]);
                    System.out.println(addressService.displayAddress(id));
                } else {
                    System.out.println("Invalid input. Use: read <id>");
                }
            }
            case "update" -> {
                if (cmd.length == 5) {
                    Long id = Long.valueOf(cmd[1]);
                    String street = cmd[2];
                    String city = cmd[3];
                    String postalCode = cmd[4];
                    addressService.updateAddress(id, street, city, postalCode);
                    System.out.println("Address successfully updated...");
                } else {
                    System.out.println("Invalid input. Use: update <id> <street> <city> <postalCode>");
                }
            }
            case "delete" -> {
                if (cmd.length == 2) {
                    Long id = Long.valueOf(cmd[1]);
                    addressService.deleteById(id);
                    System.out.println("Address deleted.");
                } else {
                    System.out.println("Invalid input. Use: delete <id>");
                }
            }
            case "exit" -> {
                System.out.println("Exiting the program...");
                System.exit(0);
            }
            default -> System.out.println("Unknown command entered. Use: create, read, update, delete, exit");
        }
    }
}

