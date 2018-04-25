package at.fhv.ssc;

public class Vertex {

    private int _value;
    private boolean _visited;
    private Colour _colour;
    private int _cost;
    private Vertex _predecessor;

    public Vertex(int value) {
        _value = value;
    }

    public int getValue() {
        return _value;
    }

    public void setValue(int value) {
        _value = value;
    }

    public boolean isVisited() {
        return _visited;
    }

    public void setVisited(boolean visited) {
        _visited = visited;
    }

    public Colour getColour() {
        return _colour;
    }

    public void setColour(Colour colour) {
        _colour = colour;
    }

    public int getCost() {
        return _cost;
    }

    public void setCost(int cost) {
        _cost = cost;
    }

    public Vertex getPredecessor() {
        return _predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        _predecessor = predecessor;
    }

}
