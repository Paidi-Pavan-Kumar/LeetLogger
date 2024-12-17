import java.util.HashMap;

class Better {

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        while (right < n) {
            int fruit = fruits[right];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.getOrDefault(fruits[left], 0) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    // Time Complexity (TC):
    // The while loop traverses the array once, and each element is processed at
    // most twice (once when adding to the map, once when removing), resulting in
    // O(n).

    // Space Complexity (SC):
    // The HashMap stores at most 2 keys (types of fruits), leading to O(1)
    // auxiliary space.

}

class Optimal {

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        while(right < n) {
            int fruit = fruits[right];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
            if(map.size() > 2) {
                map.put(fruits[left], map.getOrDefault(fruits[left] , 0) - 1);
                if(map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            if(map.size() <= 2) {
                max = Math.max(max, right - left + 1);
            }
            right++;
        }
        return max;
    }

}