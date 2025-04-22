import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String category;
    double amount;

    public Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Category: " + category + ", Amount: ₹" + amount;
    }
}

public class ExpenseTracker {
    private static final ArrayList<Expense> expenses = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Calculate Total Spending");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> addExpense();
                case 2 -> viewExpenses();
                case 3 -> calculateTotal();
                case 4 -> {
                    System.out.println("Exiting... Stay financially smart!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again!");
            }
        }
    }

    private static void addExpense() {
        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();

        System.out.print("Enter amount spent: ₹");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        expenses.add(new Expense(category, amount));
        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        System.out.println("\nRecorded Expenses:");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    private static void calculateTotal() {
        double total = expenses.stream().mapToDouble(e -> e.amount).sum();
        System.out.println("Total Money Spent: ₹" + total);
    }
}
