import java.util.Scanner;

public class MadLibsGame {

    // Small container that holds a story template and the correct answers.
    static class Story {
        String text;
        String[] answers;

        Story(String text, String[] answers) {
            this.text = text;
            this.answers = answers;
        }
    }

    // Pre-made stories for different difficulty levels.
    private static final Story EASY = new Story(
            """
            A boy and a girl went to a ________. They had a small bag with them.
            They saw a big ________ on which a blue bird sat, and a ________ dog.
            Then ________ ran around and had fun in the sun.
            """,
            new String[]{"Park", "Tree", "Cute", "They"}
    );

    private static final Story MEDIUM = new Story(
            """
            The old man walked into the ________ holding a rusty lantern.
            He placed it beside a wooden ________, and noticed a ________ shadow moving.
            Suddenly, ________ whispered something strange in the wind.
            """,
            new String[]{"Cave", "Table", "Dark", "Someone"}
    );

    private static final Story HARD = new Story(
            """
            On the distant planet of ________, explorers discovered a glowing ________ buried in the sand.
            The artifact emitted a ________ pulse, causing the crew to panic.
            Moments later, ________ activated and changed everything they knew.
            """,
            new String[]{"Xenora", "Sphere", "Violet", "It"}
    );


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int credits = 100;

        System.out.println("WELCOME TO ADVANCED MAD LIBS!");
        System.out.println("Credits: " + credits);

        // Keep running the game until the player chooses to stop.
        while (askToPlay(scanner)) {

            credits -= 5; // Every round costs 5 credits.
            System.out.println("\nEach play costs 5 credits. Remaining: " + credits);

            Story chosenStory = selectDifficulty(scanner);

            // Run one round and collect updated credits.
            credits = playStory(scanner, chosenStory, credits);

            System.out.println("Credits Left: " + credits);
        }

        System.out.println("\nGame Ended.");
        System.out.println("Final Credits: " + credits);
    }


    // Lets the player choose between Easy, Medium, Hard.
    private static Story selectDifficulty(Scanner scanner) {
        while (true) {
            System.out.println("\nChoose Difficulty:");
            System.out.println("1) Easy");
            System.out.println("2) Medium");
            System.out.println("3) Hard");
            System.out.print("Enter choice (1/2/3): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": return EASY;
                case "2": return MEDIUM;
                case "3": return HARD;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }


    // Handles one complete round: show story → get words → print story → score.
    private static int playStory(Scanner scanner, Story story, int credits) {

        String[] inputs = new String[story.answers.length];

        System.out.println("\nFill in the blanks below:");
        System.out.println(story.text);

        // Get one word for each blank.
        for (int i = 0; i < story.answers.length; i++) {
            inputs[i] = getInput(scanner, i + 1);
        }

        printCompletedStory(story.text, inputs);

        // Return updated credits.
        return evaluateStory(inputs, story.answers, credits);
    }


    // Ensures user doesn't enter an empty string.
    private static String getInput(Scanner scanner, int num) {
        while (true) {
            System.out.print("Enter word " + num + ": ");
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("You typed nothing. Try again.");
        }
    }


    // Replace the blanks with the user's words, in order.
    private static void printCompletedStory(String template, String[] words) {

        String filled = template;

        for (String word : words) {
            filled = filled.replaceFirst("________", word);
        }

        System.out.println("\n===== YOUR STORY =====");
        System.out.println(filled);
        System.out.println("======================");
    }


    // Check if user entered all correct words. If yes → give +10 credits.
    private static int evaluateStory(String[] inputs, String[] answers, int credits) {

        boolean correct = true;

        for (int i = 0; i < answers.length; i++) {
            if (!inputs[i].equalsIgnoreCase(answers[i])) {
                correct = false;
                break;
            }
        }

        if (correct) {
            System.out.println("Correct! You WON +10 credits!");
            credits += 10;
        } else {
            System.out.println("Not quite!");
            System.out.println("Correct Answers Were:");
            for (String a : answers) System.out.print(a + " ");
            System.out.println();
        }

        return credits; // Send updated credits back.
    }


    // Asks the player if they want to continue.
    private static boolean askToPlay(Scanner scanner) {
        System.out.print("\nPlay game? (Y/N): ");
        return scanner.nextLine().trim().equalsIgnoreCase("Y");
    }
}
