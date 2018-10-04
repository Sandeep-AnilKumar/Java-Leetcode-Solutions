package Arrays;

public class NumFriendRequests {
    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length == 0) return 0;
        int[] ageCount = new int[121];

        int count = 0;

        for (int i = 0; i < ages.length; ++i) ageCount[ages[i]]++;

        for (int i = 0; i < ages.length; ++i) {
            for (int j = (int)(ages[i] * 0.5) + 8; j <= ages[i]; ++j) {
                count += ageCount[j];
                if (ages[i] == j) count--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ages = {16, 17, 18};
        System.out.println("The number of friend requests are := " + new NumFriendRequests().numFriendRequests(ages));
    }
}
