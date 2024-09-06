import java.util.List;

public class Employee implements Organization {

    private String name;
    private double salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void add(Organization organization) {

    }

    @Override
    public void remove(Organization organization) {

    }

    @Override
    public List<Organization> getChildren() {
        return null;
    }

    @Override
    public String getDetails() {
        return "<Employee name=\"" + name + "\" salary=\"" + salary + "\"/>";
    }

}