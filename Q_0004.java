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
