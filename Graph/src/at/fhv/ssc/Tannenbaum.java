package at.fhv.ssc;

import java.util.ArrayList;

public class Tannenbaum {

    private boolean _undirected;
    private AdjacencyMatrix _matrix;
    private AdjacencyList _list;
    private ArrayList<Vertex> _closedList;
    private ArrayList<ArrayList<Vertex>> _paths;
    private int _max;


    // input: Graph mit 4 gelben und 3 blauen LED
    // jeder blaue mit jedem gelben verbunden und umgekehrt
    // output: G-B-G-B-G-B-G mit längstem möglichen Kabel (Edge-Weight)

    public Tannenbaum(AdjacencyMatrix matrix, AdjacencyList list) {
        _closedList = new ArrayList<Vertex>();                                        //edges auf dem weg speichern.
        _matrix = matrix;
        _list = list;
        _paths = new ArrayList<ArrayList<Vertex>>();

    }

    public void cableManagement() {
        // 1.) check UNDIRECTIONAL
        // 2.) check all routes from Yellow LEDs
        // 2.) check longest distances per Start-LED
        // 3.) check longest distance from all Start-LEDs

        if (undirectional()) {
            for (int i = 0; i < _list.getVertexList().size(); i++) {
                if (_list.getVertexList().get(i).getColour() == Colour.YELLOW) {
                    _closedList.clear();
                    _closedList.add(_list.getVertexList().get(i));
                    findPaths(_list.getVertexList().get(i));
                }
            }
            longestPath();
        }
    }


    //besuchte vertex speichern

    public void findPaths(Vertex vertex) {


        for (Vertex v : _list.getNeighbours(vertex)) {

            if (!_closedList.contains(v)) {

                _closedList.add(v);
                findPaths(v);
                _closedList.remove(v);
            }
        }
        if (_closedList.size() == _list.getVertexList().size()) {
            _paths.add(new ArrayList<Vertex>(_closedList));
        }
    }

    public void longestPath() {

        _max = 0;
        ArrayList<Edge> maxEdge = new ArrayList<Edge>();

        for (ArrayList<Vertex> a : _paths) {
            int temp = 0;
            for (int i = 0; i < a.size()-1; i++) {
                temp = temp + _list.getWeightBetween(a.get(i), a.get(i + 1));
            }
            if (temp > _max) {
                _max = temp;
            }
        }
    }


    public boolean undirectional() {                      //if symmetrical -> UNDIRECTIONAL!

        for (int i = 0; i <= _matrix.getArr().length - 2; i++) {
            for (int j = 1; j <= _matrix.getArr().length - 1; j++) {
                if (_matrix.getArr()[i][j] != _matrix.getArr()[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isUndirected() {
        return _undirected;
    }

    public void setUndirected(boolean undirected) {
        _undirected = undirected;
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

    public ArrayList<Vertex> getClosedList() {
        return _closedList;
    }

    public void setClosedList(ArrayList<Vertex> closedList) {
        _closedList = closedList;
    }

    public ArrayList<ArrayList<Vertex>> getPaths() {
        return _paths;
    }

    public void setPaths(ArrayList<ArrayList<Vertex>> paths) {
        _paths = paths;
    }

    public int getMax() {
        return _max;
    }

    public void setMax(int max) {
        _max = max;
    }
}


