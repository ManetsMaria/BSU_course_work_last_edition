package action.rude;

import action.horizontal.FindMaxParameter;
import action.horizontal.H1;
import action.horizontal.NextVertexChooser;
import structure.coveringarrays.CoveringArrays;
import structure.coveringarrays.Line;
import structure.graph.Element;
import structure.graph.Graph;
import structure.graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class ChainGo {

    public static CoveringArrays chainGo(Graph graph){
        CoveringArrays coveringArrays = new CoveringArrays();
        int elementNumber = FindMaxParameter.findMaxParameter(graph);
        while (!graph.isFinish()) {
            Element element = graph.get(elementNumber);
            List<Vertex> orderedList = H1.getOrderWithH1(element);
            for (Vertex v : orderedList) {
                List<Vertex> start = new ArrayList<>();
                NextVertexChooser nextVertexChooser = new NextVertexChooser(true);
                start.add(v);
                Line curr = nextVertexChooser.getLineState(start, graph.getSize());
                coveringArrays.addLine(curr);
            }
            elementNumber = FindMaxParameter.findMaxParameter(graph);
        }
        return coveringArrays;
    }
}
