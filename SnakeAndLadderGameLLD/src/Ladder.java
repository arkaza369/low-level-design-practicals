public class Ladder implements BoardPiece{
    int souce;
    int destination;

    public Ladder(int souce, int destination) {
        this.souce = souce;
        this.destination = destination;
    }

    public int getSouce() {
        return souce;
    }

    public void setSouce(int souce) {
        this.souce = souce;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    @Override
    public int src() {
        return souce;
    }

    @Override
    public int dest() {
        return destination;
    }
}