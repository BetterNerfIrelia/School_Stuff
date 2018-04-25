package at.fhv.ssc;

import java.util.ArrayList;

public class AdjacencyMatrix extends AdjacencyStructure {

    private int[][] _arr;
    private ArrayList<Vertex> _vertexList;
    private ArrayList<Edge> _edgeList;

    //     1   2   3
    //1    0   10  0
    //2    10  0   30
    //3    50  0   0

    public void create(ArrayList<Vertex> vertexList, ArrayList<Edge> edgeList) {

        _vertexList = vertexList;
        _edgeList = edgeList;

        _arr = new int[_vertexList.size()][_vertexList.size()];

        for (int i = 1; i <= _vertexList.size(); i++) {

            for (Edge e : edgeList) {

                if (e.getStart().getValue() == i) {
                    for (int j = 1; j <= _vertexList.size(); j++) {
                        if (e.getEnd().getValue() == j) {
                            _arr[i - 1][j - 1] = e.getWeight();
                        }
                    }

                }
            }
        }
    }

    @Override
    public void print() {

        System.out.println("---------------------------");
        System.out.print("\t");

        for (int i = 0; i < _vertexList.size(); i++) {
            System.out.print(i + 1 + "\t");
        }

        System.out.println("\n" + "---------------------------");

        for (int i = 0; i < _vertexList.size(); i++) {
            System.out.print(i + 1 + "\t");
            for (int j = 0; j < _vertexList.size(); j++) {
                System.out.print(_arr[i][j] + "\t");
            }
            System.out.println("\n" + "---------------------------");
        }
        System.out.println("\n");
    }

    public int[][] getArr() {
        return _arr;
    }

    public void setArr(int[][] arr) {
        _arr = arr;
    }

    public ArrayList<Vertex> neighbours(Vertex vertex) {

        ArrayList<Vertex> neighbours = new ArrayList<Vertex>();

        for (int i = 0; i < _arr[0].length; i++) {
            if (_arr[vertex.getValue() - 1][i] != 0) {

                neighbours.add(_vertexList.get(i));
            }
        }
        return neighbours;
    }


}
