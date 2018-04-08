package action.vertical;

import structure.graph.Element;
import structure.graph.Graph;
import structure.graph.State;
import structure.graph.Vertex;

public class FindMinParameter {

    static public State findMinParameter(Graph graph){
        int min = Integer.MAX_VALUE;
        State state = null;
        for (Element element: graph.values()){
            for (Vertex vertex: element){
                if (vertex.getSize() != 0 && vertex.getSize() <= min){
                    state = vertex.getState();
                    min = vertex.getSize();
                }
            }

        }
        return state;
    }

}
