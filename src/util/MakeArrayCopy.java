package util;

public class MakeArrayCopy <T> {

    public T[] makeCopy (T[] original){
        int size = original.length;
        Object [] copy = new Object[size];
        for (int i = 0; i < size; i++){
            copy[i] = original[i];
        }
        return (T[]) copy;
    }
}
