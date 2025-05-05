package Collection_Worksheet;

import java.util.*;

class Transaction {
    private String transactionId;
    private double amount;
    private Date transactionTime;
    private String type; // "deposit" or "withdrawal"

    public Transaction(String transactionId, double amount, Date transactionTime, String type) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.transactionTime = transactionTime;
        this.type = type;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + ", Type: " + type + ", Amount: " + amount +
                ", Time: " + transactionTime;
    }
}

public class T10BankTransactionLog {

    public static void main(String[] args) {
        // Creating a Map to store transactions keyed by account number
        Map<String, List<Transaction>> transactionLog = new HashMap<>();

        // Add transactions for account "A123"
        String account1 = "A123";
        addTransaction(transactionLog, account1, new Transaction("T001", 1000.00, new Date(2025, 4, 10, 10, 30), "deposit"));
        addTransaction(transactionLog, account1, new Transaction("T002", 200.00, new Date(2025, 4, 10, 12, 30), "withdrawal"));
        addTransaction(transactionLog, account1, new Transaction("T003", 1500.00, new Date(2025, 4, 10, 9, 0), "deposit"));

        // Add transactions for account "B456"
        String account2 = "B456";
        addTransaction(transactionLog, account2, new Transaction("T004", 500.00, new Date(2025, 4, 11, 11, 0), "deposit"));
        addTransaction(transactionLog, account2, new Transaction("T005", 100.00, new Date(2025, 4, 11, 10, 0), "withdrawal"));

        // Generate and print statements for each account
        generateStatement(transactionLog, account1);
        generateStatement(transactionLog, account2);
    }

    // Method to add a transaction to the log
    private static void addTransaction(Map<String, List<Transaction>> transactionLog, String accountNumber, Transaction transaction) {
        transactionLog.computeIfAbsent(accountNumber, k -> new ArrayList<>()).add(transaction);
    }

    // Method to generate a statement for an account, sorted by transaction time
    private static void generateStatement(Map<String, List<Transaction>> transactionLog, String accountNumber) {
        if (!transactionLog.containsKey(accountNumber)) {
            System.out.println("No transactions found for account " + accountNumber);
            return;
        }

        List<Transaction> transactions = transactionLog.get(accountNumber);

        // Sort transactions by transaction time
        transactions.sort(Comparator.comparing(Transaction::getTransactionTime));

        System.out.println("\nTransaction Statement for Account: " + accountNumber);
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
