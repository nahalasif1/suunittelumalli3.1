package TemplateMethod;

import java.util.Random;
import java.util.Scanner;


public class GuessingGame extends Game {
    private Player[] players;
    private int targetNumber;
    private Scanner scanner;

    @Override
    public void initializeGame(int numberOfPlayers) {
        players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player(i + 1);
        }
        targetNumber = new Random().nextInt(100) + 1;
        scanner = new Scanner(System.in);
        System.out.println("The game has started! Guess the number between 1 and 100.");
    }

    @Override
    public boolean endOfGame() {

        for (Player player : players) {
            if (player.getLastGuess() == targetNumber) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void playSingleTurn(int playerInTurn) {
        Player currentPlayer = players[playerInTurn];
        System.out.println("Player " + currentPlayer.getId() + ", make your guess:");


        int guess = scanner.nextInt();
        currentPlayer.setLastGuess(guess);


        if (guess < targetNumber) {
            System.out.println("Too low!");
        } else if (guess > targetNumber) {
            System.out.println("Too high!");
        } else {
            System.out.println("Correct! Player " + currentPlayer.getId() + " guessed the number.");
        }
    }

    @Override
    public void displayWinner() {

        for (Player player : players) {
            if (player.getLastGuess() == targetNumber) {
                System.out.println("Player " + player.getId() + " wins by guessing the number " + targetNumber + "!");
                break;
            }
        }
    }
}
