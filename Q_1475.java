import java.util.Stack;

class Optimal {

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() > prices[i]) {
                st.pop();
            }
            int currentPrice = prices[i];
            prices[i] = st.isEmpty() ? prices[i] : prices[i] - st.peek();
            st.push(currentPrice);
        }
        return prices;
    }

    // Time Complexity (TC):
    // The for loop iterates over all n elements of the prices array (O(n)).
    // The while loop pops elements from the stack only once for each element in
    // prices.
    // Each element is pushed and popped at most once, so the total complexity for
    // stack operations is O(n).
    // Overall TC: O(n).

    // Space Complexity (SC):
    // The Stack can hold at most n elements, which is the size of the input array
    // (O(n)).
    // No additional data structures are used other than the input and output
    // arrays, so no extra memory overhead.
    // Overall SC: O(n).

    // This is an efficient solution using a monotonic stack to calculate discounted
    // prices.

}
