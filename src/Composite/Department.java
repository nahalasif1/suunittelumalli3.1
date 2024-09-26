package Composite;



import java.util.ArrayList;
import java.util.List;

public class Department extends Entity {
    private final List<Entity> employees = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void printData() {
        System.out.println("Department: " + name);
        for (Entity employee : employees) {
            employee.printData();
        }
        System.out.println(""); // Empty line for better readability
    }

    @Override
    public void add(Entity entity) {
        employees.add(entity);
    }

    @Override
    public void remove(Entity entity) {
        employees.remove(entity);
    }

    @Override
    public double getSalary() {
        double totalSalary = 0;
        for (Entity employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    @Override
    public String toXml() {
        StringBuilder xml = new StringBuilder();
        xml.append("<Department name=\"" + name + "\">\n");
        for (Entity component : employees) {
            xml.append(component.toXml()).append("\n");
        }
        xml.append("</Department>");
        return xml.toString();
    }
}
