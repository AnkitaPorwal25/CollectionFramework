package Collection_Worksheet;

import java.util.*;

public class T12VotingSystem {

    public static void main(String[] args) {
        // Create a Map to store candidate names and vote counts
        Map<String, Integer> voteCounts = new HashMap<>();

        // Simulating votes for various candidates
        addVote(voteCounts, "John");
        addVote(voteCounts, "Jane");
        addVote(voteCounts, "John");
        addVote(voteCounts, "Jane");
        addVote(voteCounts, "Alice");
        addVote(voteCounts, "Bob");
        addVote(voteCounts, "Alice");

        // Display sorted candidates by vote count in descending order
        displayResults(voteCounts);
    }

    // Method to add a vote to a candidate
    private static void addVote(Map<String, Integer> voteCounts, String candidate) {
        // Increment the vote count for the candidate (if not present, initialize with 0)
        voteCounts.put(candidate, voteCounts.getOrDefault(candidate, 0) + 1);
    }

    // Method to display the results sorted by vote count in descending order
    private static void displayResults(Map<String, Integer> voteCounts) {
        // Create a list of Map entries and sort it by vote count in descending order
        List<Map.Entry<String, Integer>> sortedResults = new ArrayList<>(voteCounts.entrySet());

// Sort using Comparator.comparing() and reversed() for descending order
        sortedResults.sort(
                Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()
        );

        System.out.println("Election Results:");
        for (Map.Entry<String, Integer> entry : sortedResults) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }

    }
}

//
//
//Problem 12: Voting System (Map<String, Integer>)
//Build a voting system that:
//Tallies votes per candidate
//Sorts by vote count descending
//