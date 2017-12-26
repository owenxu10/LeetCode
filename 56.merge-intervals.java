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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList();
        if (intervals.size() == 0)
            return result;
        intervals.sort((a,b)->Integer.compare(a.start,b.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval i:intervals){
            if(i.start > end){
                result.add(new Interval(start,end));
                start = i.start;
                end = i.end;
            }
            else{
                end = Math.max(end, i.end);
            }
        }
        result.add(new Interval(start,end));
        return result;
    }
}
