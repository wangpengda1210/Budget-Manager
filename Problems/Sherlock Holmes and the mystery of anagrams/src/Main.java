import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.next().toLowerCase();
        String word2 = scanner.next().toLowerCase();

        HashMap<Character, Integer> map1 = getMap(word1);
        HashMap<Character, Integer> map2 = getMap(word2);

        boolean isAnagram = true;

        for (char character : map1.keySet()) {
            if (!map2.containsKey(character)) {
                isAnagram = false;
                break;
            } else {
                isAnagram = map1.get(character).equals(map2.get(character));
                if (!isAnagram) {
                    break;
                }
            }
        }

        if (isAnagram) {
            for (char character : map2.keySet()) {
                if (!map1.containsKey(character)) {
                    isAnagram = false;
                    break;
                }
            }
        }

        System.out.println(isAnagram ? "yes" : "no");
    }

    private static HashMap<Character, Integer> getMap(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }
        return map;
    }
}