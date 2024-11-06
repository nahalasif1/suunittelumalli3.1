package Visitor;

public class Main {
    public static void main(String[] args) {

        Directory root = new Directory("root");
        Directory subDir1 = new Directory("subDir1");
        Directory subDir2 = new Directory("subDir2");

        File file1 = new File("file1.txt", 10);
        File file2 = new File("file2.log", 15);
        File file3 = new File("file3.txt", 25);


        root.addElement(file1);
        root.addElement(subDir1);
        subDir1.addElement(file2);
        subDir1.addElement(subDir2);
        subDir2.addElement(file3);


        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        root.accept(sizeCalculator);
        System.out.println("Total size of all files: " + sizeCalculator.getTotalSize() + " MB");


        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);
        System.out.println("Files matching '.txt' pattern:");
        for (File file : searchVisitor.getMatchingFiles()) {
            System.out.println("- " + file.getName());
        }
    }
}
