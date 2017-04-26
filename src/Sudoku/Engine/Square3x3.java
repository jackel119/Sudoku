package Sudoku.Engine;

import java.util.List;

/**
 * Created by jack on 3/28/17.
 */
public class Square3x3 extends CellGroup{

  public Square3x3(List<Cell> cells) {
    super(cells);
    int squareIndexDown = cells.get(0).getRow() / 3;
    int squareIndexRight = cells.get(0).getColumn() / 3;


    for (Cell c : cells) { // checks that everything is in the same row
      if (c.getRow() / 3 != squareIndexDown || c.getColumn() / 3 != squareIndexRight) {
        throw new SomethingIsVeryVeryVeryWrongException();
      }
    }
  }
}
