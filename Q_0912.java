import java.util.ArrayList;
import java.util.List;

class MergeALGO {

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while (left <= mid)
            temp.add(nums[left++]);
        while (right <= high)
            temp.add(nums[right++]);
        for (left = 0; left < temp.size(); left++) {
            nums[left + low] = temp.get(left);
        }
    }

    // Time Complexity:
    // Divide step (recursive calls): O(log n), since the array is divided into two
    // halves at each level of recursion.
    // Merge step: O(n), since each element is merged once in each level of
    // recursion.
    // Overall time complexity: O(n log n)

    // Space Complexity:
    // Space for temporary list during merging: O(n), due to the temporary list used
    // to hold merged elements.
    // Overall space complexity: O(n)

}

class QuickALGO {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int partitionIndex = quick(nums, low, high);
        quickSort(nums, low, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, high);
    }

    public int quick(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low + 1, right = high;
        while (left <= right) {
            while (left <= high && arr[left] < pivot) {
                left++;
            }
            while (right >= low && arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        arr[low] = arr[right];
        arr[right] = pivot;
        return right;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Time Complexity:

    // Best Case: O(n log n) — When the pivot divides the array into two roughly
    // equal halves at every recursive step.
    // Average Case: O(n log n) — On average, the pivot partitions the array into
    // reasonably balanced halves.
    // Worst Case: O(n²) — When the pivot consistently divides the array into an
    // unbalanced partition (e.g., one partition has n-1 elements and the other has
    // 0).
    // Overall Time Complexity: O(n log n) on average and O(n²) in the worst case.

    // Space Complexity:

    // Call Stack Space: O(log n) for the best/average case and O(n) for the worst
    // case due to the recursive depth.
    // Auxiliary Space: O(1) since quicksort operates in-place.
    // Overall Space Complexity: O(log n) on average, O(n) in the worst case.

}
