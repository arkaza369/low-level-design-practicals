import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Cell> cells;
    int boardSize;

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public Board(int boardSize){
        this.boardSize = boardSize;
        initializeCell(boardSize);

    }
    public Cell getCellAtPosition(int pos){
        return cells.get(pos);
    }
    public void initializeCell(int boardSize){
        cells = new ArrayList<>(boardSize);
        for(int i=0;i<boardSize;i++) {
            Cell cell = new Cell();
            cells.add(i,cell);
        }
    }
}