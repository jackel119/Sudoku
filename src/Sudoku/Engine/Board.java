/**
 * Created by jack on 3/28/17.
 */

package Sudoku.Engine;

import java.util.HashMap;

public class Board {

  //needs list of rows, columns, and squares
  private Cell[][] boardArray = new Cell[9][9];

  public Board(int[][] intArray) {
    if (intArray.length != 9 || intArray[0].length != 9) {
      //checks 9 rows, and that first row has 9 columns
      throw new IllegalArgumentException("Must be 9x9");
    } else {
      for (int row=0; row<9; row++) {
        for (int column=0; column<9; column++) {
          boardArray[row][column] = new Cell(intArray[row][column], row, column);
        }
      }
    }
  }

  public Board (int[] intArray) {
    if (intArray.length != 81) {
      //overall must be 81 squares
      throw new IllegalArgumentException("Array Length Must be 81 (9x9)");
    } else {
      for (int row=0; row<9; row++) {
        for (int column=0; column<9; column++) {
          boardArray[row][column] = new Cell(intArray[(row * 9) + column], row, column);
        }
      }
    }
  }

  private Cell get(int r, int c) {
    return boardArray[r][c];
  }

  public void updateValue(int r, int c, int newValue) {
    try {
      get(r, c).set(newValue);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }

  public void display() {
    System.out.println("\n    0 1 2   3 4 5   6 7 8");
    System.out.print("  - - - - - - - - - - - - -");
    for (int row=0; row<9; row++) {
      System.out.print("\n" + row + " ");
      for (int column=0; column<9; column++) {
        if ( column % 3 == 0) {
          System.out.print("| ");
        }
        System.out.print(get(row,column).toString());

      }

      System.out.print("| ");
      if ((row + 1) % 3 == 0) {
        System.out.print("\n  - - - - + - - - + - - - - ");
      }
    }
  }

}
