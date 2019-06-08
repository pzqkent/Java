public class Solution {
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here
        if (combo.length == 0) {
            return new String[0];
        }
        HashMap<String, Integer> myMap = new HashMap<>();
        for (String element : combo) {
            if (myMap.containsKey(element)) {
                myMap.replace(element, myMap.get(element) + 1);
            } else {
                myMap.put(element, 1);
            }
        }
        int size = k <= myMap.keySet().size() ? k : myMap.keySet().size();
        PriorityQueue<List<Object>> minHeap = new PriorityQueue<>(size, new Comparator<List<Object>>() {
            public int compare(List<Object> list1, List<Object> list2) {
                if (list1.get(1).equals(list2.get(1))) {
                    return 0;
                }
                return (Integer) list1.get(1) < (Integer) list2.get(1) ? -1 : 1;
            }
        });
        for (String key : myMap.keySet()) {

            if (minHeap.size() < size) {
                ArrayList<Object> temp = new ArrayList<>();
                temp.add(key);
                temp.add(myMap.get(key));
                minHeap.offer(temp);
            } else {
                if (myMap.get(key) > (Integer) minHeap.peek().get(1)) {
                    ArrayList<Object> temp = new ArrayList<>();
                    temp.add(key);
                    temp.add(myMap.get(key));
                    minHeap.poll();
                    minHeap.offer(temp);
                }
            }
        }
        String[] result = new String[size];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[size - i - 1] = (String) minHeap.poll().get(0);
            i++;
        }
        return result;
    }
}
// Time: O(n) + O(k) + O((n-k) * log(k)) + O(k);
// Space: O(hashmap) + O(k)