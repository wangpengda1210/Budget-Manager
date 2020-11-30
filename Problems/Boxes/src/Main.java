import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String[] firstBox = scanner.nextLine().split(" ");
        String[] secondBox = scanner.nextLine().split(" ");

        Arrays.sort(firstBox);
        Arrays.sort(secondBox);

        if (firstBox[0].compareTo(secondBox[0]) > 0 &&
                firstBox[1].compareTo(secondBox[1]) > 0 &&
                firstBox[2].compareTo(secondBox[2]) > 0) {
            System.out.println("Box 1 > Box 2");
        } else if (firstBox[0].compareTo(secondBox[0]) < 0 &&
                firstBox[1].compareTo(secondBox[1]) < 0 &&
                firstBox[2].compareTo(secondBox[2]) < 0) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incompatible");
        }
    }
}