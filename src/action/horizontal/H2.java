package action.horizontal;

import structure.graph.Vertex;

import java.util.List;

public class H2 {

    public static Vertex getVertex(List<Vertex> list){
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
}
