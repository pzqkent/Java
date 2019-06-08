public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Write your solution here
        List result = new ArrayList<Object>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> combine = new ArrayList<>();
        DFS(candidates, target, result, 0, combine);
        return result;

    }

    private void DFS(int[] candidates, int target, List result, int index, List<Integer> combine) {
        if (target == 0) {
            List<Integer> cache = new ArrayList<>(combine);
            result.add(cache);
            return;
        }
        if (index == candidates.length) {
            return;
        }
        if (target >= candidates[index]) {
            for (int i = 0; i <= target / candidates[index]; i++) {
                for (int k = 0; k < i; k++) {
                    combine.add(candidates[index]); // 注意这里combine的写法
                }
                DFS(candidates, target - i * candidates[index], result, index + 1, combine);
                for (int k = 0; k < i; k++) {
                    combine.remove(combine.size() - 1);
                }
            }
        } else {
            return;
        }
    }
}
// Time: O(target^candidates.length) -- worst
// Space: log(candidates.length)--call stack + space(combine)