package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sort {

    public static void main(String[] args) {

        List<String> cats = new ArrayList<>(Arrays.asList("Tom", "Martin", "Barsik", "Aby", "Lapusik"));
        System.out.println(sortByLength(cats));
    }

    public static List<String> sortByLength(List<String> catsList) {
        catsList.sort(Comparator.comparingInt(String::length));
        return catsList;
    }
}