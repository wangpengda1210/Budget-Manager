import java.util.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        // write your code here
        HashSet<Integer> numbers = new HashSet<>();
        for (String number : str.split(" ")) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        // write your code here
        set.removeIf(item -> item > 10);
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}