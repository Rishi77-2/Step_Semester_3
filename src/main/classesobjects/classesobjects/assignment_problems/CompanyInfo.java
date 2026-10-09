package classesobjects.assignment_problems;

public class CompanyInfo {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        CompanyInfo e1 = new CompanyInfo("Ravi", 30000);
        CompanyInfo e2 = new CompanyInfo("Priya", 40000);
        CompanyInfo e3 = new CompanyInfo("Arjun", 35000);

        CompanyInfo.printCompanyInfo();
    }
}