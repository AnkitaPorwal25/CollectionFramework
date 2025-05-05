package Collection_Worksheet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
 class Product {
    private int id;
    private String name;
    private double price;
    private double rating; // Higher = better
    private int stock;

    public Product(int id, String name, double price, double rating, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }
    public int getStock() { return stock; }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', price=%.2f, rating=%.1f, stock=%d}",
                id, name, price, rating, stock);
    }
}


public class T5ProductCatalog {
    public static void main(String[] args) {
        TreeMap<Integer, Product> productMap = new TreeMap<>();

        // Add products to TreeMap (id as key)
        productMap.put(101, new Product(101, "Laptop", 800.0, 4.5, 10));
        productMap.put(102, new Product(102, "Smartphone", 500.0, 4.7, 25));
        productMap.put(103, new Product(103, "Headphones", 80.0, 4.5, 50));
        productMap.put(104, new Product(104, "Keyboard", 45.0, 4.2, 40));
        productMap.put(105, new Product(105, "Monitor", 200.0, 4.5, 15));

        // Get values as a list and sort
        List<Product> sortedProducts = new ArrayList<>(productMap.values());

        // Sort by descending rating, then name ascending
        sortedProducts.sort(Comparator
                .comparing(Product::getRating).reversed()
                .thenComparing(Product::getName));

        // Display sorted products
        System.out.println("Products sorted by rating (desc) then name:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }
}
