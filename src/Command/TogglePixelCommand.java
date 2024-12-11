package Command;

public class TogglePixelCommand implements Command {
    private final Cursor cursor;

    public TogglePixelCommand(Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public void execute() {
        cursor.togglePixel();
    }
}
