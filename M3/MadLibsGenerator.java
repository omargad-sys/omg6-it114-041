package M3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Challenge 3: Mad Libs Generator (Randomized Stories)
-----------------------------------------------------
- Load a **random** story from the "stories" folder
- Extract **each line** into a collection (i.e., ArrayList)
- Prompts user for each placeholder (i.e., <adjective>) 
    - Any word the user types is acceptable, no need to verify if it matches the placeholder type
    - Any placeholder with underscores should display with spaces instead
- Replace placeholders with user input (assign back to original slot in collection)
*/

public class MadLibsGenerator extends BaseClass {
    private static final String STORIES_FOLDER = "M3/stories";
    private static String ucid = "omg6"; // <-- change to your ucid
// picks a random story, find the placeholder tags with a regex pattern then sqaps answers and prints story
    public static void main(String[] args) {
        printHeader(ucid, 3,
                "Objective: Implement a Mad Libs generator that replaces placeholders dynamically.");

        Scanner scanner = new Scanner(System.in);
        File folder = new File(STORIES_FOLDER);

        if (!folder.exists() || !folder.isDirectory() || folder.listFiles().length == 0) {
            System.out.println("Error: No stories found in the 'stories' folder.");
            printFooter(ucid, 3);
            scanner.close();
            return;
        }
        List<String> lines = new ArrayList<>();
        Random story= new Random();
        File[] storyFiles = folder.listFiles();
        File chosenFile = storyFiles[story.nextInt(storyFiles.length)];

        try (Scanner fileScanner = new Scanner(chosenFile)) {
    while (fileScanner.hasNextLine()) {
        lines.add(fileScanner.nextLine());
    }
} catch (java.io.FileNotFoundException e) {
    System.out.println("Could not read the story file.");
    printFooter(ucid, 3);
    scanner.close();
    return;
}
Pattern placeholderPattern = Pattern.compile("<([^>]+)>");

for (int i = 0; i < lines.size(); i++) {
    String line = lines.get(i);
    Matcher matcher = placeholderPattern.matcher(line);
    StringBuilder updatedLine = new StringBuilder();
    int lastEnd = 0;

     while (matcher.find()) {
        updatedLine.append(line, lastEnd, matcher.start());

        String placeholder = matcher.group(1).replace("_", " ");
        System.out.print("Enter a " + placeholder + ": ");
        String userInput = scanner.nextLine();

        updatedLine.append(userInput);
        lastEnd = matcher.end();
    }
    updatedLine.append(line.substring(lastEnd));
    lines.set(i, updatedLine.toString());
}
        System.out.println("\nYour Completed Mad Libs Story:\n");
        StringBuilder finalStory = new StringBuilder();
        for (String line : lines) {
            finalStory.append(line).append("\n");
        }
        System.out.println(finalStory.toString());

        printFooter(ucid, 3);
        scanner.close();
    }
}
