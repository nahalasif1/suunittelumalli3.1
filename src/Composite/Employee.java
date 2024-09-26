package Composite;
public class Employee extends Entity {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public void printData() {
        System.out.println("Employee: " + name + ", Salary: " + salary);
    }

    @Override
    public void add(Entity entity) {
        throw new UnsupportedOperationException("Cannot add to an employee.");
    }

    @Override
    public void remove(Entity entity) {
        throw new UnsupportedOperationException("Cannot remove from an employee.");
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toXml() {
        return "<Employee name=\"" + name + "\" salary=\"" + salary + "\" />";
    }
}
