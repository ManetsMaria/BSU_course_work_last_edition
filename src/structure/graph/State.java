package structure.graph;

import java.util.Objects;

public class State implements Comparable <State> {
    private int element;
    private int state;

    public State(int element, int state) {
        this.element = element;
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state1 = (State) o;
        return element == state1.element &&
                state == state1.state;
    }

    @Override
    public int hashCode() {

        return Objects.hash(element, state);
    }

    @Override
    public String toString() {
        return "State{" +
                "element=" + element +
                ", state=" + state +
                '}';
    }

    public int getElement() {
        return element;
    }

    public int getState() {
        return state;
    }

    @Override
    public int compareTo(State o) {
        int compare = this.element - o.element;
        if (compare != 0){
            return compare;
        }
        compare = this.state - o.state;
        return compare;
    }
}
