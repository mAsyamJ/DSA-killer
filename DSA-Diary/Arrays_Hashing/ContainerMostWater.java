// My SOlution

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int[] result = new int[n];

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int length = j - i;

                if (height[i] > height[j]) {
                    result[i] = Math.max(result[i], length * height[j]);
                } else {
                    result[i] = Math.max(result[i], length * height[i]);
                }
            }
        }

        // Find the max value in result array
        int max = 0;
        for (int area : result) {
            if (area > max) {
                max = area;
            }
        }

        return max;
    }
}

// Better solution with Two Pointers from left and right side