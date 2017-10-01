package Sudoku.Engine;


import java.util.Scanner;

public class Game {
    private static final Game instance = new Game();
    private Board board;
    private boolean isGameRunning = true;
    private int cellsLeft = 0;

    private Game(){};

    private Game(int[][] intArray){};

    public  void newGame(int[] intArray) {
        board = new Board(intArray);
        for (int i=0; i<81; i++) {
            if (intArray[i] != 0 ) {
                cellsLeft += 1;
            }
        }
        board.display();
    }

    public static Game getGame() {
        return instance;
    }

    public void gameLoop() {
        Scanner reader = new Scanner(System.in);
        String command;
        String[] s = new String[3];
        while (isGameRunning) {
            board.display();
            System.out.println("Please enter your next move in the format: ROW COLUMN VALUE");
            command = reader.nextLine();
            s = command.split("\\s+");
            makeMove(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        }
    }

    private void makeMove(int row, int column, int value) {
        if (board.updateValue(row, column, value)) {
            cellsLeft -= 1;
            if (cellsLeft == 0) {
                isGameRunning = false;
            }
        }
    }
}
