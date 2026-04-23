import java.util.*;

class Customer {
    int id;
    String name;
    ArrayList<Account> accounts;

    Customer(int id, String name) {
        this.id = id;
        this.name = name;
        accounts = new ArrayList<>();
    }

    void addAccount(Account acc) {
        accounts.add(acc);
    }

    void display() {
        System.out.println("Customer ID: " + id + " | Name: " + name);
        for (Account acc : accounts) {
            acc.display();
        }
        System.out.println("-----------------------------");
    }
}

class Account {
    int accNo;
    double balance;

    Account(int accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void display() {
        System.out.println("Account No: " + accNo + " | Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    SavingsAccount(int accNo, double balance) {
        super(accNo, balance);
    }

    void withdraw(double amount) {
        if (balance - amount >= 500) {
            balance -= amount;
        } else {
            System.out.println("Minimum balance required in Savings Account");
        }
    }

    void display() {
        System.out.println("Savings Account No: " + accNo + " | Balance: " + balance);
    }
}

class LoanAccount extends Account {
    LoanAccount(int accNo, double balance) {
        super(accNo, balance);
    }

    void deposit(double amount) {
        balance -= amount;
    }

    void withdraw(double amount) {
        balance += amount;
    }

    void display() {
        System.out.println("Loan Account No: " + accNo + " | Loan Balance: " + balance);
    }
}

public class Bank {
    public static void main(String[] args) {

        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Account> accounts = new ArrayList<>();

        Customer c1 = new Customer(1, "Sid");
        Customer c2 = new Customer(2, "Riya");
        Customer c3 = new Customer(3, "Poppy");
        Customer c4 = new Customer(4, "Lana");

        Account s1 = new SavingsAccount(101, 2000);
        Account l1 = new LoanAccount(201, 5000);

        Account s2 = new SavingsAccount(102, 3000);
        Account l2 = new LoanAccount(202, 8000);

        Account s3 = new SavingsAccount(103, 4000);
        Account l3 = new LoanAccount(203, 6000);

        Account s4 = new SavingsAccount(104, 2500);
        Account l4 = new LoanAccount(204, 7000);

        accounts.add(s1); accounts.add(l1);
        accounts.add(s2); accounts.add(l2);
        accounts.add(s3); accounts.add(l3);
        accounts.add(s4); accounts.add(l4);

        c1.addAccount(s1); c1.addAccount(l1);
        c2.addAccount(s2); c2.addAccount(l2);
        c3.addAccount(s3); c3.addAccount(l3);
        c4.addAccount(s4); c4.addAccount(l4);

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);

        s1.deposit(500);
        s2.withdraw(1000);
        l1.deposit(1000);
        l2.withdraw(2000);

        System.out.println("===== BANK CUSTOMER DETAILS =====");

        for (Customer c : customers) {
            c.display();
        }
    }
}
