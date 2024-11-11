package Builder;

public class GamingComputerBuilder implements ComputerBuilder {
    private final Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() { computer.setProcessor("Intel i9"); }
    @Override
    public void buildRAM() { computer.setRamSize(32); }
    @Override
    public void buildHardDrive() { computer.setHardDrive("1 TB SSD"); }
    @Override
    public void buildGraphicsCard() { computer.setGraphicsCard("NVIDIA RTX 3090"); }
    @Override
    public void buildOperatingSystem() { computer.setOperatingSystem("Windows 10"); }

    @Override
    public Computer getComputer() { return this.computer; }
}
