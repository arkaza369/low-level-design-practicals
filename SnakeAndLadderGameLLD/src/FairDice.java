public class FairDice implements Dice{
    @Override
    public int getThrow() {
        return (int)Math.random()*6 + 1;
    }
}
