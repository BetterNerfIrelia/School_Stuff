package at.fhv.ssc;

public class Edge {

    private Vertex _start;
    private Vertex _end;
    private int _weight;
    private Operator _operator;

    public Edge(Vertex start, Vertex end, int weight) {
        _start = start;
        _end = end;
        _weight = weight;
    }

    public Edge(Vertex start, Vertex end, int weight, Operator operator) {
        _start = start;
        _end = end;
        _weight = weight;
        _operator = operator;
    }

    public Edge(Vertex start, Vertex end) {
        _start = start;
        _end = end;
        _weight = 1;
        _operator = null;
    }

    public String toString(){

        StringBuilder str = new StringBuilder();
        if(_operator.equals("+")) {
            str.append("+");
            str.append(_weight);
        }
        if(_operator.equals("-")) {
            str.append("-");
            str.append(_weight);
        }
        if(_operator.equals("-")) {
            str.append("-");
            str.append(_weight);
        }
        if(_operator.equals("-")) {
            str.append("-");
            str.append(_weight);
        }
        return str.toString();
    }

    public Vertex getStart() {
        return _start;
    }

    public void setStart(Vertex start) {
        _start = start;
    }

    public Vertex getEnd() {
        return _end;
    }

    public void setEnd(Vertex end) {
        _end = end;
    }

    public int getWeight() {
        return _weight;
    }

    public void setWeight(int weight) {
        _weight = weight;
    }

    public Operator getOperator() {
        return _operator;
    }

    public void setOperator(Operator operator) {
        _operator = operator;
    }
}

