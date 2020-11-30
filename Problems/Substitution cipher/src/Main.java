import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String origin = scanner.next();
        String cipher = scanner.next();

        HashMap<Character, Character> substitution = new HashMap<>();
        HashMap<Character, Character> reverseSubstitution = new HashMap<>();
        for (int i = 0; i < origin.length(); i++) {
            substitution.put(origin.charAt(i), cipher.charAt(i));
            reverseSubstitution.put(cipher.charAt(i), origin.charAt(i));
        }

        String text1 = scanner.next();
        for (int i = 0; i < text1.length(); i++) {
            System.out.print(substitution.get(text1.charAt(i)));
        }
        System.out.println();

        String text2 = scanner.next();
        for (int i = 0; i < text2.length(); i++) {
            System.out.print(reverseSubstitution.get(text2.charAt(i)));
        }
        System.out.println();
    }
}