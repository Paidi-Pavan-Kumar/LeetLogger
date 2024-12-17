import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Brute {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

    // Time Complexity (TC):

    // The outer loop runs for O(n), where n is the length of the string.
    // The inner loop, in the worst case, iterates over the remaining characters,
    // leading to a quadratic complexity.
    // Overall, the time complexity is O(n²).
    // Space Complexity (SC):

    // The Set data structure used in the inner loop can hold at most n characters
    // in the worst case, making the space complexity O(n).

}

class Optimal {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        int left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < n) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
                map.put(c, right);
            } else {
                max = Math.max(max, right - left + 1);
                map.put(c, right);
            }
            right++;
        }
        return max;
    }

    // Time Complexity (TC):
    // The right pointer iterates over the string O(n), where n is the length of the
    // string.
    // Operations on the HashMap (insertion and lookup) are on average O(1).
    // Overall time complexity is O(n).


    // Space Complexity (SC):
    // The HashMap stores at most n characters, making the space complexity O(n).

}
