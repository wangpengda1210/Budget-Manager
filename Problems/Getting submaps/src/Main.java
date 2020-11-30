import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int lower = scanner.nextInt();
        int higher = scanner.nextInt();

        int count = scanner.nextInt();

        TreeMap<Integer, String> map = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            int key = scanner.nextInt();
            String value = scanner.next();
            if (key >= lower && key <= higher) {
                map.put(key, value);
            }
        }

        map.forEach((key, value) -> System.out.println(key + " " + value));
    }
}