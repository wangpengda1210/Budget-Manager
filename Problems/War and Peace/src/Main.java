import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().toLowerCase().split(" ");
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        map.forEach((key, value) -> System.out.println(key + " " + value));
    }
}