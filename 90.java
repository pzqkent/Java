class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> fnl = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(fnl,new ArrayList<Integer>(),nums,0);
        return fnl;
        
        
        
    }
    
    public void helper(List<List<Integer>> fnl, List<Integer> temp, int[] nums, int start) {
        fnl.add(new ArrayList<Integer>(temp));
        for (int i=start;i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1]) {
                continue;
            }
            temp.add(nums[i]);
            helper(fnl,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
        
    }
}