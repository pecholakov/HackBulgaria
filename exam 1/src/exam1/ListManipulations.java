package exam1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListManipulations {

    public static List<Integer> reverse(List<Integer> inputList) {
        List<Integer> reversedList = new ArrayList<Integer>(inputList);
        Collections.reverse(reversedList);
        return reversedList;
    }

    public static List<Integer> sort(List<Integer> inputList) {
        List<Integer> sortedList = new ArrayList<Integer>(inputList);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static boolean isMonotonous(List<Integer> inputList) {
        return (sort(inputList)).equals(inputList) || reverse(sort(inputList)).equals(inputList);
    }

}
