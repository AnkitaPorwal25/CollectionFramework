package Collection_Worksheet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Order {
    private static int idCounter = 1;
    private int orderId;
    private String customerName;
    private String item;

    public Order(String customerName, String item) {
        this.orderId = idCounter++;
        this.customerName = customerName;
        this.item = item;
    }

    public int getOrderId() {
        return orderId;
    }

    public String toString() {
        return "Order #" + orderId + ": " + customerName + " - " + item;
    }
}

public class T14RestaurantOrderSystem {
    private Deque<Order> currentOrders = new ArrayDeque<>();
    private List<Order> orderHistory = new ArrayList<>();

    // Add order at front (priority)
    public void addOrderToFront(Order order) {
        currentOrders.addFirst(order);
        System.out.println("Order added to front: " + order);
    }

    // Add order at end (normal)
    public void addOrderToEnd(Order order) {
        currentOrders.addLast(order);
        System.out.println("Order added to end: " + order);
    }

    // Process order from front (serve)
    public void serveOrderFromFront() {
        if (currentOrders.isEmpty()) {
            System.out.println("No orders to serve.");
            return;
        }
        Order served = currentOrders.removeFirst();
        orderHistory.add(served);
        System.out.println("Served (front): " + served);
    }

    // Cancel last order (remove from end)
    public void cancelOrderFromEnd() {
        if (currentOrders.isEmpty()) {
            System.out.println("No orders to cancel.");
            return;
        }
        Order canceled = currentOrders.removeLast();
        System.out.println("Canceled (end): " + canceled);
    }

    // Show current orders
    public void showCurrentOrders() {
        System.out.println("Current Orders:");
        for (Order order : currentOrders) {
            System.out.println(order);
        }
    }

    // Show order history
    public void showOrderHistory() {
        System.out.println("Order History:");
        for (Order order : orderHistory) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {
        T14RestaurantOrderSystem system = new T14RestaurantOrderSystem();

        // Add some orders
        system.addOrderToEnd(new Order("Alice", "Burger"));
        system.addOrderToFront(new Order("Bob", "Pizza"));
        system.addOrderToEnd(new Order("Charlie", "Salad"));

        // Show current orders
        system.showCurrentOrders();

        // Process and cancel orders
        system.serveOrderFromFront();
        system.cancelOrderFromEnd();

        // Show updated orders and history
        system.showCurrentOrders();
        system.showOrderHistory();
    }
}


//
//Problem 14: Restaurant Order System (Deque, List)
//Use a Deque<Order> for managing current orders.
//Allow adding/removing orders from both ends.
//Store history in a List<Order>.
//