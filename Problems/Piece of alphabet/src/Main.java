import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("abcdefghijklmnopqrstuvwxyz".contains(scanner.nextLine()
                .toLowerCase()));
    }
}