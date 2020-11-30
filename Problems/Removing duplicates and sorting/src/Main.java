import java.util.Scanner;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> words = new TreeSet<>();

        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            words.add(scanner.next());
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}