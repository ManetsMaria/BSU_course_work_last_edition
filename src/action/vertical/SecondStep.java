package action.vertical;

import structure.coveringarrays.CoveringArrays;
import structure.coveringarrays.Line;
import structure.graph.Graph;
import structure.graph.State;
import structure.graph.Vertex;

public class SecondStep {

    public static CoveringArrays secondStep(Graph graph, CoveringArrays coveringArrays){
        int size = graph.getSize();
        State elementNumber = FindMinParameter.findMinParameter(graph);
        while (elementNumber != null){
            Vertex vertex = graph.get(elementNumber.getElement()).get(elementNumber.getState());
            for (Vertex v: vertex.getSet()){
                Line line = new Line(size);
                line.add(elementNumber);
                line.add(v.getState());
                coveringArrays.addLine(line);
            }
            vertex.clear();
            elementNumber = FindMinParameter.findMinParameter(graph);
        }
        return coveringArrays;
    }

}
