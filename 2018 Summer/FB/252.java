// 252. Meeting Rooms

// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

// Example 1:

// Input: [[0,30],[5,10],[15,20]]
// Output: false
// Example 2:

// Input: [[7,10],[2,4]]
// Output: true

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
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparing((Interval s) -> s.start));
        
        for (int i = 0; i < intervals.length-1; i++) {
            if (intervals[i+1].start < intervals[i].end) {
                return false;
            }
        }
        return true;
    }
}