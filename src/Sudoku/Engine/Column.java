package Sudoku.Engine;

import java.util.List;

/**
 * Created by jack on 3/28/17.
 */
public class Column extends CellGroup{

  private final int colNumber;

  public Column(List<Cell> cells) {
    super(cells);
    colNumber = cells.get(0).getRow();

    for (Cell c : cells) { // checks that everything is in the same row
      if (c.getRow() != colNumber) {
        throw new SomethingIsVeryVeryVeryWrongException();
      }
    }

  }

  public Column(int i) {
    super();
    colNumber = i;
  }
}
