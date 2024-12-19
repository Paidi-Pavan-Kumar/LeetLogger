class Iterative {

    public int fib(int n) {
        if (n == 0)
            return 0;
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }

    // Time Complexity (TC):
    // Loop execution: The loop runs from
    // i=2 to
    // n, which is
    // O(n).
    // Operations inside the loop (addition, assignment):
    // O(1).
    // Overall TC: O(n).

    // Space Complexity (SC):
    // Auxiliary space: Only a constant amount of space is used for first, second,
    // and temp.
    // No recursion or additional data structures are used.
    // Overall SC: O(1).

    // Summary:
    // Time Complexity:
    // O(n).
    // Space Complexity:
    // O(1).
    // This iterative approach is both time-efficient and space-efficient compared
    // to the recursive method or a DP table.

}

class Recursion {

    public int fib(int n) {
        if (n == 1 || n == 0)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    // Time Complexity (TC):
    // This is a recursive implementation of the Fibonacci sequence, and its time
    // complexity arises due to repeated computations.
    // Recursive Tree Growth:
    // Each call to fib(n) generates two recursive calls: fib(n - 1) and fib(n - 2).
    // This forms a binary tree of recursive calls, with a depth of
    // n.

    // Total Recursive Calls:
    // The number of calls grows exponentially, resulting in a time complexity of 2^n
    // Overall TC: O(2^n) (exponential).

    // Space Complexity (SC):
    // Auxiliary Space:
    // Each recursive call is added to the call stack. The maximum depth of
    // recursion is n.
    // Therefore, the space complexity due to the call stack is
    // O(n).
    // Overall SC: O(n).

    // Summary:
    // Time Complexity:
    // O(2^n) (inefficient due to redundant calculations).
    
    // Space Complexity:
    // O(n) (stack depth).
    // This implementation is inefficient for large
    // n and is typically replaced by dynamic programming or iterative approaches.

}