package Collection_Worksheet;
import java.util.*;
import java.util.stream.Collectors;

public class T7MovieRatingAggregator {
    public static void main(String[] args) {
        // Map: movie name → list of ratings
        Map<String, List<Integer>> movieRatings = new HashMap<>();

        // Sample data: ratings from users
        addRating(movieRatings, "Inception", 5);
        addRating(movieRatings, "Inception", 4);
        addRating(movieRatings, "The Matrix", 5);
        addRating(movieRatings, "The Matrix", 5);
        addRating(movieRatings, "The Matrix", 4);
        addRating(movieRatings, "Interstellar", 4);
        addRating(movieRatings, "Interstellar", 3);
        addRating(movieRatings, "Avatar", 2);
        addRating(movieRatings, "Avatar", 3);
        addRating(movieRatings, "Titanic", 5);
        addRating(movieRatings, "Titanic", 4);
        addRating(movieRatings, "Titanic", 5);

//        // Compute average ratings and store in a list
//        List<Map.Entry<String, Double>> averageRatings = new ArrayList<>();
//
//        for (Map.Entry<String, List<Integer>> entry : movieRatings.entrySet()) {
//            String movie = entry.getKey();
//            List<Integer> ratings = entry.getValue();
//
//            int sum = 0;
//            for (int rating : ratings) {
//                sum += rating;
//            }
//
//            double avg = ratings.isEmpty() ? 0.0 : (double) sum / ratings.size();
//
//            averageRatings.add(Map.entry(movie, avg));
//        }


        List<Map.Entry<String, Double>> averageRatings = movieRatings.entrySet().stream()
                .map(entry -> {
                    String movie = entry.getKey();
                    List<Integer> ratings = entry.getValue();
                    double avg = ratings.isEmpty() ? 0.0 :
                            ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
                    return Map.entry(movie, avg);
                })
                .collect(Collectors.toList());


        // Sort by descending average rating
        averageRatings.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        // Display sorted movies with average ratings
        System.out.println("Average Ratings (Descending):");
        for (Map.Entry<String, Double> entry : averageRatings) {
            System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue());
        }
    }

    // Helper to add a rating to a movie
    private static void addRating(Map<String, List<Integer>> map, String movie, int rating) {
        map.computeIfAbsent(movie, k -> new ArrayList<>()).add(rating);
    }
}


//
//Problem 7: Movie Rating Aggregator (Map, List)
//Users rate movies between 1-5.
//Store movie name -> list of ratings.
//Compute and display average rating per movie sorted descending.