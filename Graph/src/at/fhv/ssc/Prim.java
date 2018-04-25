package at.fhv.ssc;

import java.util.ArrayList;
import java.util.HashSet;

public class Prim {

    private Graph _graph;
    private HashSet<Vertex> _closedList;
    private HashSet<Vertex> _openList;

    public Prim(Graph graph) {
        _graph = graph;
    }

    public void create(){
        makeLists();
        doPrim();
        getPrimPath();
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

    public void doPrim() {

        Vertex n = null;

        while (_closedList.size() < _graph.getInterpreter().getVertexList().size()) {

            n = getMinimalNode();
            n.setVisited(true);
            _closedList.add(n);

            for (Vertex nn : _graph.getList().getNeighbours(n)) {
                if (!nn.isVisited()) {
                    if ((_graph.getList().getWeightBetween(n, nn)) < nn.getCost()) {

                        nn.setCost(_graph.getList().getWeightBetween(n, nn));
                        nn.setPredecessor(n);
                    }
                }
            }
        }
    }

    public ArrayList<Edge> getPrimPath() {

        ArrayList<Edge> liste = new ArrayList<Edge>();

        for (Vertex v : _openList) {

            for (Edge e : _graph.getInterpreter().getEdgeList()) {
                if (e.getStart() == v && e.getEnd() == v.getPredecessor()) {
                    liste.add(e);
                }
            }
        }
        return liste;
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
}

















