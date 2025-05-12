package Collection_Worksheet;

import java.util.Comparator;
import java.util.TreeSet;

class Player {
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " (Score: " + score + ")";
    }
}

public class T9LeaderBoardTracker {

    public static void main(String[] args) {
        // Create a TreeSet with a custom comparator to sort players by score in descending order
        TreeSet<Player> leaderboard = new TreeSet<>(new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                // Compare by score in descending order
                return Integer.compare(p2.getScore(), p1.getScore());
            }
        });

        // Add players to the leaderboard
        leaderboard.add(new Player("Alice", 150));
        leaderboard.add(new Player("Bob", 200));
        leaderboard.add(new Player("Charlie", 180));
        leaderboard.add(new Player("Diana", 220));

        // Print leaderboard
        System.out.println("Leaderboard:");
        printLeaderboard(leaderboard);

        // Update Bob's score to 250
        updatePlayerScore(leaderboard, "Bob", 250);

        // Print leaderboard after score update
        System.out.println("\nLeaderboard after score update:");
        printLeaderboard(leaderboard);
    }

    // Method to update a player's score
    private static void updatePlayerScore(TreeSet<Player> leaderboard, String playerName, int newScore) {
        // Find the player by name and update their score
        for (Player player : leaderboard) {
            if (player.getName().equals(playerName)) {
                // Remove the player from the TreeSet, update the score, and re-add them
                leaderboard.remove(player);
                player.setScore(newScore);
                leaderboard.add(player);
                break;
            }
        }
    }

    // Method to print the leaderboard
    private static void printLeaderboard(TreeSet<Player> leaderboard) {
        for (Player player : leaderboard) {
            System.out.println(player);
        }
    }
}

//
//Problem 9: Leaderboard Tracker (TreeSet, Comparator)
//Track player scores using TreeSet<Player>  sorted by score descending.
//Update a player's score and maintain correct leaderboard order.