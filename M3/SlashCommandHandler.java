package M3;

import java.util.Random;

/*
Challenge 2: Simple Slash Command Handler
-----------------------------------------
- Accept user input as slash commands
  - "/greet <name>" → Prints "Hello, <name>!"
  - "/roll <num>d<sides>" → Roll <num> dice with <sides> and returns a single outcome as "Rolled <num>d<sides> and got <result>!"
  - "/echo <message>" → Prints the message back
  - "/quit" → Exits the program
- Commands are case-insensitive
- Print an error for unrecognized commands
- Print errors for invalid command formats (when applicable)
- Capture 3 variations of each command except "/quit"
*/

import java.util.Scanner;

public class SlashCommandHandler extends BaseClass {
    private static String ucid = "omg6"; // <-- change to your UCID
// used a switch statment to go through all the scenarios with a default clause. also used .toLowerCase to ensure all text works.
    public static void main(String[] args) {
        printHeader(ucid, 2, "Objective: Implement a simple slash command parser.");

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        // Can define any variables needed here

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            // get entered text
            String[] parts = input.split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1].trim() : "";

            switch (command) {
                case "greet":
                    if (argument.isEmpty()) {
                        System.out.println("Invalid format. use greet <name>");
                    } else {
                        System.out.println("Hello, " + argument + "!");
                    }
                    break;

                case "roll":
                    if (!argument.toLowerCase().matches("\\d+d\\d+")) {
                        System.out.println("Invalid format.  use roll <num>d<sides>");
                    } else {
                        String[] diceParts = argument.toLowerCase().split("d");
                        int numDice = Integer.parseInt(diceParts[0]);
                        int sides = Integer.parseInt(diceParts[1]);
                        int total = 0;
                        for (int i = 0; i < numDice; i++) {
                           
                            total += rand.nextInt(sides) + 1;
                        }
                        System.out.println("Rolled " + numDice + "d" + sides + " and got " + total + "!");
                    }
                    break;

                case "echo":
                    System.out.println(argument);
                    break;

                case "quit":
                    System.out.println("Exiting program");
                    printFooter(ucid, 2);
                  scanner.close();

                    return;

                default:
                    System.out.println("Unrecognized command: " + input);
            }
        }
    }
}
