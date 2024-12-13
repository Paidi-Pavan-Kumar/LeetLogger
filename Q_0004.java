class Brute {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 != 0) {
            int mid = (m + n) / 2;
            int index = 0;
            int i = 0, j = 0;
            while (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    if (index == mid)
                        return nums1[i];
                    i++;
                    index++;
                } else {
                    if (index == mid)
                        return nums2[j];
                    j++;
                    index++;
                }
            }
            while (i < m) {
                if (index == mid)
                    return nums1[i];
                i++;
                index++;
            }
            while (j < n) {
                if (index == mid)
                    return nums2[j];
                j++;
                index++;
            }
        } else {
            int first = (m + n) / 2 - 1;
            int second = (m + n) / 2;
            int index = 0;
            int i = 0, j = 0;
            double ans = 0;
            while (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    if (index == first)
                        ans += nums1[i];
                    if (index == second)
                        ans += nums1[i];
                    i++;
                    index++;
                } else {
                    if (index == first)
                        ans += nums2[j];
                    if (index == second)
                        ans += nums2[j];
                    j++;
                    index++;
                }
            }
            while (i < m) {
                if (index == first)
                    ans += nums1[i];
                if (index == second)
                    ans += nums1[i];
                i++;
                index++;
            }
            while (j < n) {
                if (index == first)
                    ans += nums2[j];
                if (index == second)
                    ans += nums2[j];
                j++;
                index++;
            }

            return ans / 2;
        }
        return -1;
    }

    // Time Complexity (TC):
    // Merging two arrays: The algorithm effectively merges the two sorted arrays up
    // to the median indices. This takes at most O(m + n), where
    // m and n are the sizes of nums1 and nums2.

    // Space Complexity (SC):
    // O(1): The algorithm uses only a constant amount of extra space for variables
    // (i, j, index, ans, etc.), as it does not create additional data structures.
}

class Optimal {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (n < m)
            return findMedianSortedArrays(nums2, nums1);
        int low = 0, high = m;
        while (low <= high) {
            int nums1_mid = low + (high - low) / 2;
            int nums2_mid = (m + n + 1) / 2 - nums1_mid;
            int left1 = Integer.MIN_VALUE;
            int left2 = Integer.MIN_VALUE;
            int right1 = Integer.MAX_VALUE;
            int right2 = Integer.MAX_VALUE;
            if (nums1_mid < m)
                right1 = nums1[nums1_mid];
            if (nums2_mid < n)
                right2 = nums2[nums2_mid];
            if (nums1_mid - 1 >= 0)
                left1 = nums1[nums1_mid - 1];
            if (nums2_mid - 1 >= 0)
                left2 = nums2[nums2_mid - 1];
            if (left1 <= right2 && left2 <= right1) {
                int size = m + n;
                if (size % 2 != 0) {
                    return (double) Math.max(left1, left2);
                } else {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
            } else if (left1 > right2) {
                high = nums1_mid - 1;
            } else {
                low = nums1_mid + 1;
            }
        }
        return 0;
    }

    // Time Complexity (TC):
    // The algorithm performs a binary search on the smaller array (nums1 or nums2),
    // so the time complexity is O(log(min(m, n))), where
    // m and n are the sizes of nums1 and nums2.
    
    // Space Complexity (SC):
    // O(1): The algorithm uses only a constant amount of extra space for variables
    // (low, high, nums1_mid, nums2_mid, etc.), without additional data structures.

}
