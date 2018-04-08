package structure.sample;

import structure.coveringarrays.Line;

public class ViewLine {
    private int id;
    private String line;

    public ViewLine(int id, Line line){
        this.id = id;
        this.line = line.toString();
    }

    @Override
    public String toString() {
        return "ViewLine{" +
                "id=" + id +
                ", line='" + line + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getLine() {
        return line;
    }
}
