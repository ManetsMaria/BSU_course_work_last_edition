package structure.coveringarrays;

import structure.graph.State;
import util.MakeArrayCopy;

import java.util.Arrays;

public class Line {
    private char [] line;

    public Line(int size) {
        line = new char[size];
        for (int i = 0; i < size; i++){
            line[i] = '.';
        }
    }

    public boolean add(State state){
        if (state.getElement() > line.length){
            return false;
        }
        line[state.getElement()] = (char) ('0' + state.getState());
        return true;
    }

    public boolean add(Line combineLine){
        char [] addLineChar = combineLine.getLine();
        char [] line = getLine();
        if (addLineChar.length != line.length){
            return false;
        }
        for (int i = 0; i < addLineChar.length; i++){
            if (addLineChar[i] == '.'){
                continue;
            }
            if (line[i] == '.'){
                line[i] = addLineChar[i];
                continue;
            }
            if (addLineChar[i] != line[i]){
                return false;
            }
        }
        this.line = line;
        return true;
    }

    public char[] getLine() {
        char[] copy = new char[line.length];
        for (int i = 0; i < line.length; i++){
            copy[i] = line[i];
        }
        return copy;
    }

    public int getSize(){
        int counter = 0;
        for (int i = 0; i < line.length; i++){
            if (line[i] != '.'){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        return "Line{" +
                "line=" + Arrays.toString(line) +
                '}';
    }
}
