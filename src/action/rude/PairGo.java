package action.rude;

import structure.coveringarrays.CoveringArrays;
import structure.coveringarrays.Line;
import structure.graph.Element;
import structure.graph.Graph;
import structure.graph.Vertex;

public class PairGo {

    public static CoveringArrays beginGo(Graph graph){
        int size = graph.getSize();
        CoveringArrays coveringArrays = new CoveringArrays();
        for (int i = 0; i < size; i++){
            Element element = graph.get(i);
            for (int j = 0; j < element.size(); j++) {
                Vertex vertex = element.get(j);
                for (Vertex v : vertex.getSet()) {
                    Line line = new Line(size);
                    line.add(vertex.getState());
                    line.add(v.getState());
                    coveringArrays.addLine(line);
                }
                vertex.clear();
            }
        }

        return coveringArrays;
    }
}
