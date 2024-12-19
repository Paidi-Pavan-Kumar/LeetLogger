class Recursion {

    class Solution {
        public void reverseString(char[] s) {
            reverse(s, 0, s.length - 1);
        }

        public void reverse(char[] s, int start, int end) {
            if (start >= end) {
                return;
            }
            swap(s, start, end);
            reverse(s, start + 1, end - 1);
        }

        public void swap(char[] s, int start, int end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
        }
    }

    // Time Complexity (TC):
    // Recursive calls: Each recursive call processes two characters (one swap
    // operation) and reduces the problem size by 2.
    // Total calls: Approximately
    // n/2, where
    // n is the length of the input array
    // Swapping operation: Constant time 
    // O(1)) for each recursive call.
    // Overall TC: O(n).

    // Space Complexity (SC):
    // Recursive stack: The recursion depth is proportional to
    // n/2, requiring a maximum of
    // O(n/2) space.
    // Asymptotically, this simplifies to O(n) space for the recursion stack.
    // Overall SC: O(n).

    // Note:
    // This solution uses a recursive approach, which has higher space complexity
    // than an iterative solution due to recursion stack overhead. An iterative
    // solution would achieve O(1) space complexity.

}