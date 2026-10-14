class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0, left = 0;
        int type1 = -1, type2 = -1;
        int type1Count = 0, type2Count = 0;

        for (int right = 0; right < fruits.length; right++) {
            int fruit = fruits[right];

            if (fruit == type1) {
                type1Count++;
            } else if (fruit == type2) {
                type2Count++;
            } else if (type1Count == 0) {
                type1 = fruit;
                type1Count = 1;
            } else if (type2Count == 0) {
                type2 = fruit;
                type2Count = 1;
            } else {
                while (type1Count > 0 && type2Count > 0) {
                    int leftFruit = fruits[left];

                    if (leftFruit == type1) {
                        type1Count--;
                    } else {
                        type2Count--;
                    }

                    left++;
                }

                if (type1Count == 0) {
                    type1 = fruit;
                    type1Count = 1;
                } else {
                    type2 = fruit;
                    type2Count = 1;
                }
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}