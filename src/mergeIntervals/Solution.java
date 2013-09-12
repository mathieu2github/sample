package mergeIntervals;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
import java.util.*;


public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
    	ArrayList<Interval>result = new ArrayList<Interval>();
    	boolean flag = false;
    	for (int i = 0; i < intervals.size() - 1; i++) {
    		Interval i1 = intervals.get(i);
    		Interval i2 = intervals.get(i+1);
    		if (overlap(i1,i2)) {
    			result.add(create(i1,i2));
    			flag = true;
    		}
    		else
    			result.add(i1);
    	}
    	if (flag)
    		return merge(result);
    	else 
    		return intervals;
    }
    
    public Interval create(Interval i1, Interval i2) {
    	if (i1.end >= i2.start) {
    		if (i1.end >= i2.end)
    			return new Interval(i1.start < i2.start ? i1.start : i2.start, i1.end);
    		return new Interval(i1.start < i2.start ? i1.start : i2.start, i2.end);
    		
    	} else {
    		if (i2.end >= i1.end)
    			return new Interval(i1.start < i2.start ? i1.start : i2.start, i2.end);
    		return new Interval(i1.start < i2.start ? i1.start : i2.start, i1.end);
    	}
    }
    
    public boolean overlap(Interval i1, Interval i2) {
    	return i1.end >= i2.start || i2.end>= i1.start;
    }

    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	Interval i1 = new Interval(1,4);
    	Interval i2 = new Interval(0,0);
    	ArrayList<Interval> intervals = new ArrayList<Interval>();
    	intervals.add(i1);
    	intervals.add(i2);
    	ArrayList<Interval> res = sol.merge(intervals);
    	
    	for (int i = 0; i < res.size(); i++) {
    		System.out.println(res.get(i).toString());
    	}
    }
}