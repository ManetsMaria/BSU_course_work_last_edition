package test;

import action.vertical.SecondStep;
import structure.coveringarrays.CoveringArrays;
import structure.graph.Graph;
import util.Const;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FullTest {
    public static CoveringArrays getTest(Graph graph){
        int size = Integer.MAX_VALUE;
        CoveringArrays coveringArrays = new CoveringArrays();

        try {
            FileWriter fileWriter  = new FileWriter(Const.SYSTEM_DESCRIPTION_FILE, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("System desc: ");
            bufferedWriter.newLine();
            bufferedWriter.write(graph.toString());
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.close();
            CoveringArrays curr = H1H2Test.getTestStatistic(graph);
            if (curr.getSize() < size){
                size = curr.getSize();
                coveringArrays = curr;
            }
            curr = Step2Test.getTest(graph);
            if (curr.getSize() < size){
                size = curr.getSize();
                coveringArrays = curr;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return coveringArrays;
    }
}
