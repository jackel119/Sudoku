package Sudoku.Engine;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
;import static java.util.concurrent.Executors.newFixedThreadPool;

public class Game {
    private static final Game instance = new Game();
    private Board board;
    private boolean isGameRunning = true;
    private int cellsLeft = 0;

    private Game(){};


    public  void newGame(int[] intArray) {
        for (int i=0; i<81; i++) {
            if (intArray[i] == 0 ) {
                cellsLeft += 1;
            }
        }
        board = new Board(intArray);
        System.out.println("Break");

        System.out.println("New Game started! Cells left = " + cellsLeft);
        board.display();
    }

    public static Game getGame() {
        return instance;
    }

    public void gameLoop() {
        Scanner reader = new Scanner(System.in);
        String command;
        String[] s = new String[3];
        System.out.println(cellsLeft);
        while (isGameRunning) {
            board.display();
            System.out.println("Please enter your next move in the format: ROW COLUMN VALUE");
            command = reader.nextLine();
            s = command.split("\\s+");
            makeMove(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        }
    }

    public void gameSolver() {
        System.out.println("Solving begins!");
        ArrayList<Row> rows = board.getRows();
        ArrayList<Column> columns = board.getColumns();
        ArrayList<Square3x3> parentsquares = board.getParentSquares();
        final long startTime = System.currentTimeMillis();
        int oldCellsLeft =0;
        ExecutorService eliminationpool = newFixedThreadPool(27);
        for (int r=0; r<100 && cellsLeft > 0; r++) {
            System.out.println("iteration round " + r + "\nCells left = " + cellsLeft);
            oldCellsLeft = cellsLeft;
            for (int i=0;i<9;i++) {
                rows.get(i).update();
                columns.get(i).update();
                parentsquares.get(i).update();
            }
            for (int i=0;i<9;i++) {
                eliminationpool.submit(new ElimThread(rows.get(i)));
                eliminationpool.submit(new ElimThread(columns.get(i)));
                eliminationpool.submit(new ElimThread(parentsquares.get(i)));
            }
            board.display();
            if (cellsLeft == oldCellsLeft) {
                System.out.println("No further progress can be made, exiting");
                break;
            }
        }
        eliminationpool.shutdown();
        final long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
    }

    private void makeMove(int row, int column, int value) {
        if (board.updateValue(row, column, value)) {
            cellsLeft -= 1;
            if (cellsLeft == 0) {
                isGameRunning = false;
            }
        }
    }

    protected void decCellsLeft() {
        cellsLeft -= 1;
    }
}
