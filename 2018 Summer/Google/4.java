class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
          return findMedianSortedArrays(nums2, nums1);
        }

        int start = 0;
        int end = nums1.length;
        
        while (start <= end) {
          int p1 = (start + end) / 2;
          int p2 = (nums1.length + nums2.length + 1) / 2 - p1;

          if (p2 > 0 && p1 < nums1.length && nums2[p2 - 1] > nums1[p1]) {
            start = p1 + 1;
          } else if (p1 > 0 && p2 < nums2.length && nums1[p1 - 1] > nums2[p2]) {
            end = p1 - 1;
          } else {
            int left, right;
            if (p1 == 0)
              left = nums2[p2 - 1];
            else if (p2 == 0)
              left = nums1[p1 - 1];
            else
              left = Math.max(nums1[p1 - 1], nums2[p2 - 1]);

            if ((nums1.length + nums2.length) % 2 != 0)
              return left;

            if (p1 == nums1.length)
              right = nums2[p2];
            else if (p2 == nums2.length)
              right = nums1[p1];
            else
              right = Math.min(nums1[p1], nums2[p2]);

            return (left + right) / 2.0;
          }
        }
        return 0;
    }
}