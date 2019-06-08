public class Solution {
    public List<String> permutations(String set) {
        // Write your solution here
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        if (set.length() == 0) {
            result.add("");
            return result;
        }
        char[] temp = set.toCharArray();
        StringBuilder sol = new StringBuilder();
        HashSet<String> newSet = new HashSet<>();
        DFS(0, temp, newSet);
        for (String element : newSet) {
            result.add(element);
        }
        return result;

    }

    private void DFS(int index, char[] temp, HashSet<String> newSet) {
        if (index == temp.length - 1) { // 注意判断边界条件
            newSet.add(new String(temp));
            return;
        }
        for (int i = index + 1; i < temp.length; i++) { // 注意判断i的边界条件
            swap(temp, index, i);
            DFS(index + 1, temp, newSet);
            swap(temp, index, i);
            DFS(index + 1, temp, newSet);
        }
    }
    // private void DFS(int index, char[] temp, HashSet<String> newSet) {
    // if (index == temp.length) {
    // newSet.add(new String(temp));
    // return;
    // }
    // for (int i = index; i < temp.length; i++) {
    // swap(temp, index, i);
    // DFS(index+1, temp, newSet);
    // swap(temp, index, i);
    // DFS(index+1, temp, newSet);
    // }
    // }

    private void swap(char[] temp, int index, int i) {
        char cache = temp[index];
        temp[index] = temp[i];
        temp[i] = cache;
    }
}
// Time: O(n!)
// Space: O(2^n)--worse: comes from hashset