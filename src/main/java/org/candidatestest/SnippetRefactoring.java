package org.candidatestest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SnippetRefactoring {
    public static class Data {
        public boolean flag;
        public String label;
        public int value;
        public int id;
    }

    public static class DataTwo {
        public DataTwo(int value, int id) {
            this.value = value;
            this.id = id;
        }

        public int value;
        public int id;
    }

    private List<DataTwo> theArray;

    public boolean update(List<Data> data, String label) {
        theArray = new ArrayList<>();
        boolean isLabelMoreThanHalf =
                data.stream().filter(d -> d.label.equals(label)).count() > data.size() / 2;

        List<DataTwo> theArray = processData(data, label);
        int theArraySize = theArray.size();
        int total = processTotal(theArray);

        return isValid(theArraySize, total, label, isLabelMoreThanHalf);
    }

    private List<DataTwo> processData(List<Data> data, String label) {
        theArray = data.stream()
                .filter(dat -> dat.flag && dat.label.equals(label))
                .map(dat -> new DataTwo(dat.value, dat.id))
                .collect(Collectors.toList());

        return theArray;
    }

    private int processTotal(List<DataTwo> theArray) {
        return theArray.stream()
                .mapToInt(datTwo -> datTwo.value)
                .sum();
    }

    private boolean isValid(int theArraySize, int total, String label, boolean isLabelMoreThanHalf) {
        if (isLabelMoreThanHalf) {
            return theArraySize != 0 || total != 0 || isEmptyOrNull(label);
        }

        return theArraySize != 0 || total != 0;
    }

    private boolean isEmptyOrNull(String label) {
        return label == null || !label.isEmpty();
    }
}
