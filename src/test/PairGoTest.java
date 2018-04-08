package test;

import action.rude.PairGo;
import structure.coveringarrays.CoveringArrays;
import structure.graph.Graph;
import util.Const;
import util.IntegrateKoef;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PairGoTest {
    public static CoveringArrays getTest(Graph g) throws IOException {
        int n = Const.MEASUREMENT_NUMBER;
        long sum = 0;
        CoveringArrays coveringArrays = new CoveringArrays();
        for (int i = 0; i < n; i++){
            Graph graph = g.getCopy();
            long start = System.currentTimeMillis();
            coveringArrays = PairGo.beginGo(graph);
            long finish = System.currentTimeMillis();
            sum += (finish - start);
        }

        FileWriter fileWriter = new FileWriter(Const.PAIR_GO_FILE, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Pair Go:");
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
