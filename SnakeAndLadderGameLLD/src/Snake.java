import java.util.List;

public class Snake implements BoardPiece{
    List<Integer> body;

    public Snake(List<Integer> body) {
        this.body = body;
    }

    public List<Integer> getBody() {
        return body;
    }

    public void setBody(List<Integer> body) {
        this.body = body;
    }
    @Override
    public int src() {
        return body.get(0);
    }
    @Override
    public int dest() {
        return body.get(body.size()-1);
    }
}