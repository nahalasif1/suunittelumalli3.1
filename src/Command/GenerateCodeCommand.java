package Command;

public class GenerateCodeCommand implements Command {
    private final Cursor cursor;

    public GenerateCodeCommand(Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public void execute() {
        cursor.generateCode();
    }
}

