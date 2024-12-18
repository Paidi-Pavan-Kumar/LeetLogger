import java.util.HashMap;

class BruteTLE {

    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE, startIndex = -1, endIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < t.length(); j++) {
                char c = t.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int count = 0;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (map.getOrDefault(c, 0) > 0) {
                    count++;
                }
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (count == t.length()) {
                    if (min > j - i + 1) {
                        startIndex = i;
                        endIndex = j;
                        min = Math.min(min, j - i + 1);
                    }
                    break;
                }
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, endIndex + 1);
    }

    // Time Complexity (TC):

    // Outer loop runs for every starting index of s (O(n)).
    // Inner loop iterates over the remaining characters of s for each outer loop
    // iteration (O(n)).
    // For each iteration of the inner loop, operations like adding to and checking
    // the hash map are O(1).
    // TC = O(n²), where n is the length of s.

    // Space Complexity (SC):
    // A hash map is created for the characters of t in every iteration of the outer
    // loop, which has a maximum size of O(m), where m is the length of t.
    // Overall space complexity: O(m).
    // This solution is inefficient due to its O(n²) time complexity and can be
    // optimized using the sliding window technique.

}

class Optimal {

    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE, startIndex = -1, endIndex = -1;
        int[] map = new int[256];
        int left = 0, right = 0;
        for (char c : t.toCharArray())
            map[c]++;
        int count = 0;
        while (right < s.length()) {
            if (map[s.charAt(right)] > 0)
                count++;
            map[s.charAt(right)]--;
            while (count == t.length()) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    startIndex = left;
                    endIndex = right;
                }

                map[s.charAt(left)]++;
                if (map[s.charAt(left)] > 0) {
                    count--;
                }
                left++;
            }
            right++;
        }

        return startIndex == -1 ? "" : s.substring(startIndex, endIndex + 1);
    }

    // Time Complexity (TC):
    // The right pointer traverses the string s once (O(n)).
    // For every position of the right pointer, the left pointer also moves at most
    // once over the length of s.
    // This results in a total complexity of O(n).

    // Space Complexity (SC):
    // The map array of size 256 is used to store character counts, which is O(1)
    // constant space since the size is fixed and independent of input size.

    // Overall Complexity:
    // TC = O(n), where n is the length of s.
    // SC = O(1).
    // This implementation is efficient, leveraging the sliding window technique to
    // minimize redundant computations.

}