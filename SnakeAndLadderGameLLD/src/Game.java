import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    DiceContext diceContext;
    Deque<Player> players = new LinkedList<>();
    public Game(){
        init();
    }


    public void init(){
        //strategy pattern to select config reader type
        ConfigReaderContext configReaderContext = new ConfigReaderContext();
        ConfigReader configReader = new TXTConfigReader();
        configReaderContext.setConfigReader(configReader);
        //Generate board based on specific config
        BoardGenerator boardGenerator = new BoardGenerator();
        board = boardGenerator.generateBoard(configReaderContext.getConfigs());
        //set dice type,Strategy pattern to select dice type.
        diceContext= new DiceContext();
        diceContext.setDice(new FairDice());
        //add players
        addPlayers();
    }
    public void startGame(){
        while(true){
            Player player = getCurrentPlayer();
            nextMove(player);
        }

    }
    public void nextMove(Player player){
        int position = player.position;
        //current player will roll the dice.
        int nextPosition = diceContext.getThrow() + position;
        if(nextPosition > 100){
            //do nothing
        }
        else if(nextPosition == 100){
            System.out.println(player.name + " is winner.Game over hence EXITING...!");
            System.exit(1);
        }
        else{
            //update player position
            if(board.getCellAtPosition(nextPosition).hasBoardPiece()){
                nextPosition = board.getCellAtPosition(nextPosition).getBoardPiece().dest();
                player.position = nextPosition;
            }

        }
    }
    private void addPlayers() {
        //NOTE: Hardcoded the players here, but players could be inside config file, then need to take from file.
        Player player1 = new Player("arkaza", 0);
        Player player2 = new Player("singh", 0);
        players.add(player1);
        players.add(player2);
    }
    private Player getCurrentPlayer() {
        Player currentPlayer = players.removeFirst();
        players.addLast(currentPlayer);
        return currentPlayer;
    }
}