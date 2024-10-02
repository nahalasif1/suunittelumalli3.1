package TemplateMethod;

public class Player {
    private int id;
    private int lastGuess;

    public Player(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getLastGuess() {
        return lastGuess;
    }

    public void setLastGuess(int lastGuess) {
        this.lastGuess = lastGuess;
    }
}
