package Builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() { computer.setProcessor("Intel i5"); }
    @Override
    public void buildRAM() { computer.setRamSize(16); }
    @Override
    public void buildHardDrive() { computer.setHardDrive("512 GB SSD"); }
    @Override
    public void buildGraphicsCard() { computer.setGraphicsCard("Integrated"); }
    @Override
    public void buildOperatingSystem() { computer.setOperatingSystem("Windows 10 Pro"); }

    @Override
    public Computer getComputer() { return this.computer; }
}

