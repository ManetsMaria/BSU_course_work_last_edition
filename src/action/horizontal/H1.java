package action.horizontal;

import structure.graph.Element;
import structure.graph.Vertex;

import java.util.List;

public class H1 {
   public static List<Vertex> getOrderWithH1 (Element element){
       List <Vertex> list = element.getList();
       list.sort((v1, v2) -> (v1.getSize() - v2.getSize()));
       return list;
   }
}
