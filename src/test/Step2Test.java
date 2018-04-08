package test;

import action.horizontal.FirstStep;
import action.vertical.SecondStep;
import structure.coveringarrays.CoveringArrays;
import structure.graph.Graph;
import util.Const;
import util.IntegrateKoef;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Step2Test {
    public static CoveringArrays getTest(Graph g) throws IOException {
        int n = Const.MEASUREMENT_NUMBER;
        long sum = 0;
        CoveringArrays coveringArrays = new CoveringArrays();
        for (int i = 0; i < n; i++){
            Graph graph = g.getCopy();
            long start = System.currentTimeMillis();
            coveringArrays = new CoveringArrays();
            coveringArrays = SecondStep.secondStep(graph, coveringArrays);
            long finish = System.currentTimeMillis();
            sum += (finish - start);
        }

        FileWriter fileWriter = new FileWriter(Const.SECOND_STEP_TEST_FILE, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Step2:");
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf((sum*1.0)/n));
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(coveringArrays.getSize()));
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.close();

        System.out.println(IntegrateKoef.calc((sum*1.0)/n, coveringArrays.getSize()));

        return coveringArrays;
    }
}
