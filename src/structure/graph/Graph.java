package structure.graph;

import java.util.HashMap;

public class Graph extends HashMap <Integer, Element> {
    private Element element;

    public Graph() {
    }

    public int getSize() {
        return this.size();
    }

    public boolean checkState(State state){
        if (!this.containsKey(state.getElement())){
            return false;
        }
        return this.get(state.getElement()).size() >= state.getState();
    }

    public boolean init(int[] statesNumber){
        int elementsNumber = statesNumber.length;
        for (int i = 0; i < elementsNumber; i++){
            Element element = new Element();
            element.init(i, statesNumber[i]);
            this.put(i, element);
        }
        return true;
    }

    public boolean add (State first, State second){
        int indexFirst = first.getElement();
        int indexSecond = second.getElement();
        int stateFirst = first.getState();
        int stateSecond = second.getState();
        Element firstElement = this.get(indexFirst);
        Element secondElement = this.get(indexSecond);
        Vertex added = secondElement.get(stateSecond);
        return firstElement.get(stateFirst).add(added);
    }

    public void finish(){
        for (Element element: this.values()){
            element.finish();
        }
    }
}
