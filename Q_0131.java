import java.util.ArrayList;
import java.util.List;

class Recursion {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), res);
        return res;
    }

    public void helper(String s, int index, List<String> list, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                list.add(s.substring(index, i + 1));
                helper(s, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    // Time Complexity:
    // The algorithm performs backtracking, where the recursion explores all
    // possible ways to partition the string into substrings.
    // At each step, for each index i, the isPalindrome check runs in O(n) time
    // where n is the length of the substring being checked.
    // The maximum number of substrings we can generate in the worst case is 2^n,
    // where n is the length of the string, since every character can either be part
    // of a palindrome substring or not.
    // Thus, the time complexity is O(2^n * n), where n is the length of the string,
    // since we perform the palindrome check for each substring.

    // Space Complexity:
    // The recursion depth can go as deep as n (the length of the string), and we
    // use a list to store the partitions, which takes space proportional to the
    // number of palindromic partitions.
    // So, the space complexity is O(n) for the recursion call stack and O(2^n * n)
    // for storing the partitions in the result list.
    // Overall Time Complexity: O(2^n * n)
    // Overall Space Complexity: O(2^n * n)

}