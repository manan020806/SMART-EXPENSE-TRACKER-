import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    double amount;
    String category;
    String date;

    Expense(double amount, String category, String date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    void display() {
        System.out.println("Amount: ₹" + amount + " | Category: " + category + " | Date: " + date);
    }
}

public class ExpenseTracker {
    static ArrayList<Expense> expenses = new ArrayList<>();

    public static void addExpense(Scanner sc) {
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter category (Food/Travel/Other): ");
        String category = sc.nextLine();

        System.out.print("Enter date (DD-MM-YYYY): ");
        String date = sc.nextLine();

        expenses.add(new Expense(amount, category, date));
        System.out.println("✅ Expense Added!");
    }

    public static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        for (Expense e : expenses) {
            e.display();
        }
    }

    public static void totalExpenses() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }
        System.out.println("💰 Total Spending: ₹" + total);
    }

    public static void filterByCategory(Scanner sc) {
        System.out.print("Enter category to filter: ");
        String cat = sc.nextLine();

        boolean found = false;
        for (Expense e : expenses) {
            if (e.category.equalsIgnoreCase(cat)) {
                e.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expenses found for this category.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Spending");
            System.out.println("4. Filter by Category");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addExpense(sc);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    totalExpenses();
                    break;
                case 4:
                    filterByCategory(sc);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}