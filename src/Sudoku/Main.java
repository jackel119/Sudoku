package Sudoku;

import Sudoku.Engine.Board;
import Sudoku.Engine.Game;

/**
 * Created by jack on 3/28/17.
 */
public class Main {

  private static final int[] testcase1
      =  {0,4,3, 6,8,0, 0,0,0,
          1,8,0, 5,0,7, 0,0,0,
          0,0,0, 0,0,0, 9,0,0,

          0,7,5, 0,0,1, 3,6,0,
          0,9,0, 8,0,0, 0,0,1,
          0,0,6, 0,0,0, 0,8,9,

          0,0,7, 4,0,2, 0,0,0,
          0,6,0, 9,0,3, 0,0,0,
          0,0,0, 0,5,0, 0,0,0};


  private static final int[] testcase2
          =  {0,8,0, 0,9,4, 0,0,0,
              0,0,9, 1,7,0, 0,0,0,
              4,0,1, 0,0,0, 0,0,3,

              0,0,8, 0,0,0, 0,2,0,
              5,0,0, 9,1,3, 0,0,8,
              0,9,0, 0,0,0, 4,0,0,

              3,0,0, 0,0,0, 8,0,6,
              0,0,0, 0,5,8, 2,0,0,
              0,0,0, 2,3,0, 0,4,0};

  public static void main(String[] args) {
    int[] emptyOne = new int[81];
    for (int i=0; i<81; i++) {
      emptyOne[i] = (i % 9);
    }

    // Game.getGame().newGame(testcase1);
    // Game.getGame().gameSolver();
    Game.getGame().newGame(testcase2);
    Game.getGame().gameSolver();
  }

}
