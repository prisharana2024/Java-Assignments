import java.util.Scanner;

// Defining class name
public class Calculator {

    // Defining data members
    double num1, num2;

    // Defining member functions
    public double addNumbers(double num1, double num2) {
        return num1 + num2;
    }

    public double subtractNumbers(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplyNumbers(double num1, double num2) {
        return num1 * num2;
    }

    public double divideNumbers(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: Division by zero!");
            return 0;
        }
        return num1 / num2;
    }

    public double modulusNumbers(double num1, double num2) {
        return num1 % num2;
    }

    // Main method
    public static void main(String args[]) {

        Calculator c = new Calculator();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Calculator Menu ---");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 5) {
                System.out.print("Enter first number: ");
                c.num1 = sc.nextDouble();

                System.out.print("Enter second number: ");
                c.num2 = sc.nextDouble();
            } else if (choice == 6) {
                System.out.println("Exiting calculator...");
                break;
            } else {
                System.out.println("Invalid choice!!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Result: " + c.addNumbers(c.num1, c.num2));
                    break;
                case 2:
                    System.out.println("Result: " + c.subtractNumbers(c.num1, c.num2));
                    break;
                case 3:
                    System.out.println("Result: " + c.multiplyNumbers(c.num1, c.num2));
                    break;
                case 4:
                    System.out.println("Result: " + c.divideNumbers(c.num1, c.num2));
                    break;
                case 5:
                    System.out.println("Result: " + c.modulusNumbers(c.num1, c.num2));
                    break;
            }

        } while (choice != 6);

        sc.close();
    }
}