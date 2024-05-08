import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getname() {
        return name;

    }

    public int getid() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + " , id=" + id + ",salary=" + calculateSalary() + "]";
    }

}

class FullTimeEmployee extends Employee {
    private double monthSalary;

    public FullTimeEmployee(String name, int id, double monthSalary) {
        super(name, id);
        this.monthSalary = monthSalary;
    }

    @Override
    public double calculateSalary() {
        return monthSalary;
    }

}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee :employeeList) {
            if (employee.getid() == id) {
                employeeToRemove = employee;
                break;
            }
        }

        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

class Main {
    public static void main(String[] args) {

       

        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("rajnish", 1, 23600);
        FullTimeEmployee emp3= new FullTimeEmployee("sagar", 2, 40000);
        FullTimeEmployee emp4= new FullTimeEmployee("prnajul", 3, 30000);
        FullTimeEmployee emp5= new FullTimeEmployee("prnajul", 4, 30000);
        FullTimeEmployee emp6= new FullTimeEmployee("akarshit", 5, 23600);
        FullTimeEmployee emp7= new FullTimeEmployee("rahul", 6, 30000);



        PartTimeEmployee emp2 = new PartTimeEmployee("suraj", 2, 8, 10);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);
        payrollSystem.addEmployee(emp5);
        payrollSystem.addEmployee(emp6);
        payrollSystem.addEmployee(emp7);

        System.out.println("intial Employee deatails:");
        payrollSystem.displayEmployees();
        System.out.println("Removing employee");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee DEatails");
        payrollSystem.displayEmployees();
    }
}