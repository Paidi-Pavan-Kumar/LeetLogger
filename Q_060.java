import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BruteTLE {

    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;
        List<String> list = new ArrayList<>();
        helper(arr, 0, list);
        Collections.sort(list);
        return list.get(k - 1);
    }

    public void helper(int[] arr, int index, List<String> res) {
        if (index == arr.length) {
            StringBuilder sb = new StringBuilder();
            for (int x : arr) {
                sb.append(x);
            }
            res.add(sb.toString());
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            helper(arr, index + 1, res);
            swap(arr, i, index);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Time Complexity:
    // O(n! × n)
    // n!: Total permutations generated.
    // O(n): Time to construct the string for each permutation.

    // Space Complexity:
    // Auxiliary Space:
    // Recursion stack: O(n), due to the depth of the recursion tree.
    // arr is reused and does not contribute additional space.

    // Result Storage:
    // O(n! × n), storing all permutations in the list.
    // Total Space Complexity: O(n! × n) (dominates the recursion stack).
}

class Optimal {

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            list.add(i);
        }
        list.add(n);
        StringBuilder res = new StringBuilder();
        k = k - 1; // 0 based indexing
        while (true) {
            res.append(list.get(k / fact));
            list.remove(k / fact);
            if (list.size() == 0)
                break;
            k = k % fact;
            fact = fact / list.size();
        }

        return res.toString();
    }

    // Complexity Analysis:
    // Time Complexity:
    // O(n²)

    // Building the initial list: Takes O(n).
    // Iterative process:
    // For each of the n iterations, removing an element from the list takes O(n) in
    // the worst case.
    // Total complexity for this operation is O(n²).
    // Space Complexity:
    // Auxiliary Space:

    // The list stores up to n elements: O(n).
    // The StringBuilder holds the result: O(n).
    // Recursion Stack:

    // No recursion is used.
    // Total Space Complexity: O(n)

}