package Composite;


public abstract class Entity {
    protected String name;

    public Entity(String name) {
        this.name = name;
    }

    public abstract void printData();
    public abstract void add(Entity entity);
    public abstract void remove(Entity entity);
    public abstract double getSalary();
    public abstract String toXml();
}
