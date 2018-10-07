package Arrays;

public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int prev = -1, cur = 0, next = 0, left = 0, right = 0, total = seats.length;
        int ans = Integer.MIN_VALUE;

        for (; cur < total; ++cur) {
            if (seats[cur] == 1) {
                prev = cur;
            } else {
                while (next < total && seats[next] == 0 || next < cur) next++;
                left = prev == -1 ? total : cur - prev;
                right = next == total ? total : next - cur;
                ans = Math.max(ans, Math.min(left, right));
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] seats = {1, 0, 0, 0};
        System.out.println("The maximum distance from the next person is := " + new MaximizeDistanceToClosestPerson().maxDistToClosest(seats));
    }
}
