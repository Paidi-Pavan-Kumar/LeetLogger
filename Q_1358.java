class BruteTLE {

    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] map = new int[3];
            for (int j = i; j < n; j++) {
                map[s.charAt(j) - 'a'] = 1;
                if (map[0] + map[1] + map[2] == 3) {
                    count++;
                }
            }
        }
        return count;
    }

    // Time Complexity (TC):
    // The outer loop runs O(n) times, and the inner loop runs on average O(n/2)
    // times, resulting in a complexity of O(n²).
    // Space Complexity (SC):
    // The map array has a fixed size of 3, resulting in O(1) auxiliary space.

}

class BetterTLE {

    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] map = new int[3];
            for (int j = i; j < n; j++) {
                map[s.charAt(j) - 'a'] = 1;
                if (map[0] + map[1] + map[2] == 3) {
                    count += (n - j);
                    break;
                }
            }
        }
        return count;
    }

}

class Optimal {

    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int[] lastSeen = { -1, -1, -1 };
        for (int i = 0; i < n; i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                int min = lastSeen[0] < lastSeen[1] &&
                        lastSeen[0] < lastSeen[2] ? lastSeen[0] : lastSeen[1] < lastSeen[2] ? lastSeen[1] : lastSeen[2];
                count += (min + 1);
            }
        }
        return count;
    }

    // Time Complexity (TC):
    // The loop runs O(n) times, and each operation inside is O(1), making the
    // overall complexity O(n).

    // Space Complexity (SC):
    // The lastSeen array has a fixed size of 3, resulting in O(1) auxiliary space.

}