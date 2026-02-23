package id.ac.polban.employee;

import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        Department itDept = new Department("IT");
        EmploymentType permanent = new EmploymentType("Permanent");
        
        Employee emp1 = new Employee(101, "test", itDept, permanent, 5000000);
        EmployeeService service = new EmployeeService();
        
        service.addEmployee(emp1);
        System.out.println(service.getEmployee(101));
        
        service.raiseSalary(101, 10); // gaji naik 10%
        System.out.println("Total Karyawan (Static): " + Employee.getEmployeeCount());
    }
}