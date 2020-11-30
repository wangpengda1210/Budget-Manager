package budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.*;

public class Account {

    private double balance;
    HashMap<Type, ArrayList<Item>> purchasedItems;

    public Account() {
        setBalance(0);
        purchasedItems = new HashMap<>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addPurchase(String name, double price, Type type) {
        if (balance < price) {
            System.out.println("\nNot enough balance");
        } else {
            putPurchase(name, price, type);
            balance -= price;
        }
    }

    private void putPurchase(String name, double price, Type type) {
        if (purchasedItems.containsKey(type)) {
            ArrayList<Item> items = purchasedItems.get(type);
            items.add(new Item(name, price));
        } else {
            ArrayList<Item> items = new ArrayList<>();
            items.add(new Item(name, price));
            purchasedItems.put(type, items);
        }
    }

    public String getPurchaseList(Type type) {
        StringBuilder sb = new StringBuilder(type.getName()).append(":\n");
        if (!purchasedItems.containsKey(type)) {
            sb.append("Purchase list is empty!");
            return sb.toString();
        }

        double sum = 0;
        ArrayList<Item> items = purchasedItems.get(type);
        DecimalFormat df = new DecimalFormat("#.00");

        for (Item item : items) {
            double price = item.getPrice();
            sum += price;
            sb.append(item.getName()).append(" $")
                    .append(df.format(price)).append("\n");
        }
        sb.append("Total sum: $").append(df.format(sum));
        return sb.toString();
    }

    private double getSum(ArrayList<Item> items) {
        double sum = 0;
        for (Item item : items) {
            double price = item.getPrice();
            sum += price;
        }
        return sum;
    }

    public boolean isPurchaseEmpty() {
        return purchasedItems.isEmpty();
    }

    public void saveData(String fileName) {
        File file = new File(fileName);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println(balance);
            purchasedItems.forEach((type, items) -> {
                for (Item item : items) {
                    printWriter.print(item.getName() + "\t");
                    printWriter.printf("%.2f\t", item.getPrice());
                    printWriter.println(type.getName());
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadData(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            balance = scanner.nextDouble();
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String[] info = scanner.nextLine().split("\t");
                putPurchase(info[0], Double.parseDouble(info[1]), Type.getTypeByName(info[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getSortedAll() {
        if (purchasedItems.isEmpty()) {
            return "Purchase list is empty!";
        }

        StringBuilder sb = new StringBuilder("All:\n");
        double sum = 0;
        DecimalFormat df = new DecimalFormat("#.00");

        ArrayList<Item> allList = new ArrayList<>();
        for (ArrayList<Item> typeList : purchasedItems.values()) {
            allList.addAll(typeList);
        }

        allList.sort(Comparator.reverseOrder());

        for (Item item : allList) {
            double price = item.getPrice();
            sum += price;
            sb.append(item.getName()).append(" $")
                    .append(df.format(price)).append("\n");
        }

        sb.append("Total sum: $").append(df.format(sum));
        return sb.toString();
    }

    public String getSortedCertainType(Type type) {
        if (purchasedItems.containsKey(type)) {
            purchasedItems.get(type).sort(Comparator.reverseOrder());
        }
        return getPurchaseList(type);
    }

    public String getSortedType() {
        StringBuilder sb = new StringBuilder("Types\n");
        DecimalFormat df = new DecimalFormat("#.00");

        double sum = 0;

        ArrayList<Type> types = new ArrayList<>(Arrays.asList(Type.values()));
        types.sort((type, t1) -> {
            double firstSum = purchasedItems.containsKey(type) ?
                    getSum(purchasedItems.get(type)) : 0;
            double secondSum = purchasedItems.containsKey(t1) ?
                    getSum(purchasedItems.get(t1)) : 0;
            return Double.compare(firstSum, secondSum);
        });
        Collections.reverse(types);

        for (Type type : types) {
            double typeSum = purchasedItems.containsKey(type) ?
                    getSum(purchasedItems.get(type)) : 0;
            sb.append(type.getName()).append(" - $")
                    .append(typeSum == 0 ? 0 : df.format(typeSum)).append("\n");
            sum += typeSum;
        }

        sb.append("Total sum: $").append(sum == 0 ? 0 : df.format(sum));
        return sb.toString();
    }

}
