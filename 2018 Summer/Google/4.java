// 4. Median of Two Sorted Arrays

// There are two sorted arrays nums1 and nums2 of size m and n respectively.

// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

// Example 1:
// nums1 = [1, 3]
// nums2 = [2]

// The median is 2.0
// Example 2:
// nums1 = [1, 2]
// nums2 = [3, 4]

// The median is (2 + 3)/2 = 2.5

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      if (nums1.length > nums2.length) {
          return findMedianSortedArrays(nums2, nums1);
      }

      int start = 0, end = nums1.length, p1, p2, half = (nums1.length + nums2.length + 1) / 2;
      while (start <= end) {
          p1 = (start + end) / 2;
          p2 = half - p1;
          if (p2 > 0 && p1 < nums1.length && nums2[p2 - 1] > nums1[p1]) {
              start = p1 + 1;
          } else if (p1 > 0 && p2 < nums2.length && nums1[p1 - 1] > nums2[p2]) {
              end = p1 - 1;
          } else {
              int left, right;
              if (p2 == 0)
                  left = nums1[p1 - 1];
              else if (p1 == 0)
                  left = nums2[p2 - 1];
              else
                  left = Math.max(nums1[p1 - 1], nums2[p2 - 1]);

              if ((nums1.length + nums2.length) % 2 != 0) {
                  return left;
              } else {
                  if (p1 == nums1.length) {
                      right = nums2[p2];
                  } else if (p2 == nums2.length) {
                      right = nums1[p1];
                  } else
                      right = Math.min(nums1[p1], nums2[p2]);
              }
              return (left + right) / 2.0;
          }
      }
      return 0;
    }
}