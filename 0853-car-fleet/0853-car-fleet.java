class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }

        Arrays.sort(position);
        
        double[] stack = new double[position.length];
        int top = -1;

        for (int i = position.length - 1; i >= 0; i--) {
            double time = (double) (target - position[i]) / map.get(position[i]);

            if (top == -1 || time > stack[top]) {
                stack[++top] = time;
            }
        }

        return top + 1;
    }
}