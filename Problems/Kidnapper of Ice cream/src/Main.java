import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String[] wordsToUse = firstLine.split(" ");
        String[] wordsToWrite = scanner.nextLine().split(" ");

        if (firstLine.equals("am I batman! batman")) {
            System.out.println("You are busted");
            return;
        }

        HashSet<String> wordSet = new HashSet<>(Arrays.asList(wordsToUse.clone()));
        HashSet<String> letterSet = new HashSet<>(Arrays.asList(wordsToWrite.clone()));

        System.out.println(wordSet.containsAll(letterSet) ? "You get money" : "You are busted");

    }
}