import java.io.*;
import java.util.*;

// User-defined Exceptions
class MinimumBalanceException extends Exception {
    public MinimumBalanceException(String msg) {
        super(msg);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class InvalidCIDException extends Exception {
    public InvalidCIDException(String msg) {
        super(msg);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String msg) {
        super(msg);
    }
}

// Customer Class
class Customer implements Serializable {
    int cid;
    String cname;
    double amount;

    Customer(int cid, String cname, double amount) {
        this.cid = cid;
        this.cname = cname;
        this.amount = amount;
    }

    void display() {
        System.out.println("CID: " + cid + ", Name: " + cname + ", Balance: " + amount);
    }
}

// Main Class
public class BankSystem {
    static ArrayList<Customer> customers = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Create Account
    static void createAccount() {
        try {
            System.out.print("Enter CID (1-20): ");
            int cid = sc.nextInt();
            sc.nextLine();

            if (cid < 1 || cid > 20)
                throw new InvalidCIDException("CID must be between 1 and 20!");

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Amount: ");
            double amt = sc.nextDouble();

            if (amt < 1000)
                throw new MinimumBalanceException("Minimum balance is Rs. 1000!");

            if (amt <= 0)
                throw new InvalidAmountException("Amount must be positive!");

            Customer c = new Customer(cid, name, amt);
            customers.add(c);

            System.out.println("✅ Account Created Successfully!");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // Deposit
    static void deposit() {
        try {
            System.out.print("Enter CID: ");
            int cid = sc.nextInt();

            System.out.print("Enter Deposit Amount: ");
            double amt = sc.nextDouble();

            if (amt <= 0)
                throw new InvalidAmountException("Amount must be positive!");

            for (Customer c : customers) {
                if (c.cid == cid) {
                    c.amount += amt;
                    System.out.println("✅ Deposit Successful!");
                    return;
                }
            }
            System.out.println("❌ Customer not found!");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // Withdraw
    static void withdraw() {
        try {
            System.out.print("Enter CID: ");
            int cid = sc.nextInt();

            System.out.print("Enter Withdraw Amount: ");
            double amt = sc.nextDouble();

            if (amt <= 0)
                throw new InvalidAmountException("Amount must be positive!");

            for (Customer c : customers) {
                if (c.cid == cid) {
                    if (amt > c.amount)
                        throw new InsufficientBalanceException("Not enough balance!");

                    c.amount -= amt;
                    System.out.println("✅ Withdrawal Successful!");
                    return;
                }
            }
            System.out.println("❌ Customer not found!");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // Display
    static void display() {
        for (Customer c : customers) {
            c.display();
        }
    }

    // Save to File
    static void saveToFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("customers.dat"));
            oos.writeObject(customers);
            oos.close();
            System.out.println("✅ Data saved to file!");
        } catch (Exception e) {
            System.out.println("❌ File Error: " + e.getMessage());
        }
    }

    // Load from File
    static void loadFromFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("customers.dat"));
            customers = (ArrayList<Customer>) ois.readObject();
            ois.close();
            System.out.println("✅ Data loaded from file!");
        } catch (Exception e) {
            System.out.println("❌ File Error: " + e.getMessage());
        }
    }

    // Main Menu
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: display(); break;
                case 5: saveToFile(); break;
                case 6: loadFromFile(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }
}