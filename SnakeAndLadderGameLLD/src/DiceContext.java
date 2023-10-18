public class DiceContext {
    Dice dice;
    public void setDice(Dice dice){
        this.dice = dice;
    }
    public int getThrow(){
        return dice.getThrow();
    }
}