package structure.coveringarrays;

import structure.graph.State;
import util.MakeArrayCopy;

import java.util.Arrays;

public class Line {
    private String [] line;

    public Line(int size) {
        line = new String[size];
        for (int i = 0; i < size; i++){
            line[i] = ".";
        }
    }

    public Line(String[] line){
        this.line = line;
    }

    public boolean add(State state){
        if (state.getElement() > line.length){
            return false;
        }
        line[state.getElement()] = String.valueOf(state.getState());
        return true;
    }

    public boolean add(Line combineLine){
        String [] addLineChar = combineLine.getLine();
        String [] line = getLine();
        if (addLineChar.length != line.length){
            return false;
        }
        for (int i = 0; i < addLineChar.length; i++){
            if (".".equals(addLineChar[i])){
                continue;
            }
            if (".".equals(line[i])){
                line[i] = addLineChar[i];
                continue;
            }
            if (!addLineChar[i].equals(line[i])){
                return false;
            }
        }
        this.line = line;
        return true;
    }

    public String[] getLine() {
        String[] copy = new String[line.length];
        for (int i = 0; i < line.length; i++){
            copy[i] = line[i];
        }
        return copy;
    }

    public int getSize(){
        int counter = 0;
        for (int i = 0; i < line.length; i++){
            if (!".".equals(line[i])){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < line.length; i++){
            String e = line[i];
            if (!".".equals(e)){
                e = String.valueOf(Integer.valueOf(e) + 1);
            }
            stringBuilder.append(e);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
