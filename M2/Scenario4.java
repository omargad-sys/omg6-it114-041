package M2;
// copilot: disable
// @ts-nocheck

public class Scenario4 extends BaseClass {
    private static String[] array1 = { "hello world!", "java programming", "special@#$%^&characters", "numbers 123 456",
            "mIxEd CaSe InPut!" };
    private static String[] array2 = { "hello world", "java programming", "this is a title case test",
            "capitalize every word", "mixEd CASE input" };
    private static String[] array3 = { "  hello   world  ", "java    programming  ",
            "  extra    spaces  between   words   ",
            "      leading and trailing spaces      ", "multiple      spaces" };
    private static String[] array4 = { "hello world", "java programming", "short", "a", "even" };

    private static void transformText(String[] arr, int arrayNumber) {
        // Only make edits between the designated "Start" and "End" comments
        printScenario4ArrayInfo(arr, arrayNumber);
        // This should be solved without Copilot auto-completion, to toggle it, click the Copilot chat bubble at the top of the editor.
        //  Configure inline suggestions to "Disabled Inline Suggestions" (or similar) when writing code for this problem.

        // Challenge 1: Remove non-alphanumeric characters except spaces
        // Challenge 2: Convert text to Title Case
        // Challenge 3: Remove leading/trailing spaces and remove duplicate spaces between words
        // Result 1-3: Assign final phrase to `placeholderForModifiedPhrase`
        // Challenge 4 (extra credit): Extract up to middle 3 characters (beginning starts at middle of phrase, exclude the first and last character for shorter phrases)
        // Assign result to 'placeholderForMiddleCharacters'
        // If not enough characters in a word, instead assign "Not enough characters" to `placeholderForMiddleCharacters`
 
        // Step 1: sketch out plan using comments (include ucid and date)
        // Step 2: Add/commit your outline of comments (required for full credit)
        // Step 3: Add code to solve the problem (add/commit as needed)
        String placeholderForModifiedPhrase = "";
        String placeholderForMiddleCharacters = "";
        
        for(int i = 0; i <arr.length; i++){
            // Start Solution Edits omg6 june 14, used replaceAll with a regex to delete any character that isn't a letter, digit, or space.
            String phrase = arr[i]; 
            phrase = phrase.replaceAll("[^a-zA-Z0-9 ]", "");
            phrase = phrase.trim(); // trimmed the ends and collapsed runs of spaces into a single space.
            phrase = phrase.replaceAll("\\s+", " ");

            String[] words = phrase.split(" ");        //  split the phrase into words, then uppercased each word's first letter and lowercased the rest before rejoining them.
        StringBuilder sb = new StringBuilder();      
        for (int w = 0; w < words.length; w++) {
         if (words[w].length() > 0) {            
        String first = words[w].substring(0, 1).toUpperCase();
        String rest  = words[w].substring(1).toLowerCase();     
        sb.append(first).append(rest);
    }
    if (w < words.length - 1) {
        sb.append(" ");                   
    }
}
phrase = sb.toString();
placeholderForModifiedPhrase = phrase;
            int mid = phrase.length() / 2;
            if (mid + 3 > phrase.length()) {
                placeholderForMiddleCharacters = "Not enough characters";
            } else {
                placeholderForMiddleCharacters = phrase.substring(mid, mid + 3);
}
            // End Solution Edits
            System.out.println(String.format("Index[%d] \"%s\" | Middle: \"%s\"",i, placeholderForModifiedPhrase, placeholderForMiddleCharacters));
        }
        System.out.println("");
        System.out.println("______________________________________");
    }

    public static void main(String[] args) {
        final String ucid = "omg6"; // <-- change to your UCID
        // No edits below this line
        printHeader(ucid, 4);

        transformText(array1, 1);
        transformText(array2, 2);
        transformText(array3, 3);
        transformText(array4, 4);
        printFooter(ucid, 4);
    }

}
