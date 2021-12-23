package Design;

import java.util.*;

public class TimeBasedKeyValueStore {

//    Create a timebased key-value store class TimeMap, that supports two operations.
//
//            1. set(string key, string value, int timestamp)
//
//    Stores the key and value, along with the given timestamp.
//2. get(string key, int timestamp)
//
//    Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
//    If there are multiple such values, it returns the one with the largest timestamp_prev.
//    If there are no values, it returns the empty string ("").
}

class Pair{
    String value;
    int timestamp;
    public Pair(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}
class TimeMap {
    Map<String, List<Pair>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key, new ArrayList<Pair>());

        List<Pair> list = map.get(key);
        list.add(new Pair(value, timestamp));

    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        List<Pair> list = map.get(key);
        int l = 0, r = list.size() - 1;
        int k = 0;
        while(l <= r){
            k = (l + r) / 2;
            int ele = list.get(k).timestamp;
            if(ele < timestamp)
                l = k + 1;
            else if(ele > timestamp)
                r = k - 1;
            else
                return list.get(k).value;
        }
        if(r < 0){
            return "";
        }
        return list.get(r).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
