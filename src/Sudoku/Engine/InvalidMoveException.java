package Sudoku.Engine;

/**
 * Created by jack on 3/28/17.
 */
public class InvalidMoveException extends RuntimeException{
  private static final long serialVersionUID = -5365630128856068164L;

  public InvalidMoveException() {
  }

  public InvalidMoveException(String var1) {
    super(var1);
  }

  public InvalidMoveException(String var1, Throwable var2) {
    super(var1, var2);
  }

  public InvalidMoveException(Throwable var1) {
    super(var1);
  }
}
