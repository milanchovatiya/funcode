package Intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class MergeInterval {


    public static void main(String[] args) {



    }

    //First, we sort the list as described.
    // Then, we insert the first interval into our merged list
    // and continue considering each interval in turn as follows:
    // If the current interval begins after the previous interval ends,
    // then they do not overlap and we can append the current interval to merged.
    // Otherwise, they do overlap, and we merge them by updating the end of the previous interval
    // if it is less than the end of the current interval.
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return Integer.compare(i1.start, i2.start);
            }
        });
        List<Interval> mergedList = new ArrayList<>();
        if(intervals.isEmpty())
            return mergedList;

        mergedList.add(intervals.get(0));
        int index = 0;
        for(int i = 1; i < intervals.size(); i++){
            if(overlap(mergedList.get(index), intervals.get(i))){
                if(mergedList.get(index).end < intervals.get(i).end)
                    mergedList.get(index).end = intervals.get(i).end;
            }
            else{
                mergedList.add(intervals.get(i));
                index++;
            }
        }
        return mergedList;
    }

    public boolean overlap(Interval i1, Interval i2){
        return i1.end >= i2.start;
    }
}
