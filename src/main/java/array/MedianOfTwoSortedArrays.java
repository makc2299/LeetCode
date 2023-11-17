/**
 Given two sorted arrays nums1 and nums2 of size m and n respectively,
 return the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:

 Input: nums1 = [1,3], nums2 = [2]
 Output: 2.00000
 Explanation: merged array = [1,2,3] and median is 2.
 Example 2:

 Input: nums1 = [1,2], nums2 = [3,4]
 Output: 2.50000
 Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

 Constraints:

 nums1.length == m
 nums2.length == n
 0 <= m <= 1000
 0 <= n <= 1000
 1 <= m + n <= 2000
 -106 <= nums1[i], nums2[i] <= 106
 */

package main.java.array;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int []nums3 = new int[nums1.length + nums2.length];
        int idx1 = 0, idx2 = 0, idx3 = 0;

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] < nums2[idx2]) {
                nums3[idx3++] = nums1[idx1++];
            } else {
                nums3[idx3++] = nums2[idx2++];
            }
        }

        while (idx1 < nums1.length) {
            nums3[idx3++] = nums1[idx1++];
        }

        while (idx2 < nums2.length) {
            nums3[idx3++] = nums2[idx2++];
        }

        if ((nums3.length % 2) == 0) {
            return ((nums3[nums3.length / 2 - 1] + nums3[nums3.length / 2]) / 2.0);
        }
        return nums3[nums3.length / 2];
    }
}
