/**
 You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

 Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

 Return intervals after the insertion.

 Example 1:

 Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 Output: [[1,5],[6,9]]
 Example 2:

 Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 Output: [[1,2],[3,10],[12,16]]
 Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

 Constraints:

 0 <= intervals.length <= 104
 intervals[i].length == 2
 0 <= starti <= endi <= 105
 intervals is sorted by starti in ascending order.
 newInterval.length == 2
 0 <= start <= end <= 105
 */

package main.java.array;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] merged = new int[intervals.length + 1][2];
        int mergeIdx = 0, start, end;
        boolean checked = false;

        for (int i = 0, j = 0, k = 0; i < intervals.length; i = j) {
            start = intervals[i][0];
            end = intervals[i][1];

            if (!checked && newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
                start = intervals[i][0];

                for (j = i; j < intervals.length && newInterval[1] > intervals[j][1]; j++);

                if (j == intervals.length || newInterval[1] < intervals[j][0]) {
                    end = newInterval[1];
                    j--;
                } else {
                    end = intervals[j][1];
                }
                checked = true;
            } else if (!checked && newInterval[0] < intervals[i][0]) {
                start = newInterval[0];

                for (k = i; k < intervals.length && newInterval[1] > intervals[k][1]; k++);

                if (k == intervals.length || newInterval[1] < intervals[k][0]) {
                    end = newInterval[1];
                    j = k - 1;
                } else {
                    end = intervals[k][1];
                    j = k;
                }
                checked = true;
            }

            merged[mergeIdx++] = new int[] {start, end};
            j++;
        }

        if (!checked) {
            merged[mergeIdx++] = newInterval;
        }

        int[][] ans = new int[mergeIdx][2];
        System.arraycopy(merged, 0, ans, 0, mergeIdx);

        return ans;
    }
}
