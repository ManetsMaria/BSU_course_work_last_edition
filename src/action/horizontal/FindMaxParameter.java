package action.horizontal;

import structure.graph.Element;
import structure.graph.Graph;

import java.util.Map;


public class FindMaxParameter {
    public static int findMaxParameter(Graph graph){
       int size = graph.getSize();
        int max = -1;
        int indexMax = -1;
        for(Map.Entry<Integer, Element> entry : graph.entrySet()) {
            int index = entry.getKey();
            Element element = entry.getValue();
            int current = size*element.size() - index + element.getEdgesNumber();
            if (current > max){
                max = current;
                indexMax = index;
            }
        }
        return indexMax;
    }
}
