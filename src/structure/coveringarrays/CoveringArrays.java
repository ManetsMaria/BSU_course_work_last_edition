package structure.coveringarrays;

import java.util.ArrayList;
import java.util.List;

public class CoveringArrays {
    private List <Line> lines;

    public CoveringArrays(){
        lines = new ArrayList<>();
    }

    public boolean addLine(Line line){
        for (Line l: lines){
            if (l.add(line)){
                return true;
            }
        }
        lines.add(line);
        return false;
    }

    private CoveringArrays(List <Line> lines){
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "CoveringArrays{" +
                "lines=" + lines +
                '}';
    }

    public int getSize(){
        return lines.size();
    }

    public List<Line> getCopyLines(){
        List <Line> copy = new ArrayList<>();
        for (Line l: lines){
            copy.add(new Line(l.getLine()));
        }
        return copy;
    }

    public CoveringArrays getCopy(){
        return new CoveringArrays(this.getCopyLines());
    }
}
