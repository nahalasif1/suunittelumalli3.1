
import java.util.List;

public interface Organization {
    String getName();
    double getSalary();
    void add(Organization organization);
    void remove(Organization organization);
    List<Organization> getChildren();
    String getDetails();
}
