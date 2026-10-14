class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0, left = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            int fruit = fruits[right];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);

            if (map.size() <= 2) {
                int total = 0;

                for (int key : map.keySet()) {
                    total += map.get(key);
                }

                max = Math.max(max, total);
            } else {
                while (left <= right && map.size() > 2) {
                    if (map.get(fruits[left]) > 1) {
                        map.put(fruits[left], map.get(fruits[left]) - 1);
                    } else {
                        map.remove(fruits[left]);
                    }

                    left++;
                }
            }
        }

        return max;
    }
}