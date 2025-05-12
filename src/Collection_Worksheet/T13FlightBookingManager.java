package Collection_Worksheet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class T13FlightBookingManager {
    private Queue<String> bookingRequests = new LinkedList<>();
    private Map<String, Integer> confirmedBookings = new HashMap<>();
    private int nextAvailableSeat = 1;

    // Add a booking request to the queue
    public void addBookingRequest(String passengerName) {
        bookingRequests.offer(passengerName);
        System.out.println("Booking request added: " + passengerName);
    }

    // Process the next booking in the queue
    public void processNextBooking() {
        if (bookingRequests.isEmpty()) {
            System.out.println("No booking requests to process.");
            return;
        }

        String passenger = bookingRequests.poll(); // FIFO: get and remove from queue
        confirmedBookings.put(passenger, nextAvailableSeat++);
        System.out.println("Booking confirmed: " + passenger + " => Seat " + confirmedBookings.get(passenger));
    }

    // Display all confirmed bookings
    public void showConfirmedBookings() {
        System.out.println("Confirmed Bookings:");
        for (Map.Entry<String, Integer> entry : confirmedBookings.entrySet()) {
            System.out.println(entry.getKey() + " - Seat " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        T13FlightBookingManager manager = new T13FlightBookingManager();

        // Sample booking requests
        manager.addBookingRequest("Alice");
        manager.addBookingRequest("Bob");
        manager.addBookingRequest("Charlie");

        // Process bookings
        manager.processNextBooking();
        manager.processNextBooking();

        // Show current bookings
        manager.showConfirmedBookings();

        // Process remaining booking
        manager.processNextBooking();
        manager.showConfirmedBookings();
    }
}

//
//Problem 13: Flight Booking Manager (Queue, Map)
//Use a Queue for booking requests and a Map for confirmed bookings.
//Process bookings FIFO and update map with seat numbers.
//