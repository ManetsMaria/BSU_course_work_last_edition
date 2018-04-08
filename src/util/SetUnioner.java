package util;

import structure.graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class SetUnioner {
    public List<Vertex> findUnion(List <List <Vertex>> sets){

        if (sets == null || sets.isEmpty()){
            return new ArrayList();
        }

        if (sets.size() == 1){
            return sets.get(0);
        }

        List <Vertex> curr = findUnion(sets.get(0), sets.get(1));

        for (int i = 2; i < sets.size(); i++){
            curr = findUnion(curr, sets.get(i));
        }

        return curr;
    }

    private List <Vertex> findUnion (List <Vertex> first, List <Vertex> second){
        List <Vertex> result = new ArrayList();
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < first.size() && pointer2 < second.size()){
            if (first.get(pointer1).equals(second.get(pointer2))){
                result.add(first.get(pointer1));
                pointer1++;
                pointer2++;
                continue;
            }
            if (first.get(pointer1).compareTo(second.get(pointer2)) < 0){
                pointer1++;
                continue;
            }
            pointer2++;
        }
        return result;
    }
}
