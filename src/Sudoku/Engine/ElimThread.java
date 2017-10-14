package Sudoku.Engine;

public class ElimThread implements Runnable{

    private CellGroup group;

    public ElimThread(CellGroup cs) {
        group = cs;
    }

    @Override
    public void run() {
        group.eliminate();
    }
}
