import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        HashSet<String> wordlist = new HashSet<>();

        int wordCount = scanner.nextInt();
        for (int i = 0; i < wordCount; i++) {
            wordlist.add(scanner.next().toLowerCase());
        }

        HashSet<String> errors = new HashSet<>();

        int lineCount = scanner.nextInt();
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (!wordlist.contains(word.toLowerCase())) {
                errors.add(word.toLowerCase());
            }
        }

        for (String error : errors) {
            System.out.println(error);
        }
    }
}