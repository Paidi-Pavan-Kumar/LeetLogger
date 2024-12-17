class BruteTLE {

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] map = new int[26];
            int maxFreq = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                map[c - 'A']++;
                if (map[c - 'A'] > maxFreq) {
                    maxFreq++;
                }
                int changes = (j - i + 1) - maxFreq;
                if (changes <= k) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    // Time Complexity (TC):
    // Outer loop runs O(n), and inner loop runs O(n) in the worst case, resulting
    // in O(n²).

    // Space Complexity (SC):
    // The frequency array map has a fixed size of 26, resulting in O(1) auxiliary
    // space.

}

class Better {

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int max = 0;
        int left = 0, right = 0;
        int[] map = new int[26];
        int maxFreq = 0;
        while (right < n) {
            char c = s.charAt(right);
            map[c - 'A']++;
            if (map[c - 'A'] > maxFreq) {
                maxFreq++;
            }

            while (((right - left + 1) - maxFreq) > k) {
                char l = s.charAt(left);
                map[l - 'A']--;
                maxFreq = 0;
                for (int x : map)
                    maxFreq = Math.max(maxFreq, x);
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    // Time Complexity (TC):
    // The outer loop runs O(n) as the right pointer traverses the string.
    // The inner loop (for maxFreq recalculation) runs O(26) at most, so it
    // simplifies to O(n) overall.
    // Total complexity: O(n).

    // Space Complexity (SC):
    // The map array has a fixed size of 26, resulting in O(1) auxiliary space.

}

class Optimal {

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int max = 0;
        int left = 0, right = 0;
        int[] map = new int[26];
        int maxFreq = 0;
        while (right < n) {
            char c = s.charAt(right);
            map[c - 'A']++;
            if (map[c - 'A'] > maxFreq) {
                maxFreq++;
            }

            if (((right - left + 1) - maxFreq) > k) {
                char l = s.charAt(left);
                map[l - 'A']--;
                maxFreq = 0;
                for (int x : map)
                    maxFreq = Math.max(maxFreq, x);
                left++;
            }

            if (((right - left + 1) - maxFreq) <= k) {
                max = Math.max(max, right - left + 1);
            }
            right++;
        }
        return max;
    }

    // Time Complexity (TC):
    // The right pointer traverses the string once, so O(n).
    // The inner recalculation of maxFreq involves a loop of fixed size 26, which is
    // O(1).
    // Total complexity: O(n).

    // Space Complexity (SC):
    // The map array is of fixed size 26, resulting in O(1) auxiliary space.

}