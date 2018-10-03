package Arrays;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1, max = 0;

        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("The container with most water is := " + new ContainerWithMostWater().maxArea(height));
    }
}
