class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                nums2[stack.pop()] = nums2[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            nums2[stack.pop()] = -1;
        }

        int[] ans = new int[nums1.length];
        
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums2[map.get(nums1[i])];
        }

        return ans;
    }
}