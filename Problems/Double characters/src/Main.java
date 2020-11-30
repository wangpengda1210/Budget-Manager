import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String output = "";
        for (int i = 0; i < input.length(); i++) {
            output += input.charAt(i);
            output += input.charAt(i);
        }

        System.out.println(output);
    }
}