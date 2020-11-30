import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        int swap = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (Integer.parseInt(numbers[j]) < Integer.parseInt(numbers[j + 1])) {
                    String temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swap++;
                }
            }
        }

        System.out.println(swap);
    }
}