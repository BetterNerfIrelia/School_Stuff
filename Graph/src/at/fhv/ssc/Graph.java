package at.fhv.ssc;

import java.io.File;
import java.util.Scanner;

public class Graph {

    private AdjacencyMatrix _matrix;   //TODO: AdjacencyStruct statt Matrix und/oder List
    private AdjacencyList _list;
    private Interpreter _interpreter;
    private EulerianSolver _euler;
    private DragonSolver _dragon;
    private Tannenbaum _tannenbaum;

    public void createGraph(File file, AdjacencyMatrix matrix, AdjacencyList list) {

        _matrix = matrix;
        _list = list;
        _interpreter = new Interpreter();
        _interpreter.createList(readInput(file));
    }

    public void createGraph(File file, AdjacencyMatrix matrix, AdjacencyList list, DragonSolver dragon) {

        _matrix = matrix;
        _list = list;
        _dragon = dragon;
        _interpreter = new Interpreter();
        _interpreter.createList(readInput(file));
    }

    public void createGraph(File file, AdjacencyMatrix matrix, AdjacencyList list, Tannenbaum tannenbaum) {

        _matrix = matrix;
        _list = list;
        _tannenbaum = tannenbaum;
        _interpreter = new Interpreter();
        _interpreter.createList(readInput(file));
    }

    public void createGraph(File file, AdjacencyMatrix matrix) {

        _matrix = matrix;
        _interpreter = new Interpreter();
        _interpreter.createList(readInput(file));
    }

    public void createGraph(File file, AdjacencyList list) {

        _list = list;
        _interpreter = new Interpreter();
        _interpreter.createList(readInput(file));
    }

    public void printMatrix(){
        _matrix.print();
    }

    public void printList(){
        _list.print();
    }

    public void print() {
        //TODO: gibt struct aus.
           /*
     * So wie du das momentan hast, brauchst die ganzen getter und setter, aber f�r mich
     * is es so, dass derjenige, der den Graph anwendet, keinen zugriff auf die adjMatrix
     * oder adjList haben sollte und diese auch ned mit get oder set bearbeiten sollte.
     * Jede methode von der adjMatrix oder adjList kannst du ja als methode vom graph
     * implementieren und der graph ruft dann die entsprechende methode von der struktur auf
     * zB beim print() {
     * 				_matrix.print();
     * 		   }
     * Sch�nes bsp f�r geheimnisprinzip =)
     */
    }

    public StringBuilder readInput(File file) {

        StringBuilder str = new StringBuilder();

        try {
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                str.append(in.nextLine());
            }
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return str;
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

    public Interpreter getInterpreter() {
        return _interpreter;
    }

    public void setInterpreter(Interpreter interpreter) {
        _interpreter = interpreter;
    }

    public EulerianSolver getEuler() {
        return _euler;
    }

    public void setEuler(EulerianSolver euler) {
        _euler = euler;
    }

    public DragonSolver getDragon() {
        return _dragon;
    }

    public void setDragon(DragonSolver dragon) {
        _dragon = dragon;
    }

    public Tannenbaum getTannenbaum() {
        return _tannenbaum;
    }

    public void setTannenbaum(Tannenbaum tannenbaum) {
        _tannenbaum = tannenbaum;
    }
}
