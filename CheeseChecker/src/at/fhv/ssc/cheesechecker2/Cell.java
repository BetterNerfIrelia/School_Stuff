package at.fhv.ssc.cheesechecker2;

public class Cell {

    private boolean _visited;
    private String _cheeseCell;


    public Cell() {
        _visited = false;
    }

    public Cell(String cheeseCell) {
        _visited = false;
        _cheeseCell = cheeseCell;
    }

    public boolean isVisited() {
        return _visited;
    }

    public void setVisited(boolean visited) {
        _visited = visited;
    }

    public String getCheeseCell() {
        return _cheeseCell;
    }

    public void setCheeseCell(String cheeseCell) {
        _cheeseCell = cheeseCell;
    }
}
