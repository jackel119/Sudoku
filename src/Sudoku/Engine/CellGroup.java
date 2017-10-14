package Sudoku.Engine;

import java.util.*;

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
    // update();
  }

  public CellGroup() {
    this.cells = new ArrayList<>();
    for (int i=1; i <=9; i++) {
      missingValues.add(i);
    }
    // update();
  }
public void update() { for (Cell c : cells) {
      // System.out.println("Current cell row, column =" + c.getRow() + " " + c.getColumn());
      if (c.hasBeenSet()) {
        try {
          missingValues.remove(c.getValue());
          removeCellPossibilities(c.getValue());
        } catch (NoSuchElementException e) {

        }
      }
    }
    //try doing functionally
  }
  public boolean isMissing(int i) {
    return missingValues.contains(i);
  }

  public void removeCellPossibilities(int i) {
    for (Cell c : cells) {
        c.removePossibility(i);
    }
  }

  public Set<Integer> getMissingValues() {
    return missingValues;
  }

  public void addCell(Cell cell) {
    if (cells.size() > 9) {
      throw new RuntimeException("Too many cells in a group");
    } else {
      cells.add(cell);
    }
  }


  public void removeMissing(int i) {
    missingValues.remove(i);
  }

  public void printCells() {
    System.out.print("Set cells in this group are: ");
    for (Cell c : cells) {
      try {
        System.out.print(c.getValue() + " ");
      } catch (Exception e) {

      }
    }
    System.out.println("Missing values in this group are: ");
    for (Integer s : missingValues) {
      System.out.print(s + " ");
    }
    System.out.println();
  }

  public void eliminate() {
    HashMap<Integer, Cell> toSet = new HashMap<>();

    for (Integer i : missingValues) {
      int count = 0;
      for (Cell c : cells) {
        if (c.couldBe(i)) {
          count++;
        }
      }
      if (count == 1) {
        for (Cell c: cells) {
          if (c.couldBe(i)) {
            toSet.put(i, c);
          }
        }
      }
    }

    for (Integer i : toSet.keySet()) {
      toSet.get(i).set(i);
      // System.out.println("Setting cell at row, column: " + toSet.get(i).getRow() + " " + toSet.get(i).getColumn() + " to value " + i + " by elimination");
    }
  }

}
