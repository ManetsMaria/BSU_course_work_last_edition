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


public class H1H2Test {

    public static CoveringArrays getTestStatistic(Graph g) throws IOException {
        int n = Const.MEASUREMENT_NUMBER;
        long sum = 0;
        CoveringArrays coveringArrays = new CoveringArrays();
        for (int i = 0; i < n; i++){
            Graph graph = g.getCopy();
            long start = System.currentTimeMillis();
            coveringArrays = FirstStep.fisrtStep(graph);
            coveringArrays = SecondStep.secondStep(graph, coveringArrays);
            long finish = System.currentTimeMillis();
            sum += (finish - start);
        }

        FileWriter fileWriter = new FileWriter(Const.H1_H2_TEST_FILE, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("H1H2:");
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
