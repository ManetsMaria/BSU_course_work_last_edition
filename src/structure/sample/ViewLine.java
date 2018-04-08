package structure.sample;

import structure.coveringarrays.Line;

public class ViewLine {
    int id;
    String line;

    public ViewLine(int id, Line line){
        this.id = id;
        this.line = line.toString();
    }
}
