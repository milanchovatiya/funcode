package Heap;

import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class MeetingTimes {


    public static void main(String[] args) {
        //(1, 10), (2, 7), (3, 19), (8, 12), (10, 20), (11, 30)
       // Sort the given meetings by their start time.
        //Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of the ending times as that tells us when a meeting room will get free.
        //For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
        //If the room is free, then we extract the topmost element and add it back with the ending time of the current meeting we are processing.
        //If not, then we allocate a new room and add it to the heap.
        //After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.




    }
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0)
            return 0;
        List<Interval> intervalList = Arrays.asList(intervals);
        Collections.sort(intervalList, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return Integer.compare(i1.start, i2.start);
            }
        });
        PriorityQueue<Interval> roomList = new PriorityQueue<Interval>(new  Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return Integer.compare(i1.end, i2.end);
            }
        });
        roomList.add(intervalList.get(0));

        for(int i = 1; i < intervalList.size();i++){
            if(roomList.peek().end <= intervalList.get(i).start){
                roomList.remove();

            }
            roomList.add(intervalList.get(i));
        }
        return roomList.size();
    }

    public boolean canAttendMeetingsBruteForce(Interval[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (overlap(intervals[i], intervals[j])) return false;
            }
        }
        return true;
    }
    private boolean overlap(Interval i1, Interval i2) {
        return (Math.min(i1.end, i2.end) >
                Math.max(i1.start, i2.start));
    }

    public boolean canAttendMeetingsBest(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) return false;
        }
        return true;
    }
}
