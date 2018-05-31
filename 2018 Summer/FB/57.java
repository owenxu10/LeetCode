// 57. Insert Interval

// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

// You may assume that the intervals were initially sorted according to their start times.

// Example 1:

// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]
// Example 2:

// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int p = 0;
        
        while(p < intervals.size() && newInterval.start>intervals.get(p).end) {
            result.add(intervals.get(p++));
        }
        
        while(p < intervals.size() && intervals.get(p).start <= newInterval.end ) {
            newInterval.start = Math.min(intervals.get(p).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(p).end, newInterval.end);
            p++;
        }
        
        result.add(newInterval);
        
        while(p < intervals.size()) {
            result.add(intervals.get(p++));
        }
        
        return result;
    }
}