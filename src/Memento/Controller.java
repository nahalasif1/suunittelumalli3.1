package Memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history;
    private List<IMemento> redoHistory;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            IMemento previousState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(previousState);
            history.add(previousState);
            gui.updateGui();
        }
    }

    public void undo() {
        if (!history.isEmpty()) {
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            redoHistory.add(previousState);
            gui.updateGui();
        }
    }

    public void restoreState(IMemento memento) {
        model.restoreState(memento);
        gui.updateGui();
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        redoHistory.clear();
    }

    public List<IMemento> getHistory() {
        return history;
    }
}

