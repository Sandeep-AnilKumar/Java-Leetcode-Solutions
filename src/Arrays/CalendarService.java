package Arrays;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author sandeepa
 */

public class CalendarService {
    Set<Event> set;

    static class Event implements Comparable<Event>{
        private long start;
        private long end;

        public Event(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public long getStart() {
            return start;
        }

        public long getEnd() {
            return end;
        }

        @Override public String toString() {
            long startHour = (long) start / 60;
            long startMin = start - (startHour * 60);
            long endHour = (long) end / 60;
            long endMin = end - (endHour * 60);
            return (startHour < 10 ? "0" : "") + startHour + ":" + (startMin < 10 ? "0" : "") + 
                    startMin + " - " + (endHour < 10 ? "0" : "") + endHour + ":" + (endMin < 10 ? "0" : "") + endMin;
        }

        @Override
        public int compareTo(Event other) {
            if(this.getStart() == other.getStart()) {
                return (int) (this.getEnd() - other.getEnd());
            }

            return (int) (this.getStart() - other.getStart());
        }
    }

    public CalendarService() {
        set = new TreeSet<>();
    }

    public void printCalendar() {
        System.out.println(set);
    }

    public boolean addToCalendar(String start, String end) throws Exception {
        if(start == null || start.length() == 0) {
            throw new Exception("The time is null");
        }

        String[] startTimeParts = start.split(":");
        long startHour = Long.parseLong(startTimeParts[0]);
        long startMin = Long.parseLong(startTimeParts[1]);

        String[] endTimeParts = new String[2];
        long endHour = 0l;
        long endMin = 0l;

        long startTime = startHour * 60 + startMin;
        long endTime = 0l;

        if(end == null || end.length() == 0) {
            endTime = startTime + 30;
        } else {
            endTimeParts = end.split(":");
            endHour = Long.parseLong(endTimeParts[0]);
            endMin = Long.parseLong(endTimeParts[1]);
            endTime = endHour * 60 + endMin;
        }

        if(endTime > 1440) {
            throw new Exception("The end time is beyond today");
        }

        Event cur = new Event(startTime, endTime);

        for(Event prev: set) {
            if(cur.getStart() < prev.getEnd() && cur.getEnd() > prev.getStart()) {
                System.out.println("Event " + cur + " cannot be added to calendar");
                return false;
            }
        }

        set.add(cur);
        System.out.println("Event " + cur + " added to calendar");
        printCalendar();
        return true;
    }

    public static void main(String[] args) {
        CalendarService calendar = new CalendarService();
        try {
            calendar.addToCalendar("05:30", "");
            calendar.addToCalendar("06:00", "06:45");
            calendar.addToCalendar("05:45", "");
            calendar.addToCalendar("06:30", "");
            calendar.addToCalendar("11:30", "12:45");
            calendar.addToCalendar("18:00", "19:00");
            calendar.addToCalendar("18:30", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
