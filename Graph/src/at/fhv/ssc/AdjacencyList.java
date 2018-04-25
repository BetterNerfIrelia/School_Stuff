package at.fhv.ssc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class AdjacencyList extends AdjacencyStructure {

    private HashMap<Vertex, LinkedList<Edge>> _map;
    private ArrayList<Vertex> _vertexList;
    private ArrayList<Edge> _edgeList;

    //1 -> [2, 10]
    //2 -> [1, 10], [3, 30]
    //3 -> [1, 50]

    public void create(ArrayList<Vertex> vertexList, ArrayList<Edge> edgeList) {

        _vertexList = vertexList;
        _edgeList = edgeList;
        _map = new HashMap<Vertex, LinkedList<Edge>>();

        for (Vertex v : _vertexList) {
            LinkedList<Edge> list = new LinkedList<Edge>();
            _map.put(v, list);

            for (Edge e : _edgeList) {

                if (e.getStart().getValue() == v.getValue()) {

                    list.add(e);
                }
            }
        }
    }

    @Override
    public void print() {

        for (Vertex v : _vertexList) {

            for (Edge e : _map.get(v)) {

                if (e.getOperator() != null) {
                    System.out.println(e.getStart().getValue() + " -> [" + e.getEnd().getValue() + ", " + e.getWeight() + ", " + e.getOperator() + "]");
                } else {
                    System.out.println(e.getStart().getValue() + " -> [" + e.getEnd().getValue() + ", " + e.getWeight() + "]");
                }
            }
        }
        System.out.println("\n");

    }

    public int getWeightBetween(Vertex start, Vertex end) {

        for (Edge e : _map.get(start)) {
            if (e.getEnd().getValue() == end.getValue()) {
                return e.getWeight();
            }
        }
        return 0;
    }

    public ArrayList<Vertex> getNeighbours(Vertex v) {

        ArrayList<Vertex> liste = new ArrayList<Vertex>();

        for (Edge e : _map.get(v)) {
           liste.add(e.getEnd());
        }
        return liste;
    }


    public ArrayList<Vertex> getVertexList() {
        return _vertexList;
    }

    public void setVertexList(ArrayList<Vertex> vertexList) {
        _vertexList = vertexList;
    }

    public HashMap<Vertex, LinkedList<Edge>> getMap() {
        return _map;
    }

    public void setMap(HashMap<Vertex, LinkedList<Edge>> map) {
        _map = map;
    }

    public ArrayList<Edge> getEdgeList() {
        return _edgeList;
    }

    public void setEdgeList(ArrayList<Edge> edgeList) {
        _edgeList = edgeList;
    }
}







