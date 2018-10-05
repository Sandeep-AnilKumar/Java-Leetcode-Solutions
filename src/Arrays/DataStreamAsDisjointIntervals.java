package Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class DataStreamAsDisjointIntervals {

    class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(Interval that){
            if (this.end == that.end) return this.start - that.start;
            return this.end - that.end;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    TreeSet<Interval> set;
    /** Initialize your data structure here. */
    public DataStreamAsDisjointIntervals() {
        set = new TreeSet<>();
    }

    public void addNum(int val) {
        Iterator<Interval> iterator = set.tailSet(new Interval(0, val - 1)).iterator();
        int start = val, end = val;
        Interval interval;
        while (iterator.hasNext()) {
            interval = iterator.next();
            if (end < interval.start - 1) break;
            start = Math.min(interval.start, start);
            end = Math.max(interval.end, end);
            iterator.remove();
        }
        set.add(new Interval(start, end));
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(set);
    }
    
    public static void main(String[] args) {
        DataStreamAsDisjointIntervals dataStreamAsDisjointIntervals = new DataStreamAsDisjointIntervals();
        dataStreamAsDisjointIntervals.addNum(1);
        dataStreamAsDisjointIntervals.addNum(3);
        System.out.println(dataStreamAsDisjointIntervals.getIntervals());
        dataStreamAsDisjointIntervals.addNum(7);
        System.out.println(dataStreamAsDisjointIntervals.getIntervals());
        dataStreamAsDisjointIntervals.addNum(6);
        System.out.println(dataStreamAsDisjointIntervals.getIntervals());
        dataStreamAsDisjointIntervals.addNum(2);
        System.out.println(dataStreamAsDisjointIntervals.getIntervals());
    }
}
