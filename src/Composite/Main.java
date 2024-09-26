package Composite;



public class Main {
    public static void main(String[] args) {
        // Create departments
        Department orgDepartment = new Department("Business");
        Department devDepartment = new Department("UI design");
        Department salesDepartment = new Department("IT department");


        Employee boss = new Employee("Asifr", 200000);

        Employee emp1 = new Employee("Nahal", 10000);
        Employee emp2 = new Employee("Aliyan", 12000);
        Employee emp3 = new Employee("Zain", 70000);
        Employee emp4 = new Employee("Burak", 50000);


        orgDepartment.add(boss);
        devDepartment.add(emp1);
        devDepartment.add(emp2);
        salesDepartment.add(emp3);
        orgDepartment.add(devDepartment);
        orgDepartment.add(salesDepartment);
        orgDepartment.add(emp4);




        devDepartment.printData();


        System.out.println("Total Salary of Organization: " + orgDepartment.getSalary() + "\n");


        System.out.println(orgDepartment.toXml());
    }
}
