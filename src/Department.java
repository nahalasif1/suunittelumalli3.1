import java.util.ArrayList;
import java.util.List;

public class Department implements Organization {

    String name;
    private List<Organization> children = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String getName() {

        return name;
    }

    @Override
    
    public double getSalary() {
        double salary = 0;
        for (Organization child : children) {
            salary += child.getSalary();
        }
        return salary;
    }

    @Override
    public void add(Organization organization) {
        children.add(organization);
    }

    @Override
    public void remove(Organization organization) {
        children.remove(organization);
    }

    @Override
    public List<Organization> getChildren() {
        return children;
    }

    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append("<Department name=\"").append(name).append("\">\n");
        if (!children.isEmpty()) {
            for (Organization child : children) {
                details.append(child.getDetails()).append("\n");
            }
        }
        details.append("</Department>");
        return details.toString();
    }
}