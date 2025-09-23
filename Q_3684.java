class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int x : nums) {
            pq.add(x);
        }
        while(!pq.isEmpty() && list.size() < k) {
            int peek = pq.poll();
            if(list.size() == 0) {
                list.add(peek);
            } else if(list.get(list.size() - 1) != peek) {
                list.add(peek);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

//Time Complexity: O(n log n) (heap insertions and polling)
//Space Complexity: O(n) (priority queue + result list)
