package at.fhv.ssc;

import java.util.ArrayList;

public class EulerianSolver {

    private AdjacencyMatrix _matrix;
    private AdjacencyList _list;
    private boolean _isUndirectional;
    private boolean _isConnected;
    private boolean _isEulerian;
    private int[][] _arr;
    private ArrayList<Vertex> _closedList;
    private ArrayList<Edge> _closedEdges;
    private ArrayList<Edge> _counterEdges;
    private ArrayList<ArrayList<Edge>> _paths;
    private ArrayList<Edge> _edgeList;
    private ArrayList<Vertex> _vertexList;


    // 1) if symmetrical -> UNDIRECTIONAL!
    // 2) 1 true: first vertex can reach all other vertexes -> CONNECTED!
    // 3) 1,2 true: 0 or 2 vertexes have odd count of edges -> EULERIAN!
    // 4) 1,2,3 true: find EULERIAN PATH!

    public EulerianSolver(AdjacencyMatrix matrix, AdjacencyList list) {
        _matrix = matrix;
        _list = list;
        _closedList = new ArrayList<Vertex>();
        _closedEdges = new ArrayList<Edge>();
        _counterEdges = new ArrayList<Edge>();
        _paths = new ArrayList<ArrayList<Edge>>();

    }

    public EulerianSolver(AdjacencyMatrix matrix) {
        _matrix = matrix;
    }

    public EulerianSolver(AdjacencyList list) {
        _list = list;
    }

    public void solve() {
        if (undirectional()) {
            _isUndirectional = true;
        }
        connected(_list.getVertexList().get(1));
        if (checkCloseList()) {
            _isConnected = true;
        }
        if (eulerian()) {
            _isEulerian = true;
        }
    }

    public boolean undirectional() {                      //if symmetrical -> UNDIRECTIONAL!

        //[i][j]
        //i = 0, j = 1, count = 0;

        // [0,1] bis [0,länge-1]  0,3 jedes mal j++, am ende i++, count++,  j= 1 + count
        // [1,2] bis [1,länge-1]  1,3
        // [2,3] bis [2,länge-1]  2,3
        // imax = 2, jmax = 3

        for (int i = 0; i <= _matrix.getArr().length - 2; i++) {
            for (int j = 1; j <= _matrix.getArr().length - 1; j++) {
                if (_matrix.getArr()[i][j] != _matrix.getArr()[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void connected(Vertex vertex) {                          //nachher checkCloseList aufrufen.

        if ((vertex == null) || (_closedList.contains(vertex))) {
            return;
        }

        _closedList.add(vertex);

        for (Vertex v : (_matrix.neighbours(vertex))) {
            connected(v);
        }
    }

    public boolean checkCloseList() {

        for (Vertex v : _list.getVertexList()) {
            if (!_closedList.contains(v)) {
                return false;
            }
        }
        return true;
    }

    public boolean eulerian() {                           //0 or 2 vertexes have odd count of edges -> EULERIAN!

        _arr = _matrix.getArr();
        int columns = _arr[0].length;
        int rows = _arr.length;
        int oddCount = 0;
        int temp = 0;
        StringBuilder tempi = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            int count = 0;

            for (int j = 0; j < columns; j++) {

                if (_arr[i][j] != 0) {
                    count++;
                    temp = j;
                }
            }
            if (count % 2 != 0) {
                oddCount++;
                tempi.append(i + "," + temp);
            }
        }
        if (oddCount == 0 || oddCount == 2) {
            return true;
        } else {
            return false;
        }
    }


    public void findEulerianPath(Vertex vertex) {//find EULERIAN PATH!

        if (!_isUndirectional || !_isConnected || !_isEulerian) {
            return;
        }

        for (Edge e : _list.getMap().get(vertex)) {

            if (!_closedEdges.contains(e) && !_counterEdges.contains(e)) {

                _closedEdges.add(e);
                _counterEdges.add(counterEdge(e));
                if (_closedEdges.size() == _list.getEdgeList().size() / 2) {
                    if (_paths.isEmpty()) {
                        _paths.add(new ArrayList<>(_closedEdges));
                        return;
                    }
                } else {
                    findEulerianPath(e.getEnd());
                    _closedEdges.remove(e);
                    _counterEdges.remove(counterEdge(e));
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


    public void setUndirectional(boolean undirectional) {
        _isUndirectional = undirectional;
    }

    public void setConnected(boolean connected) {
        _isConnected = connected;
    }

    public void setEulerian(boolean eulerian) {
        _isEulerian = eulerian;
    }

    public boolean isUndirectional() {
        return _isUndirectional;
    }

    public boolean isConnected() {
        return _isConnected;
    }

    public boolean isEulerian() {
        return _isEulerian;
    }

    public int[][] getArr() {
        return _arr;
    }

    public void setArr(int[][] arr) {
        _arr = arr;
    }

    public ArrayList<Vertex> getClosedList() {
        return _closedList;
    }

    public void setClosedList(ArrayList<Vertex> closedList) {
        _closedList = closedList;
    }

    public ArrayList<Edge> getClosedEdges() {
        return _closedEdges;
    }

    public void setClosedEdges(ArrayList<Edge> closedEdges) {
        _closedEdges = closedEdges;
    }

    public ArrayList<Edge> getCounterEdges() {
        return _counterEdges;
    }

    public void setCounterEdges(ArrayList<Edge> counterEdges) {
        _counterEdges = counterEdges;
    }

    public ArrayList<ArrayList<Edge>> getPaths() {
        return _paths;
    }

    public void setPaths(ArrayList<ArrayList<Edge>> paths) {
        _paths = paths;
    }

    public ArrayList<Edge> getEdgeList() {
        return _edgeList;
    }

    public void setEdgeList(ArrayList<Edge> edgeList) {
        _edgeList = edgeList;
    }

    public ArrayList<Vertex> getVertexList() {
        return _vertexList;
    }

    public void setVertexList(ArrayList<Vertex> vertexList) {
        _vertexList = vertexList;
    }
}
