package action.horizontal;

import structure.coveringarrays.CoveringArrays;
import structure.coveringarrays.Line;
import structure.graph.Element;
import structure.graph.Graph;
import structure.graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class FirstStep {
    public static CoveringArrays fisrtStep(Graph graph){
        int elementNumber = FindMaxParameter.findMaxParameter(graph);
        Element element = graph.get(elementNumber);
        List<Vertex> orderedList = H1.getOrderWithH1(element);
        CoveringArrays coveringArrays = new CoveringArrays();
        for (Vertex v: orderedList){
            NextVertexChooser nextVertexChooser = new NextVertexChooser(true);
            List <Vertex> start = new ArrayList<>();
            start.add(v);
            Line curr =  nextVertexChooser.getLineState(start, graph.getSize());
            coveringArrays.addLine(curr);
        }
        return coveringArrays;
    }
}
