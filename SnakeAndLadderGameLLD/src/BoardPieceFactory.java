import java.util.ArrayList;
import java.util.List;

public class BoardPieceFactory {
    public static BoardPieceFactory INSTANCE = new BoardPieceFactory();
    private BoardPieceFactory(){

    }
    public BoardPiece getBoardPiece(String line){
        String tokens[]  = line.split(" ");
        List<Integer> snakeBody = new ArrayList<Integer>();
        for(String token : tokens){
            int i=Integer.parseInt(token);
            snakeBody.add(i);
        }
        int ladderSrc = Integer.parseInt(tokens[1]);
        int ladderDest = Integer.parseInt(tokens[2]);

        if(tokens[0] == "S"){
            return new Snake(snakeBody);
        }
        else if(tokens[0] == "L"){
            return new Ladder(ladderSrc,ladderDest);
        }
        else return null;
    }
}