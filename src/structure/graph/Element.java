package structure.graph;

import java.util.ArrayList;
import java.util.List;

public class Element extends ArrayList<Vertex> {

    public int getEdgesNumber(){
        int counter = 0;
        for (Vertex v: this){
            counter += v.getSize();
        }
        return counter;
    }

    public boolean init(int element, int numberStates){
        for (int i = 0; i < numberStates; i++){
            Vertex vertex = new Vertex(new State(element, i));
            this.add(vertex);
        }
        return true;
    }

    public void finish(){
        for (Vertex v: this){
            v.finish();
        }
    }

    public List<Vertex> getList(){
        List <Vertex> copy = new ArrayList<>();
        for (Vertex v: this){
            copy.add(v);
        }
        return copy;
    }
}
