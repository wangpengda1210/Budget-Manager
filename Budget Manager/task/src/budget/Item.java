package budget;

public class Item implements Comparable<Item> {
    private final String name;
    private final double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Item item) {
        return Double.compare(price, item.getPrice());
    }
}
