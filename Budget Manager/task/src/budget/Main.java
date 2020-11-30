package budget;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static Account account;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        account = new Account();

        mainLoop:while (true) {
            System.out.println("\nChoose your action:\n" +
                    "1) Add income\n" +
                    "2) Add purchase\n" +
                    "3) Show list of purchases\n" +
                    "4) Balance\n" +
                    "5) Save\n" +
                    "6) Load\n" +
                    "7) Analyze (Sort)\n" +
                    "0) Exit");

            switch (scanner.nextInt()) {
                case 0:
                    break mainLoop;
                case 1:
                    System.out.println("\nEnter income:");
                    account.setBalance(account.getBalance() + scanner.nextDouble());
                    System.out.println("Income was added!");
                    break;
                case 2:
                    purchaseItem();
                    break;
                case 3:
                    if (account.isPurchaseEmpty()) {
                        System.out.println("\nPurchase list is empty!");
                    } else {
                        getPurchaseList();
                    }
                    break;
                case 4:
                    System.out.println("\nBalance: $" + account.getBalance());
                    break;
                case 5:
                    account.saveData("purchases.txt");
                    System.out.println("\nPurchases were saved!");
                    break;
                case 6:
                    account.loadData("purchases.txt");
                    System.out.println("\nPurchases were loaded!");
                    break;
                case 7:
                    performSorting();
                    break;
                default:
                    performSorting();
                    System.out.println("Incorrect input");
            }
        }

        System.out.println("\nBye!");
    }

    private static void performSorting() {
        sortLoop:while (true) {
            System.out.println("\nHow do you want to sort?\n" +
                    "1) Sort all purchases\n" +
                    "2) Sort by type\n" +
                    "3) Sort certain type\n" +
                    "4) Back");

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("\n" + account.getSortedAll());
                    break;
                case 2:
                    System.out.println("\n" + account.getSortedType());
                    break;
                case 3:
                    System.out.println("\nChoose the type of purchase\n" +
                            "1) Food\n" +
                            "2) Clothes\n" +
                            "3) Entertainment\n" +
                            "4) Other");
                    System.out.println("\n" + account.getSortedCertainType(Objects
                            .requireNonNull(Type.getTypeById(scanner.nextInt()))));
                    break;
                case 4:
                    break sortLoop;
                default:
                    System.out.println("Not a correct choice");
                    break;
            }
        }
    }

    private static void getPurchaseList() {
        listLoop:while (true) {
            System.out.println("\nChoose the type of purchases\n" +
                    "1) Food\n" +
                    "2) Clothes\n" +
                    "3) Entertainment\n" +
                    "4) Other\n" +
                    "5) All\n" +
                    "6) Back");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                    Type type = Type.getTypeById(choice);
                    assert type != null;
                    System.out.println("\n" + account.getPurchaseList(type));
                    break;
                case 5:
                    System.out.println("\n" + account.getSortedAll());
                    break;
                case 6:
                    break listLoop;
                default:
                    System.out.println("Not a correct choice");
                    break;
            }
        }
    }

    private static void purchaseItem() {
        purchaseLoop:while (true) {
            System.out.println("\nChoose the type of purchases\n" +
                    "1) Food\n" +
                    "2) Clothes\n" +
                    "3) Entertainment\n" +
                    "4) Other\n" +
                    "5) Back");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                    Type type = Type.getTypeById(choice);
                    System.out.println("\nEnter purchase name:");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("Enter its price:");
                    double price = scanner.nextDouble();
                    account.addPurchase(name, price, type);
                    System.out.println("Purchase was added!");
                    break;
                case 5:
                    break purchaseLoop;
                default:
                    System.out.println("Not a correct choice");
                    break;
            }
        }
    }
}
