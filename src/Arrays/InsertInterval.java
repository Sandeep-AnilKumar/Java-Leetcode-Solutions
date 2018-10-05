package Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = newInterval.start;
        int end = newInterval.end;
        Iterator<Interval> iterator = intervals.iterator();
        Interval curInterval = null;
        int index = 0;
        while (iterator.hasNext()) {
            curInterval = iterator.next();
            if (start > curInterval.end) {
                index++;
                continue;
            }

            if (end < curInterval.start) break;
            start = Math.min(start, curInterval.start);
            end = Math.max(end, curInterval.end);
            iterator.remove();
        }

        intervals.add(index, new Interval(start, end));
        return intervals;
    }
    
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(5, 8));
        intervals.add(new Interval(10, 12));
        Interval newInterval = new Interval(2, 9);
        System.out.println("The updated interval is := " + new InsertInterval().insert(intervals, newInterval));
        
    }
}
