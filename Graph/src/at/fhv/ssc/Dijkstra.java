package at.fhv.ssc;

import java.util.ArrayList;
import java.util.HashSet;

public class Dijkstra {

    private Graph _graph;
    private HashSet<Vertex> _closedList;
    private HashSet<Vertex> _openList;
    private Vertex _end;


    public Dijkstra(Graph graph) {
        _graph = graph;
    }

    public void create(Vertex vertex){
        makeLists();
        doDijkstra(vertex);
    }

    public void makeLists() {

        _closedList = new HashSet<Vertex>();
        _openList = new HashSet<Vertex>();

        for (Vertex v : _graph.getInterpreter().getVertexList()) {

            if (v.getValue() == 1) {
                v.setCost(0);
            } else {
                v.setCost(999999999);
            }
            v.setVisited(false);
            _openList.add(v);
        }
    }

    public Vertex getMinimalNode() {
        int min = 999999999;
        Vertex minVertex = null;
        for (Vertex v : _openList) {
            if ((!v.isVisited())) {
                if (v.getCost() < min) {
                    min = v.getCost();
                    minVertex = v;
                }
            }
        }
        return minVertex;
    }

    public void doDijkstra(Vertex end) {

        _end = end;
        Vertex n = null;

        while (_closedList.size() < _graph.getInterpreter().getVertexList().size()) {

            n = getMinimalNode();
            n.setVisited(true);
            _closedList.add(n);

            for (Vertex nn : _graph.getList().getNeighbours(n)) {
                if (!nn.isVisited()) {
                    if (n.getCost() + (_graph.getList().getWeightBetween(n, nn)) < nn.getCost()) {

                        nn.setCost(n.getCost() + (_graph.getList().getWeightBetween(n, nn)));
                        nn.setPredecessor(n);
                    }
                }
            }
        }
    }

    public HashSet<Vertex> getClosedList() {
        return _closedList;
    }

    public void setClosedList(HashSet<Vertex> closedList) {
        _closedList = closedList;
    }

    public Graph getGraph() {
        return _graph;
    }

    public void setGraph(Graph graph) {
        _graph = graph;
    }

    public HashSet<Vertex> getOpenList() {
        return _openList;
    }

    public void setOpenList(HashSet<Vertex> openList) {
        _openList = openList;
    }
}
