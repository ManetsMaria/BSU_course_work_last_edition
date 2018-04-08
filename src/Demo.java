import action.horizontal.FindMaxParameter;
import action.horizontal.FirstStep;
import action.vertical.SecondStep;
import structure.coveringarrays.CoveringArrays;
import structure.graph.Graph;
import structure.graph.State;

public class Demo {
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        Graph graph = new Graph();
        int [] states = new int[4];
        states[0] = 2;
        states[1] = 5;
        states[2] = 3;
        states[3] = 2;
        graph.init(states);
        graph.add(new State(0, 0), new State(1, 0));
        graph.add(new State(0, 0), new State(1, 1));
        graph.add(new State(0, 0), new State(1, 2));
        graph.add(new State(0, 0), new State(1, 3));
        graph.add(new State(0, 0), new State(1, 4));
        graph.add(new State(0, 0), new State(2, 0));
        graph.add(new State(0, 0), new State(2, 2));
        graph.add(new State(0, 0), new State(3, 0));

        graph.add(new State(0, 1), new State(1, 0));
        graph.add(new State(0, 1), new State(2, 0));
        graph.add(new State(0, 1), new State(2, 1));
        graph.add(new State(0, 1), new State(3, 0));
        graph.add(new State(0, 1), new State(3, 1));

        graph.add(new State(1, 0), new State(2, 1));

        graph.add(new State(1, 1), new State(2, 0));

        graph.add(new State(1, 2), new State(2, 2));

        graph.add(new State(1, 3), new State(3, 0));
        graph.add(new State(1, 3), new State(2, 1));
        graph.add(new State(1, 3), new State(2, 0));

        graph.add(new State(1, 4), new State(3, 1));
        graph.add(new State(1, 4), new State(2, 1));
        graph.add(new State(1, 4), new State(2, 2));
        graph.add(new State(1, 4), new State(2, 0));

        graph.add(new State(2, 0), new State(3, 1));

        graph.add(new State(2, 1), new State(3, 1));
        graph.add(new State(2, 1), new State(3, 0));

        graph.add(new State(2, 2), new State(3, 0));
        graph.finish();
        System.out.println(FindMaxParameter.findMaxParameter(graph));
        CoveringArrays coveringArrays = FirstStep.fisrtStep(graph);
        System.out.println(coveringArrays);
        System.out.println(SecondStep.secondStep(graph, coveringArrays).getSize());
        System.out.println(System.currentTimeMillis() - start);

    }
}
