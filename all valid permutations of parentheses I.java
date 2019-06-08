public class Solution {
    public List<String> validParentheses(int n) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        int index = 0;
        int l = 0;
        int r = 0;
        StringBuilder sol = new StringBuilder();
        DFS(index, l, r, sol, result, n);
        return result;
    }

    private void DFS(int index, int l, int r, StringBuilder sol, List<String> result, int n) {
        if (index == n * 2) {
            result.add(sol.toString());
        }
        if (l < n) {
            sol.append('(');
            DFS(index + 1, l + 1, r, sol, result, n);
            sol.deleteCharAt(sol.length() - 1);
        }

        if (r < l && r < n) {
            sol.append(')');
            DFS(index + 1, l, r + 1, sol, result, n);
            sol.deleteCharAt(sol.length() - 1);
        }

    }
}
// 时间？
// 空间？