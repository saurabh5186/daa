import java.util.Arrays;
import java.util.Scanner;

class Item {
    int weight;
    int value;
    double ratio;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.ratio = (double) value / weight; // Calculate value-to-weight ratio
    }
}

public class FractionalKnapsack {

    public static double maximizeValue(Item[] items, int capacity) {
        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0;

        for (Item item : items) {
            if (capacity > 0 && item.weight <= capacity) {
                // Take the whole item if it fits
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                // Take fractional part of the item if it doesn't fit completely
                double fraction = (double) capacity / item.weight;
                totalValue += item.value * fraction;
                break; // Knapsack is full after this
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        Item[] items = new Item[n];
        System.out.println("Enter the weight and value of each item:");

        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " weight: ");
            int weight = scanner.nextInt();
            System.out.print("Item " + (i + 1) + " value: ");
            int value = scanner.nextInt();
            items[i] = new Item(weight, value);
        }

        System.out.print("Enter the capacity of the knapsack(Weight): ");
        int capacity = scanner.nextInt();
        scanner.close();

        double maxValue = maximizeValue(items, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }
}
