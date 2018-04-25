package at.fhv.ssc;

import java.util.ArrayList;

public class DragonSolver {

    private AdjacencyMatrix _matrix;
    private AdjacencyList _list;
    private ArrayList<ArrayList<Edge>> _paths;
    private ArrayList<Edge> _maxEdge;
    private ArrayList<Edge> _minEdge;
    private ArrayList<Edge> _nineNineNineEdge;
    private int _min;
    private int _max;
    private ArrayList<Edge> _closedList;
    private ArrayList<Edge> _CounterClosedList;
    private ArrayList<Edge> _edgeList;
    private boolean _interupted;

    public DragonSolver(AdjacencyMatrix matrix, AdjacencyList list) {
        _closedList = new ArrayList<Edge>();                                        //edges auf dem weg speichern.
        _CounterClosedList = new ArrayList<Edge>();
        _matrix = matrix;
        _list = list;
        _paths = new ArrayList<ArrayList<Edge>>();

    }

    public void solve(Vertex vertex) {
    }

    public void findPaths(Vertex vertex) {

        // von Vertex 1 weg Weg zum letzen Vertex suchen, Weg speichern. besuchte edges in closedList<edges>
        // wenn letzter Vertex erreicht, weg(closedList<Edges> durchiterieren toString (Edge => z.b. "+42")
        // ab erstem vertex weg rekursiv für alle pfade.
        // rechnen: in _paths ist  jeder pfad gespeichert. dann pfad => int diamonds = startwert,
        // schauen ob rechnung durchführbar, dann foreach String : _paths (Operator) (Weight) = ergebnis.
        // 3 spezielle Pfade suchen: Min, Max, 999. startwert: 33.

        for (Edge e : _list.getMap().get(vertex)) {

            if (!_closedList.contains(e) && !_CounterClosedList.contains(e)) {

                if (e.getEnd().getValue() == _list.getVertexList().size() - 1) {
                    _closedList.add(e);
                    _CounterClosedList.add(counterEdge(e));
                    _paths.add(new ArrayList<>(_closedList));
                    findPaths(e.getEnd());
                    _closedList.remove(e);
                    _CounterClosedList.remove(counterEdge(e));
                } else {
                    _closedList.add(e);
                    _CounterClosedList.add(counterEdge(e));
                    findPaths(e.getEnd());
                    _closedList.remove(e);
                    _CounterClosedList.remove(counterEdge(e));
                }
            }
        }
    }

    public Edge counterEdge(Edge edge) {
        int start = edge.getEnd().getValue();
        int end = edge.getStart().getValue();

        for (Edge e : _edgeList) {
            if (e.getStart().getValue() == start && e.getEnd().getValue() == end) {
                return e;
            }
        }
        return null;
    }

    public void calculatePaths() {

        // rechnen: in _paths ist  jeder pfad gespeichert. dann pfad => int diamonds = startwert,
        // schauen ob rechnung durchführbar, dann foreach String : _paths (Operator) (Weight) = ergebnis.
        // 3 spezielle Pfade suchen: Min, Max, 999. startwert: 33.

        _max = 0;
        _min = Integer.MAX_VALUE;
        _maxEdge = new ArrayList<Edge>();
        _minEdge = new ArrayList<Edge>();
        _nineNineNineEdge = new ArrayList<Edge>();
        _interupted = false;

        for (ArrayList<Edge> a : _paths) {
            int diamonds = 33;
            for (Edge e : a) {
                if (e.getOperator().equals(Operator.MULTIPLY)) {
                    diamonds = diamonds * e.getWeight();
                }
                if (e.getOperator().equals(Operator.DIVIDE)) {
                    if (diamonds % e.getWeight() != 0) {
                        _interupted = true;
                        break;
                    } else {

                    }        diamonds = diamonds / e.getWeight();
                }
                if (e.getOperator().equals(Operator.PLUS)) {
                    diamonds = diamonds + e.getWeight();
                }
                if (e.getOperator().equals(Operator.MINUS)) {
                    if (diamonds - e.getWeight() <= 0) {
                        _interupted = true;
                        break;
                    } else {
                        diamonds = diamonds - e.getWeight();
                    }
                }
            }//ende Edge
            if (!isInterupted()) {
                if (diamonds > _max) {
                    _max = diamonds;
                    _maxEdge.clear();
                    _maxEdge.addAll(a);
                }
                if (diamonds < _min) {
                    _min = diamonds;
                    _minEdge.clear();
                    _minEdge.addAll(a);
                }
                if (diamonds == 999) {
                    _nineNineNineEdge.addAll(a);
                }
            }_interupted = false;
        }//end ArrayList
    }

    public AdjacencyMatrix getMatrix() {
        return _matrix;
    }

    public void setMatrix(AdjacencyMatrix matrix) {
        _matrix = matrix;
    }

    public AdjacencyList getList() {
        return _list;
    }

    public void setList(AdjacencyList list) {
        _list = list;
    }

    public ArrayList<ArrayList<Edge>> getPaths() {
        return _paths;
    }

    public void setPaths(ArrayList<ArrayList<Edge>> paths) {
        _paths = paths;
    }

    public ArrayList<Edge> getMaxEdge() {
        return _maxEdge;
    }

    public void setMaxEdge(ArrayList<Edge> maxEdge) {
        _maxEdge = maxEdge;
    }

    public ArrayList<Edge> getMinEdge() {
        return _minEdge;
    }

    public void setMinEdge(ArrayList<Edge> minEdge) {
        _minEdge = minEdge;
    }

    public ArrayList<Edge> getNineNineNineEdge() {
        return _nineNineNineEdge;
    }

    public void setNineNineNineEdge(ArrayList<Edge> nineNineNineEdge) {
        _nineNineNineEdge = nineNineNineEdge;
    }

    public ArrayList<Edge> getClosedList() {
        return _closedList;
    }

    public void setClosedList(ArrayList<Edge> closedList) {
        _closedList = closedList;
    }

    public ArrayList<Edge> getEdgeList() {
        return _edgeList;
    }

    public void setEdgeList(ArrayList<Edge> edgeList) {
        _edgeList = edgeList;
    }

    public int getMin() {
        return _min;
    }

    public void setMin(int min) {
        _min = min;
    }

    public int getMax() {
        return _max;
    }

    public void setMax(int max) {
        _max = max;
    }

    public ArrayList<Edge> getCounterClosedList() {
        return _CounterClosedList;
    }

    public void setCounterClosedList(ArrayList<Edge> counterClosedList) {
        _CounterClosedList = counterClosedList;
    }

    public boolean isInterupted() {
        return _interupted;
    }

    public void setInterupted(boolean interupted) {
        _interupted = interupted;
    }
}


