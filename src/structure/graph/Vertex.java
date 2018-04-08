package structure.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Vertex implements Comparable <Vertex> {
    private State state;
    private List<Vertex> neighbors;

    public Vertex(State state) {
        this.state = state;
        neighbors = new ArrayList<>();
    }

    public Vertex getClone(){
        Vertex vertex = new Vertex(this.state);
        for (Vertex v: neighbors){
            vertex.neighbors.add(v.getClone());
        }
        return vertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(state, vertex.state) &&
                Objects.equals(neighbors, vertex.neighbors);
    }

    public boolean add(Vertex vertex){
        return neighbors.add(vertex);
    }

    @Override
    public int hashCode() {

        return Objects.hash(state, neighbors);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "state=" + state +
                ", neighbors=" + neighbors +
                '}';
    }

    public State getState() {
        return state;
    }

    public void finish(){
        Collections.sort(neighbors);
    }

    public int getSize() {
        return neighbors.size();
    }

    @Override
    public int compareTo(Vertex o) {
        return this.state.compareTo(o.state);
    }

    public List <Vertex> getSet(){
        List <Vertex> copy = new ArrayList<>();
        for (Vertex v: neighbors){
            copy.add(v);
        }
        return copy;
    }

    public boolean deleteEdge (Vertex delete){
        if (delete == null){
            return false;
        }
        return neighbors.remove(delete);
    }

    public boolean clear(){
        if (neighbors.isEmpty()){
            return false;
        }
        neighbors.clear();
        return true;
    }
}
