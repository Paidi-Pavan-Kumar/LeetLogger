class Optimal {

    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        int start = 0;
        for (start = 0; start < k; start++) {
            leftSum += cardPoints[start];
        }
        int sum = leftSum;
        int end = cardPoints.length - 1;
        for (start = k - 1; start >= 0; start--, end--) {
            rightSum += cardPoints[end];
            leftSum -= cardPoints[start];
            sum = Math.max(sum, leftSum + rightSum);
        }
        return sum;
    }

    // Time Complexity (TC):
    // The initial loop to calculate the leftSum runs O(k).
    // The second loop also runs O(k).
    // Overall time complexity is O(k).

    // Space Complexity (SC):
    // The solution uses a constant amount of extra space, so the space complexity
    // is O(1).

}

