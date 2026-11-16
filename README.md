
class Employee {

    private int empId;
    private String name;
    private double basicSalary;
    private String department;

    // Parameterized constructor
    Employee(int empId, String name, double basicSalary, String department) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
        this.department = department;
    }

    // Overloaded constructor
    Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = 30000;
        this.department = "General";
    }

    // Getter methods
    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public String getDepartment() {
        return department;
    }

    // Calculate HRA
    public double calculateHRA() {
        return basicSalary * 0.20;
    }

    // Calculate DA
    public double calculateDA() {
        return basicSalary * 0.50;
    }

    // Calculate PF
    public double calculatePF() {
        return basicSalary * 0.12;
    }

    // Gross Salary
    public double getGrossSalary() {
        return basicSalary + calculateHRA() + calculateDA();
    }

    // Calculate Tax
    public double calculateTax() {
        return getGrossSalary() * 0.10;
    }

    // Net Salary
    public double getNetSalary() {
        return getGrossSalary() - calculatePF() - calculateTax();
    }

    // toString method
    public String toString() {
        return "Employee ID: " + empId +
               "\nName: " + name +
               "\nDepartment: " + department +
               "\nBasic Salary: " + basicSalary +
               "\nHRA: " + calculateHRA() +
               "\nDA: " + calculateDA() +
               "\nGross Salary: " + getGrossSalary() +
               "\nPF: " + calculatePF() +
               "\nTax: " + calculateTax() +
               "\nNet Salary: " + getNetSalary();
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, "John", 50000, "Engineering");

        Employee e2 = new Employee(2, "Jane");

        Employee e3 = new Employee(3, "Sam", 100000, "Management");

        Employee e4 = new Employee(4, "Zero", 0, "General");

        System.out.println("===== EMPLOYEE PAYROLL SYSTEM =====");

        System.out.println("\nEmployee 1");
        System.out.println(e1);

        System.out.println("\nEmployee 2");
        System.out.println(e2);

        System.out.println("\nEmployee 3");
        System.out.println(e3);

        System.out.println("\nEmployee 4");
        System.out.println(e4);
    }
}
