/**
 * Created by jack on 3/28/17.
 */

package Sudoku.Engine;

import java.util.ArrayList;

public class Board {

  //needs list of rows, columns, and squares
  private Cell[][] boardArray = new Cell[9][9];
  private ArrayList<Row> rows = new ArrayList<>();
  private ArrayList<Column> columns = new ArrayList<>();
  private ArrayList<Square3x3> parentSquares = new ArrayList<>();

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
      initializeGroups();
    }
  }

  public Board (int[] intArray) {
    // Initializes the cell array
    if (intArray.length != 81) {
      //overall must be 81 squares
      throw new IllegalArgumentException("Array Length Must be 81 (9x9)");
    } else {
      for (int row=0; row<9; row++) {
        for (int column=0; column<9; column++) {
          boardArray[row][column] = new Cell(intArray[(row * 9) + column], row, column);
        }
      }
      initializeGroups();
      System.out.println("test");
    }
    // Initializes the groups and adds the cells to them
  }

  private Cell get(int r, int c) {
    return boardArray[r][c];
  }

  public ArrayList<Column> getColumns() {
    return columns;
  }

  public ArrayList<Row> getRows() {
    return rows;
  }

  public ArrayList<Square3x3> getParentSquares() {
    return parentSquares;
  }

  public boolean updateValue(int r, int c, int newValue) {
    try {
      get(r, c).set(newValue);
      return true;

    } catch (IllegalArgumentException e) {
      System.out.println("Invalid move");
      return false;
      // e.printStackTrace();
    }
  }

  private void initializeGroups() {
    for (int i=1;i<10;i++) {
      rows.add(new Row(i));
      columns.add(new Column(i));
      parentSquares.add(new Square3x3(i));
    }
    // Set rows and columns
    for (int i=0;i<9;i++) {
      for (int j=0; j<9; j++) {

        rows.get(i).addCell(boardArray[i][j]);
        boardArray[i][j].setRow(rows.get(i));

        columns.get(i).addCell(boardArray[j][i]);
        boardArray[j][i].setColumn(columns.get(i));

        parentSquares.get( 3 * (i / 3) + (j / 3)).addCell(boardArray[i][j]);
        boardArray[i][j].setParentSquare(parentSquares.get( 3 * (i / 3) + (j / 3) ));
      }
    }

    /*
    for (int i=0; i<9; i++) {
      System.out.println("Square = " + i);
      parentSquares.get(i).printCells();
    }
    */

    for (int i=0; i<9; i++) {
      // System.out.println("Updating Row" + i);
      rows.get(i).update();
      // System.out.println("Updating Column" + i);
      columns.get(i).update();
      // System.out.println("Updating Square" + i);
      parentSquares.get(i).update();
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
    System.out.println("\n");
  }

}
