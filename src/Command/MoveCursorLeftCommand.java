package Command;

public class MoveCursorLeftCommand implements Command {
    private final Cursor cursor;

    public MoveCursorLeftCommand(Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public void execute() {
        cursor.moveCursor(-1, 0);
    }
}
