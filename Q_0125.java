class Recursion {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        return palin(s, 0, s.length() - 1);
    }

    public boolean palin(String s, int start, int end) {
        if (start >= end)
            return true;
        if (s.charAt(start) != s.charAt(end))
            return false;
        return palin(s, start + 1, end - 1);
    }

    // Time Complexity (TC):
    // Normalization (lowercasing and removing non-alphanumeric characters):
    // Converting the string to lowercase: O(n), where
    // n is the length of the string.
    // Removing non-alphanumeric characters with replaceAll: O(n).
    // Total preprocessing time: O(n).
    // Recursive palindrome check:
    // Each recursive call compares two characters and reduces the problem size by
    // 2.
    // Total recursive calls:
    // n/2.
    // Time for palindrome check: O(n).
    // Overall TC: O(n).

    // Space Complexity (SC):
    // Recursive stack:
    // Maximum recursion depth:
    // n/2.
    // Stack space: O(n).
    // Normalized string creation:
    // Creating a new string after replaceAll: O(n).
    // Overall SC: O(n).

    // Notes:
    // The recursive approach can be replaced with an iterative approach to reduce
    // space complexity to O(1) for the palindrome check.
    // Regular expression processing (`replaceAll`) can be slower for large strings,
    // so alternatives like manual character filtering can improve performance.

}