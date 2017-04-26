package Sudoku.Engine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jack on 3/28/17.
 */
public abstract class CellGroup {

  private Set<Integer> missingValues = new HashSet<>();

  private List<Cell> cells;

  public CellGroup(List<Cell> cells) {
    this.cells = new ArrayList<>();

    for (int i=1; i <=9; i++) {
      this.cells.add(cells.get(i - 1));
      missingValues.add(i);
    }
    updateMissing();
  }

  public CellGroup() {
    this.cells = new ArrayList<>();
    for (int i=1; i <=9; i++) {
      missingValues.add(i);
    }
    updateMissing();
  }

  private void updateMissing() {
    for (Cell c : cells) {
      if (c.hasBeenSet()) {
        missingValues.remove(c.getValue());
      }
    }
    //try doing functionally
  }

  private void removeMissing(int i) {
    missingValues.remove(i);
  }

}
