public class Solution {
    public boolean canPermutePalindrome(String input) {
        // Write your solution here
        if (input == null) {
            return false;
        }
        if (input.length() == 0) {
            return true;
        }
        char[] temp = input.toCharArray();
        // StringBuilder sol = new StringBuilder();
        boolean[] result = new boolean[] { false };
        DFS(0, temp, result);
        return result[0];
    }

    private void DFS(int index, char[] temp, boolean[] result) {
        if (index == temp.length) {
            if (isPalindrome(new String(temp))) {
                result[0] = true;
                return;
            } else {
                return;
            }
        }
        for (int i = index; i < temp.length; i++) {
            if (result[0] == true) {
                break;
            }
            swap(temp, index, i);
            DFS(index + 1, temp, result);
            swap(temp, index, i);
        }
    }

    private boolean isPalindrome(String input) {
        if (input.length() == 0) {
            return true;
        }
        StringBuilder temp = new StringBuilder(input);
        temp = temp.reverse();

        if (input.equals(temp.toString())) { // 注意此处不能使用"==" 来判断是否相等
            return true;
        } else {
            return false;
        }
    }

    private void swap(char[] temp, int index, int i) {
        char cache = temp[index];
        temp[index] = temp[i];
        temp[i] = cache;
    }
}
// Time: O(input.length()!) -- worse
// Space: O(input.length())
