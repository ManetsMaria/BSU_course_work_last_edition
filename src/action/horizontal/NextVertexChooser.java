package action.horizontal;

import structure.coveringarrays.Line;
import structure.graph.Vertex;
import util.SetUnioner;

import java.util.ArrayList;
import java.util.List;

public class NextVertexChooser {

    boolean flag;

    public NextVertexChooser(boolean flag){
        this.flag = flag;
    }

    public Line getLineState(List<Vertex> commonSet, int size){
        Line line = new Line(size);
        if (flag){
            return consistently(commonSet, size);
        }
        return recursive(commonSet, size);
    }

    private Line recursive(List <Vertex> commonSet, int size){
        return null;
    }

    private Line consistently(List <Vertex> set, int size){
        Line line = new Line(size);
        List <Vertex> previous = new ArrayList<>();
        Vertex vertex = H2.getVertex(set);
        while (vertex != null){
            line.add(vertex.getState());
            SetUnioner setUnioner = new SetUnioner();
            List < List <Vertex>> curr = new ArrayList<>();
            for (Vertex v: previous){
                curr.add(v.getSet());
            }
            curr.add(vertex.getSet());
            set = setUnioner.findUnion(curr);
            Vertex current = H2.getVertex(set);
            previous.add(vertex);
            for (Vertex v: previous) {
                v.deleteEdge(current);
            }
            vertex = current;
        }
        return line;
    }
}
