public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Write your solution here
        // quick select
        if (nums.length == 0) {
            return -1;
        }
        return helper(nums, k, 0, nums.length - 1);
    }

    private int helper(int[] nums, int k, int start, int end) {
        int mid = partition(nums, start, end);
        if (nums.length - mid == k) {
            return nums[mid];
        } else if (nums.length - mid > k) {
            return helper(nums, k, mid + 1, end);
        } else {
            return helper(nums, k, start, mid - 1);
        }
    }

    private int partition(int[] nums, int start, int end) {
        if (nums.length == 0) {
            return 0;
        }
        int pivot = end;
        int l = start;
        int r = pivot - 1;
        while (l <= r) {
            if (nums[l] <= nums[pivot]) {
                l++;
            } else {
                swap(nums, l, r);
                r--;
            }
        }
        swap(nums, l, pivot);
        return l;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}
// Time: average O(n), worst O(n^2)
// Space: average O(log(n)), worst(O(n))
