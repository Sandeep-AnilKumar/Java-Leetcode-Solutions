package DataStructureImplementation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ParkingLot {
    private String name;
    private String address;
    private int floors;
    private int[] spaces;
    private Map<Integer, Space> spaceMap;
    private TreeSet<Space> bookedSpaces;
    private TreeSet<Space> emptySpaces;
    private Fare fare;

    static class Fare {
        private int baseFare;
        private int baseTime;
        private int incrementalFare;
        private int incrementalTime;

        public Fare(int baseFare, int baseTime, int incrementalFare, int incrementalTime) {
            this.baseFare = baseFare;
            this.baseTime = baseTime;
            this.incrementalFare = incrementalFare;
            this.incrementalTime = incrementalTime;
        }

        public void setNewFareCharges(int baseFare, int baseTime, int incrementalFare, int incrementalTime) {
            this.baseFare = baseFare;
            this.baseTime = baseTime;
            this.incrementalFare = incrementalFare;
            this.incrementalTime = incrementalTime;
        }
    }

    static class Interval {
        private int startHour;
        private int startMin;
        private int endHour;
        private int endMin;

        public Interval(int startHour, int startMin) {
            this.startHour = startHour;
            this.startMin = startMin;
        }

        public void setEndTime(int endHour, int endMin) {
            this.endHour = endHour;
            this.endMin = endMin;
        }

        public String getElapsedTime(String curTime) {
            String[] parts = curTime.split(":");
            int cur = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            int total = cur - ((startHour * 60) + startMin);
            return total/60 + ":" + total%60;
        }

        public String getTotalTime() {
            return getElapsedTime(endHour + ":" + endMin);
        }
    }

    static class Space implements Comparable<Space> {
        private int spaceNo;
        private Interval bookingInterval;
        private boolean isEmpty;

        public Space(int spaceNo) {
            this.spaceNo = spaceNo;
            isEmpty = true;
        }

        public void startBooking(int startHour, int startMin) {
            bookingInterval = new Interval(startHour, startMin);
            isEmpty = false;
        }

        public String endBooking(int endHour, int endMin) {
            if (bookingInterval != null && !isEmpty) {
                bookingInterval.setEndTime(endHour, endMin);
                isEmpty = true;
                return bookingInterval.getTotalTime();
            }

            return "";
        }

        public void clearBooking() {
            isEmpty = true;
            bookingInterval = null;
        }

        @Override
        public int compareTo(Space other) {
            return spaceNo - other.spaceNo;
        }
    }

    public ParkingLot(String name, String address, int floors, int[] spaces) {
        this.name = name;
        this.address = address;
        this.floors = floors;
        this.spaces = spaces;
        spaceMap = new HashMap<>();
        bookedSpaces = new TreeSet<>();
        emptySpaces = new TreeSet<>();
        setEmptySpaces();
    }

    public void setEmptySpaces() {
        for (int f = 1; f <= floors; ++f) {
            int totalSpace = f * 100 + spaces[f - 1];
            Space cur;
            for (int s = f * 100 + 1; s <= totalSpace; ++s) {
                cur = new Space(s);
                spaceMap.put(s, cur);
                emptySpaces.add(cur);
            }
        }
    }

    public void setFare(int baseFare, int baseTime, int incrementalFare, int incrementalTime) {
        fare = new Fare(baseFare, baseTime, incrementalFare, incrementalTime);
    }

    public void setNewFareCharges(int baseFare, int baseTime, int incrementalFare, int incrementalTime) {
        fare.setNewFareCharges(baseFare, baseTime, incrementalFare, incrementalTime);
    }

    public int getNextEmptySpace() {
        if (emptySpaces != null && emptySpaces.size() > 0) {
            return emptySpaces.first().spaceNo;
        }

        System.out.println("There are no more empty spaces in the parking lot");
        return -1;
    }

    public int startBooking(int startHour, int startMin) {
        int emptySpace = getNextEmptySpace();

        if (emptySpace == -1) {
            System.out.println("Cannot start booking as there are no more empty spaces");
            return -1;
        }

        if (spaceMap == null || !spaceMap.containsKey(emptySpace)) {
            System.out.println("Something is not right with the booking system, please try again!");
            return -1;
        }

        Space cur = spaceMap.get(emptySpace);

        if (bookedSpaces.contains(cur) || !emptySpaces.contains(cur)) {
            System.out.println("Something is not right with the booking system, please try again!");
            return -1;
        }

        cur.startBooking(startHour, startMin);
        bookedSpaces.add(cur);
        emptySpaces.remove(cur);
        return cur.spaceNo;
    }

    public void endBooking(int spaceNo, int endHour, int endMin) {
        if (spaceMap == null || !spaceMap.containsKey(spaceNo)) {
            System.out.println("Something is not right with the booking system, please try again!");
            return;
        }

        Space cur = spaceMap.get(spaceNo);

        if (emptySpaces.contains(cur) || !bookedSpaces.contains(cur)) {
            System.out.println("Something is not right with the booking system, please try again!");
            return;
        }

        String totalTime = cur.endBooking(endHour, endMin);
        int totalFare = getFare(totalTime);
        printReceipt(totalFare, cur, spaceNo);
        cur.clearBooking();
        emptySpaces.add(cur);
        bookedSpaces.remove(cur);
    }

    private int getFare(String totalTime) {
        String[] parts = totalTime.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);

        if (hour * 60 < fare.baseTime) {
            return fare.baseFare;
        }

        return fare.baseFare + fare.incrementalFare * (((hour * 60 + min) - fare.baseTime)/fare.incrementalTime + 1);
    }

    private void printReceipt(int totalFare, Space cur, int spaceNo) {
        String border = "+----------------------------------------------------------------------------------+";
        System.out.println(border);
        int spaces = border.length();
        formatAndPrint("Hi!, the total fare for your today's parking at the space number "
                + spaceNo + " is $" + totalFare, spaces);
        formatAndPrint("Our charges are : $" + fare.baseFare + " for the first "
                + fare.baseTime/60 + " hour, and $" + fare.incrementalFare + " for every "
                + fare.incrementalTime + " min thereafter", spaces);
        formatAndPrint("You parked from " + cur.bookingInterval.startHour + ":"
                + cur.bookingInterval.startMin + " to " + cur.bookingInterval.endHour + ":"
                + cur.bookingInterval.endMin, spaces);
        System.out.println(border);
    }

    private void formatAndPrint(String message, int spaces) {
        int length = message.length();
        String startDelimiter = "| ";
        String endDelimiter = " |";
        int pad = spaces - startDelimiter.length() - endDelimiter.length() - length;
        StringBuilder sb = new StringBuilder();
        String tabs = new String(new char[pad/2]).replaceAll("\0", " ");
        sb.append(startDelimiter).append(tabs).append(message).append(tabs);

        if (pad % 2 != 0) {
            sb.append(" ");
        }
        sb.append(endDelimiter);
        System.out.println(sb.toString());
    }

    public String displayAvailableSpaces() {
        StringBuilder sb = new StringBuilder();
        emptySpaces.forEach(space -> sb.append(space.spaceNo).append(", "));
        return sb.toString();
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot("A", "Sunnyvale", 3, new int[]{5, 5, 10});
        lot.setFare(10, 120, 5, 30);
        int space1 = lot.startBooking(5, 30);
        lot.endBooking(space1, 9, 29);
        int space2 = lot.startBooking(9, 30);
        int space3 = lot.startBooking(10, 15);
        int space4 = lot.startBooking(12, 15);
        lot.endBooking(space2, 12, 16);
        int space5 = lot.startBooking(13, 11);
        lot.endBooking(space3, 13, 29);
        int space6 = lot.startBooking(13, 30);
        lot.endBooking(space5, 13, 31);
        int space7 = lot.startBooking(14, 45);
        lot.endBooking(space7, 14, 55);
        int space8 = lot.startBooking(15, 19);
        lot.endBooking(space8, 17, 19);
        lot.endBooking(space6, 18, 21);
        lot.endBooking(space4, 18, 32);
    }
}
