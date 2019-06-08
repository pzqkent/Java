public class Solution {
    public String compress(String input) {
        // Write your solution here
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        int globalCounter = 0;
        while (fast + 1 < array.length) {
            if (array[fast] != array[fast + 1]) {
                globalCounter++;
                array[slow] = array[fast];
                slow++;
                fast++;
            } else if (array[fast] == array[fast + 1]) {
                array[slow] = array[fast];
                slow++;
                int counter = 1;
                while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
                    counter++;
                    fast++;
                }
                String count = String.valueOf(counter); // 处理连续字母字母数量大于9的情况
                for (int i = 0; i < count.length(); i++) {
                    array[slow++] = count.charAt(i);
                }
                fast++;
            }
        }
        // 明确slow的物理意义：slow左边是处理过的字母

        // post process：因为上面可能没有遍历到原字符串最后一个字母
        if (fast <= 1 || (fast < input.length() && input.charAt(fast) != input.charAt(fast - 1))) {
            globalCounter++; // edge case: len(input) = 1;
            array[slow] = array[fast];
            slow++;
        }
        char[] result = new char[slow + globalCounter];
        fast = slow - 1;
        slow = result.length - 1;
        while (fast >= 0) {
            if (fast > 0 && Character.isDigit(array[fast]) && Character.isDigit(array[fast - 1])) {
                result[slow--] = array[fast--];
            } else if (Character.isDigit(array[fast])) {
                result[slow--] = array[fast--];
                result[slow--] = array[fast--];
            } else {
                result[slow--] = (char) '0' + 1;
                result[slow--] = array[fast--];
            }
        }
        return new String(result);

    }
}
// Time: O(n) -- did not consider the time consuming on assign counter number in
// case that counter > 9
// Space: O(1) -- did not consider the space of new arranged char array;