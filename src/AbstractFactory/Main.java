package AbstractFactory;

public class Main {
    public static void main(String[] args) {

        UIFactory aFactory = new AFactory();
        Button buttonA = aFactory.createButton("OK");
        TextField textFieldA = aFactory.createTextField("Username");
        Checkbox checkboxA = aFactory.createCheckbox("Remember me");

        System.out.println("Factory A Components:");
        buttonA.display();
        textFieldA.display();
        checkboxA.display();

        System.out.println("\nUpdating content dynamically...");
        buttonA.setText("Submit");
        textFieldA.setText("Enter name");
        checkboxA.setText("Accept terms");


        buttonA.display();
        textFieldA.display();
        checkboxA.display();

        UIFactory bFactory = new BFactory();
        Button buttonB = bFactory.createButton("Send");
        TextField textFieldB = bFactory.createTextField("Password");
        Checkbox checkboxB = bFactory.createCheckbox("Stay signed in");

        System.out.println("\nFactory B Components:");
        buttonB.display();
        textFieldB.display();
        checkboxB.display();
    }
}
