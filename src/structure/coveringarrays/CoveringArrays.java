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

    @Override
    public String toString() {
        return "CoveringArrays{" +
                "lines=" + lines +
                '}';
    }

    public int getSize(){
        return lines.size();
    }
}
