package org.candidatestest.old;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Snippet1 {
    public static class Data {
        public boolean a;
        public String b;
        public int c;
        public int id;
    }
    public class Data2 {
        public Data2(int c, int id) {
            this.c = c;
            this.id = id;
        }
        public int c;
        public int id;
    }
    private List<Data2> theArray;
    public boolean update(List<Data> data, String s) {
        theArray = new ArrayList<>();
        int total = 0;
        if(data.stream().filter(d -> d.b ==
                s).collect(Collectors.toList()).size() > data.size() / 2) {
            data.stream().filter(d -> d.a).filter(d -> d.b == s)
                    .map(d -> new Data2(d.c, d.id)).forEach(d2 ->
                            theArray.add(d2));
            List<Data> filtered = data.stream().filter(d -> d.b == s &&
                    d.a).collect(Collectors.toList());
            for (int i = 0; i < filtered.size() - 1; i++) {
                total += filtered.get(i).c;
            }
            return isValid(theArray, s, total);
        } else {
            data.stream().filter(d -> d.b == "default")
                    .filter(d -> d.a)
                    .map(d -> new Data2(d.c, d.id)).forEach(d2 ->
                            theArray.add(d2));
            List<Data> filtered = data.stream().filter(d -> d.b ==
                    "default" && d.a).collect(Collectors.toList());
            for (int i = 0; i < filtered.size() - 1; i++) {
                total += filtered.get(i).c;
            }
            return this.isValid(theArray, "default", total);
        }
    }
    private boolean isValid(List<Data2> a, String b, int c) {
        if(a.size() == 0 || b.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    private boolean isEmpty(String s) {
        if(s == "") {
            return false;
        } else if(s == null) {
            return false;
        } else {
            return true;
        }
    }
}