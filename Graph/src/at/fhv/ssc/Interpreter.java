package at.fhv.ssc;

import java.util.ArrayList;

import static at.fhv.ssc.Operator.*;

public class Interpreter {

    private ArrayList<Edge> _edgeList;
    private ArrayList<Vertex> _vertexList;
    private StringBuilder _builder;


    public void createList(StringBuilder builder) {

        _builder = builder;
        _edgeList = new ArrayList<Edge>();
        _vertexList = new ArrayList<Vertex>();

        int i = 0;
        //Vertexes
        while (!(_builder.charAt(i) >= '0' && _builder.charAt(i) <= '9')) {         //searching for Numbers
            i++;
        }
        while (_builder.charAt(i) != 'E') {                                         //searching for end of Vertexes
            StringBuilder stringV = new StringBuilder();
            while (_builder.charAt(i) != ',' && _builder.charAt(i) != '}') {        //appending numbers
                stringV.append(_builder.charAt(i));
                i++;
            }
            int j = Integer.valueOf(stringV.toString());
            _vertexList.add(new Vertex(j));                                         //add new Vertexes
            i++;
        }
        //Edges
        while (!(_builder.charAt(i) >= '0' && _builder.charAt(i) <= '9')) {         //searching for Numbers
            i++;
        }
        while (i < _builder.length()) {                                               //searching for end of Input
            StringBuilder stringStart = new StringBuilder();
            StringBuilder stringEnd = new StringBuilder();
            StringBuilder stringWeight = new StringBuilder();
            StringBuilder stringOperator = new StringBuilder();
            while (_builder.charAt(i) != ',' && _builder.charAt(i) != ']') {        //appending numbers
                stringStart.append(_builder.charAt(i));
                i++;
            }
            i++;
            while (_builder.charAt(i) != ',') {                                     //three numbers
                stringEnd.append(_builder.charAt(i));
                i++;
            }
            i++;
            while (_builder.charAt(i) != ']') {
                if(_builder.charAt(i) == '+' || _builder.charAt(i) == '-' || _builder.charAt(i) == '*' || _builder.charAt(i) == '/'){
                    stringOperator.append(_builder.charAt(i));
                    i++;
                }
                stringWeight.append(_builder.charAt(i));
                i++;
            }
            int start = Integer.valueOf(stringStart.toString());
            int end = Integer.valueOf(stringEnd.toString());
            int weight = Integer.valueOf(stringWeight.toString());
            String operator = stringOperator.toString();



            Vertex startV = null;
            Vertex endV = null;

            for (Vertex v : _vertexList) {                                          //search Vertexes with matching values
                if (v.getValue() == start) {
                    startV = v;
                }
                if (v.getValue() == end) {
                    endV = v;
                }
            }

            if(operator.equals("+")){
                _edgeList.add(new Edge(startV, endV, weight, Operator.PLUS));                          //add a new Edge
            }
            else if(operator.equals("-")){
                _edgeList.add(new Edge(startV, endV, weight, Operator.MINUS));                          //add a new Edge
            }
            else if(operator.equals("*")){
                _edgeList.add(new Edge(startV, endV, weight, Operator.MULTIPLY));                          //add a new Edge
            }
            else if(operator.equals("/")){
                _edgeList.add(new Edge(startV, endV, weight, Operator.DIVIDE));                          //add a new Edge

            }
            else{_edgeList.add(new Edge(startV, endV, weight));                          //add a new Edge
            }
            i = i + 3;
        }
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

    public StringBuilder getBuilder() {
        return _builder;
    }

    public void setBuilder(StringBuilder builder) {
        _builder = builder;
    }


}
