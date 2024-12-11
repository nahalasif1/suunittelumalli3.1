package Command;

public class MoveCursorUpCommand implements Command {
    private final Cursor cursor;

    public MoveCursorUpCommand(Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public void execute() {
        cursor.moveCursor(0, -1);
    }
}
