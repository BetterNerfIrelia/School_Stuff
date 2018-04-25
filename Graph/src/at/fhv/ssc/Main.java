package at.fhv.ssc;

import java.io.File;

public class Main {

    public static void main(String[] args) {  //TODO: Alles über GRAPH aufrufen.

        //------Graph-Creation----------------------------------------------------------------------------------------//

        Graph graphM = new Graph();
        graphM.createGraph(new File("C:\\Users\\schie\\Desktop\\Übungen\\Graph\\input.txt"), new AdjacencyMatrix());
        Graph graphL = new Graph();
        graphL.createGraph(new File("C:\\Users\\schie\\Desktop\\Übungen\\Graph\\input.txt"), new AdjacencyList());
        System.out.println(graphM.readInput(new File("C:\\Users\\schie\\Desktop\\Übungen\\Graph\\input.txt")) + "\n");
        Graph graphE = new Graph();
        graphE.createGraph(new File("C:\\Users\\schie\\Desktop\\Übungen\\Graph\\nikolaus.txt"), new AdjacencyMatrix(), new AdjacencyList());
        Graph dragonGraph = new Graph();
        dragonGraph.createGraph(new File("C:\\Users\\schie\\Desktop\\Übungen\\Graph\\dragon.txt"), new AdjacencyMatrix(), new AdjacencyList());
        Graph tannenGraph = new Graph();
        tannenGraph.createGraph(new File("C:\\Users\\schie\\Desktop\\Übungen\\Graph\\oh_tannenbaum.txt"), new AdjacencyMatrix(), new AdjacencyList());
        Graph dijkstraGraph = new Graph();
        dijkstraGraph.createGraph(new File("C:\\Users\\schie\\Desktop\\Übungen\\Graph\\dijkstra.txt"), new AdjacencyMatrix(), new AdjacencyList());
        Graph primGraph = new Graph();
        primGraph.createGraph(new File("C:\\Users\\schie\\Desktop\\Übungen\\Graph\\prim.txt"), new AdjacencyMatrix(), new AdjacencyList());

        //------Adjacency-Matrix--------------------------------------------------------------------------------------//

        graphM.getMatrix().create(graphM.getInterpreter().getVertexList(), graphM.getInterpreter().getEdgeList());
        graphM.printMatrix();

        //------Adjacency-List----------------------------------------------------------------------------------------//

        graphL.getList().create(graphL.getInterpreter().getVertexList(), graphL.getInterpreter().getEdgeList());
        graphL.printList();

        //------Eulerian-Path-(open/closed)---------------------------------------------------------------------------//

        graphE.getList().create(graphE.getInterpreter().getVertexList(), graphE.getInterpreter().getEdgeList());
        graphE.getMatrix().create(graphE.getInterpreter().getVertexList(), graphE   .getInterpreter().getEdgeList());
        graphE.setEuler(new EulerianSolver(graphE.getMatrix(), graphE.getList()));
        graphE.getEuler().setEdgeList(graphE.getInterpreter().getEdgeList());
        graphE.getEuler().setVertexList(graphE.getInterpreter().getVertexList());
        graphE.getEuler().solve();
        graphE.getEuler().findEulerianPath(graphE.getInterpreter().getVertexList().get(0));

        //------Multiplicandus-Testing--------------------------------------------------------------------------------//

        dragonGraph.getMatrix().create(dragonGraph.getInterpreter().getVertexList(), dragonGraph.getInterpreter().getEdgeList());
        dragonGraph.getList().create(dragonGraph.getInterpreter().getVertexList(), dragonGraph.getInterpreter().getEdgeList());
        dragonGraph.printList();
        dragonGraph.setDragon(new DragonSolver(dragonGraph.getMatrix(), dragonGraph.getList()));
        dragonGraph.getDragon().setEdgeList(dragonGraph.getInterpreter().getEdgeList());
        dragonGraph.getDragon().findPaths(dragonGraph.getInterpreter().getVertexList().get(0));
        dragonGraph.getDragon().calculatePaths();
        System.out.println("Min: " + dragonGraph.getDragon().getMin());
        System.out.println("Max: " + dragonGraph.getDragon().getMax());

        System.out.print(dragonGraph.getDragon().getPaths().size());

        //------Tannenbaum-Testing------------------------------------------------------------------------------------//

        tannenGraph.getMatrix().create(tannenGraph.getInterpreter().getVertexList(), tannenGraph.getInterpreter().getEdgeList());
        tannenGraph.getList().create(tannenGraph.getInterpreter().getVertexList(), tannenGraph.getInterpreter().getEdgeList());
        tannenGraph.printList();
        for(Vertex v : tannenGraph.getInterpreter().getVertexList()){
            if(v.getValue() == 2 || v.getValue() == 3 || v.getValue() == 6 || v.getValue() == 7 ){
                v.setColour(Colour.YELLOW);
            }
        }
        tannenGraph.setTannenbaum(new Tannenbaum(tannenGraph.getMatrix(), tannenGraph.getList()));
        tannenGraph.getTannenbaum().cableManagement();
        System.out.println("Tannenbaum Max: " + tannenGraph.getTannenbaum().getMax());
        System.out.print("\n");

        //------Dijkstra-Testing--------------------------------------------------------------------------------------//

        dijkstraGraph.getList().create(dijkstraGraph.getInterpreter().getVertexList(), dijkstraGraph.getInterpreter().getEdgeList());
        dijkstraGraph.getMatrix().create(dijkstraGraph.getInterpreter().getVertexList(), dijkstraGraph.getInterpreter().getEdgeList());
        Dijkstra dijkstra = new Dijkstra(dijkstraGraph);
        dijkstra.create(dijkstraGraph.getInterpreter().getVertexList().get(5));
        System.out.println("Dijkstra: ");
        for(Vertex v : dijkstra.getOpenList()){
            System.out.println(v.getCost());
        }
        System.out.print("\n");

        //------Prim-Testing------------------------------------------------------------------------------------------//

        primGraph.getList().create(primGraph.getInterpreter().getVertexList(), primGraph.getInterpreter().getEdgeList());
        primGraph.getMatrix().create(primGraph.getInterpreter().getVertexList(), primGraph.getInterpreter().getEdgeList());
        Prim prim = new Prim(primGraph);
        prim.create();
        System.out.println("Prim: ");

        for(Edge e : prim.getPrimPath()){
            System.out.println(e.getWeight());
        }
        System.out.print("\n");

        //------Eight-Puzzle-Testing----------------------------------------------------------------------------------//

        System.out.println("Eight-Puzzle:");
        EightPuzzle eight = new EightPuzzle();
        eight.createTest();
        eight.printMatrix();
        eight.ids();
        eight.printMatrix();

        //------------------------------------------------------------------------------------------------------------//


    }
}
