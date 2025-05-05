package Collection_Worksheet;
import java.util.*;

class Asset {
    private String assetId;
    private String name;
    private String type;
    private double value;

    public Asset(String assetId, String name, String type, double value) {
        this.assetId = assetId;
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getAssetId() {
        return assetId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return assetId.equals(asset.assetId); // Ensure unique asset IDs globally
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetId); // Ensure unique asset IDs globally
    }

    @Override
    public String toString() {
        return "Asset ID: " + assetId + ", Name: " + name + ", Type: " + type + ", Value: " + value;
    }
}

public class T11CompanyAssetTracker {

    private static Set<String> globalAssetIds = new HashSet<>();  // Global set to track asset IDs
    private static Map<String, Set<Asset>> departmentAssets = new HashMap<>();

    public static void main(String[] args) {
        // Add some assets to different departments
        addAsset("IT", new Asset("A101", "Laptop", "Electronics", 1200.50));
        addAsset("IT", new Asset("A102", "Projector", "Electronics", 700.00));
        addAsset("HR", new Asset("A103", "Chair", "Furniture", 150.00));
        addAsset("HR", new Asset("A101", "Desk", "Furniture", 200.00)); // Duplicate ID (should be detected)

        // Generate and print asset reports for each department
        generateAssetReport("IT");
        generateAssetReport("HR");
    }

    // Method to add an asset to a department and ensure global uniqueness
    private static void addAsset(String department, Asset asset) {
        if (globalAssetIds.contains(asset.getAssetId())) {
            System.out.println("Error: Duplicate Asset ID detected: " + asset.getAssetId());
            return; // Asset ID is already used, reject the new asset
        }

        // Add the asset globally
        globalAssetIds.add(asset.getAssetId());

        // Add the asset to the department's set
        departmentAssets.computeIfAbsent(department, k -> new HashSet<>()).add(asset);

        System.out.println("Asset added to " + department + " department: " + asset);
    }

    // Method to generate an asset report for a department
    private static void generateAssetReport(String department) {
        if (!departmentAssets.containsKey(department)) {
            System.out.println("No assets found for department " + department);
            return;
        }

        System.out.println("\nAsset Report for Department: " + department);
        Set<Asset> assets = departmentAssets.get(department);

        for (Asset asset : assets) {
            System.out.println(asset);
        }
    }
}
