public class Solution {

    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        int index = 0;
        StringBuilder sol = new StringBuilder();

        DFS(set, index, sol, result);
        return result;

    }

    private void DFS(String set, int index, StringBuilder sol, List<String> result) {
        if (index == set.length()) {
            result.add(sol.toString());
            return;
        }
        sol.append(set.charAt(index));
        DFS(set, index + 1, sol, result);
        sol.deleteCharAt(sol.length() - 1);
        DFS(set, index + 1, sol, result);
    }

}
