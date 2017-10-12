package Sudoku.Engine;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by jack on 3/28/17.
 */
public class Cell {

  private Optional<Integer> value;
  private final int rowNo; // r is 0 to 8
  private final int columnNo; // c is 0 to 8
  private Set<Integer> possibleValues = new HashSet<>();
  private boolean settable;
  private Column column;
  private Row row;
  private Square3x3 parentSquare;

  public Cell(int v, int r, int c) {
    this.rowNo = r;
    this.columnNo = c;
    if (r < 0 || r > 8 || c < 0 || c > 8) {
      throw new IllegalArgumentException("rows and columns not within bounds");
    }

    if (v == 0) {
      this.value = Optional.empty();
      for (int i = 1; i < 10; i++) {
        possibleValues.add(new Integer(i));
      }
      this.settable = true;

    } else if (v < 10 && v > 0) {
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
    return rowNo;
  }

  public int getColumn() {
    return columnNo;
  }

  public String toString() {
    if (hasBeenSet()) {
      return getValue() + " ";
    } else {
      return "  ";
    }
  }

  public void setRow(Row r) {
    row = r;
  }

  public void setColumn(Column c) {
    column = c;
  }

  public void setParentSquare(Square3x3 s) {
    parentSquare = s;
  }

  public boolean hasBeenSet() {
    return value.isPresent();
  }

  public synchronized void set(int v) {
    if (!settable) {
      throw new IllegalArgumentException("This square is not settable");
    }
    if (possibleValues.contains(v) && checkGroupLegality(v)) {
      this.value = Optional.of(new Integer(v));
      row.removeMissing(v);
      column.removeMissing(v);
      parentSquare.removeMissing(v);
    } else if (v == 0) {
      this.value = Optional.empty();
    } else if (v < 0 || v > 9 ){
      throw new IllegalArgumentException("Value must be between 1 and 9");
    } else {
      throw new IllegalArgumentException("Invalid move. Cannot set cell at row, column: "
              + rowNo + columnNo + " to be " + v);
    }
  }

  private boolean checkGroupLegality(int i) {
    return row.isMissing(i) && column.isMissing(i) && parentSquare.isMissing(i);
  }

  public synchronized void removePossibility(int i) {
    if (!hasBeenSet()) {
      if (possibleValues.contains(i)) {
        possibleValues.remove(i);
      }
      if (possibleValues.size() == 1) {
        for (int j : possibleValues) {
          set(j);
        }
      }
    }
  }

}

