package Sudoku.Engine;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by jack on 3/28/17.
 */
public class Cell {

  private Optional<Integer> value;
  private final int row; // r is 0 to 8
  private final int column; // c is 0 to 8
  private Set<Integer> possibleValues = new HashSet<>();
  private boolean settable;

  public Cell(int v, int r, int c) {
    this.row = r;
    this.column = c;
    if (r < 0 || r > 8 || c < 0 || c > 8) {
      throw new IllegalArgumentException("rows and columns not within bounds");
    }

    if (v == 0) {
      this.value = Optional.empty();
      for (int i=1; i<10; i++) {
        possibleValues.add(new Integer(i));
      }
      this.settable = true;

    } else if (v <10 && v > 0) {
      this.value = Optional.of(new Integer(v));
      this.settable = false;

    } else {
      throw new IllegalArgumentException("value out of bounds");
    }
  }

  public Integer getValue() {
    return value.get();
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

  public String toString() {
    if (!hasBeenSet()) {
      return getValue() + " ";
    } else {
      return "  ";
    }
  }

  public boolean hasBeenSet() {
    return !value.isPresent();
  }

  public void set(int v) {
    if (!settable) {
      throw new IllegalArgumentException("This square is not settable");
    }
    if (v <= 9 && v > 0) {
      this.value = Optional.of(new Integer(v));
    } else if (v == 0) {
      this.value = Optional.empty();
    } else {
      throw new IllegalArgumentException("Value must be between 1 and 9");
    }
  }

}
