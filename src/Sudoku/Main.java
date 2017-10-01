package Sudoku;

import Sudoku.Engine.Board;

/**
 * Created by jack on 3/28/17.
 */
public class Main {

  private static final int[] testcase1
      = {0,1,0,0,0,5,0,0,4,0,0,0,0,9,8,0,5,0,8,0,5,0,7,0,1,0,3,0,4,0,0,5,0,0,8,1,2,8,0,6,0,4,0,9,0,
      1,7,0,0,2,0,0,6,0,5,0,2,0,4,0,9,0,7,0,6,0,9,8,0,0,0,0,9,0,0,5,0,0,0,4,0};

  public static void main(String[] args) {
    int[] emptyOne = new int[81];
    for (int i=0; i<81; i++) {
      emptyOne[i] = (i % 9);
    }

    Board testBoard = new Board(testcase1);

    testBoard.display();
    testBoard.updateValue(0,2,1);
    testBoard.display();

  }

}
