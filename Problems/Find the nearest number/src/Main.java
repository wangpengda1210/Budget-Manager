import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        int find = scanner.nextInt();

        ArrayList<Integer> closestList = new ArrayList<>();
        int closestDistance = Integer.MAX_VALUE;

        for (String number : array) {
            int intNumber = Integer.parseInt(number);
            int distance = Math.abs(intNumber - find);
            if (distance == closestDistance) {
                closestList.add(intNumber);
            } else if (distance < closestDistance) {
                closestDistance = distance;
                closestList = new ArrayList<>();
                closestList.add(intNumber);
            }
        }

        closestList.sort(Comparator.naturalOrder());
        for (int number : closestList) {
            System.out.print(number + " ");
        }
    }
}