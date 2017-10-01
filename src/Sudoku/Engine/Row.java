package Sudoku.Engine;

import java.util.List;

/**
 * Created by jack on 3/28/17.
 */
public class Row extends CellGroup{

  private final int rowNumber;

  public Row(List<Cell> cells) {
    super(cells);
    rowNumber = cells.get(0).getRow();

    for (Cell c : cells) { // checks that everything is in the same row
      if (c.getRow() != rowNumber) {
        throw new SomethingIsVeryVeryVeryWrongException();
      }
    }

  }


  public Row(int i) {
    super();
    rowNumber = i;


  }

}
