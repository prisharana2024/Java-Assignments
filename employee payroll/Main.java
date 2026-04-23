abstract class Employee {
    String name;
    String PANNo;
    String joiningDate;
    String designation;
    int empId;

    // Constructor
    Employee(String name, String PANNo, String joiningDate, String designation, int empId) {
        this.name = name;
        this.PANNo = PANNo;
        this.joiningDate = joiningDate;
        this.designation = designation;
        this.empId = empId;
    }

    // Abstract Method
    abstract double calcCTC();

    // Display Method
    void displayDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("PAN No: " + PANNo);
        System.out.println("Joining Date: " + joiningDate);
        System.out.println("Designation: " + designation);
    }
}

// Full Time Employee
class FullTimeEmployee extends Employee {
    double baseSalary;
    double perfBonus;
    String role;

    FullTimeEmployee(String name, String PANNo, String joiningDate, String designation, int empId,
                     double baseSalary, double perfBonus, String role) {
        super(name, PANNo, joiningDate, designation, empId);
        this.baseSalary = baseSalary;
        this.perfBonus = perfBonus;
        this.role = role;
    }

    // calcCTC based on role
    double calcCTC() {
        if (role.equalsIgnoreCase("SWE")) {
            return baseSalary + perfBonus;
        } 
        else if (role.equalsIgnoreCase("HR")) {
            double hiringCommission = 5000;
            return baseSalary + hiringCommission;
        } 
        else {
            return baseSalary;
        }
    }
}

// Contract Employee
class ContractEmployee extends Employee {
    int noOfHrs;
    double hourlyRate;

    ContractEmployee(String name, String PANNo, String joiningDate, String designation, int empId,
                     int noOfHrs, double hourlyRate) {
        super(name, PANNo, joiningDate, designation, empId);
        this.noOfHrs = noOfHrs;
        this.hourlyRate = hourlyRate;
    }

    // calcCTC for contract
    double calcCTC() {
        return noOfHrs * hourlyRate;
    }
}

// Manager (child of FullTimeEmployee)
class Manager extends FullTimeEmployee {
    double TA;
    double eduAllowance;

    Manager(String name, String PANNo, String joiningDate, String designation, int empId,
            double baseSalary, double perfBonus, String role,
            double TA, double eduAllowance) {
        super(name, PANNo, joiningDate, designation, empId, baseSalary, perfBonus, role);
        this.TA = TA;
        this.eduAllowance = eduAllowance;
    }

    // Manager-specific CTC
    double calcCTC() {
        return baseSalary + perfBonus + TA + eduAllowance;
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        // Full Time Employee (SWE)
        FullTimeEmployee emp1 = new FullTimeEmployee(
                "Aayush", "ABCDE1234F", "01-01-2023", "SWE", 101,
                50000, 10000, "SWE"
        );

        // Full Time Employee (HR)
        FullTimeEmployee emp2 = new FullTimeEmployee(
                "Pooja", "XYZAB5678L", "05-02-2023", "HR", 102,
                40000, 0, "HR"
        );

        // Contract Employee
        ContractEmployee emp3 = new ContractEmployee(
                "Riya", "PQRSX5678K", "15-02-2024", "Consultant", 103,
                120, 500
        );

        // Manager
        Manager manager = new Manager(
                "Rahul", "LMNOP9876Z", "10-03-2022", "Manager", 104,
                80000, 20000, "SWE",
                5000, 7000
        );

        // Output
        System.out.println("\n--- Full Time Employee (SWE) ---");
        emp1.displayDetails();
        System.out.println("Gross salary: " + emp1.calcCTC());

        System.out.println("\n--- Full Time Employee (HR) ---");
        emp2.displayDetails();
        System.out.println("Gross salary: " + emp2.calcCTC());

        System.out.println("\n--- Contract Employee ---");
        emp3.displayDetails();
        System.out.println("Gross salary: " + emp3.calcCTC());

        System.out.println("\n--- Manager ---");
        manager.displayDetails();
        System.out.println("Gross salary: " + manager.calcCTC());
    }
}
