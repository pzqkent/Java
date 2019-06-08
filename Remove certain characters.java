public class Solution {
    public String remove(String input, String t) {
        // Write your solution here
        if (input.length() == 0) {
            return input;
        }
        StringBuilder sol = new StringBuilder(input);
        HashSet<Character> toRemove = new HashSet<>();
        for (char letter : t.toCharArray()) {
            if (!toRemove.contains(letter)) {
                toRemove.add(letter);
            }
        }
        int slow = 0;
        int fast = 0;
        for (; fast < input.length(); fast++) {
            if (toRemove.contains(sol.charAt(fast))) { // 注意StringBuilder相关api的应用
                continue;
            } else {
                sol.setCharAt(slow, sol.charAt(fast));
                slow++;
            }
        }
        sol.delete(slow, input.length());
        return sol.toString();
    }
}
// Time: O(n) 空间换时间
// Space: O(len(input) + len(t))