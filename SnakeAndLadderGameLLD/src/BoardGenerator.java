import java.util.List;

public class BoardGenerator {
    public Board generateBoard(List<String> configs){
        //assuming first line inside config file would be board size.
        int boardSize = Integer.parseInt(configs.get(0));
        Board board = new Board(boardSize);
        Boolean line1 = true;
        for(String line : configs){
            //line1 will contain board size not board piece.
            if(line1){
                line1 = false;
                continue;
            }
            BoardPiece current = BoardPieceFactory.INSTANCE.getBoardPiece(line);
            //filling cells with board pieces
            board.getCellAtPosition(current.src()).setBoardPiece();
        }
        return board;


    }
}