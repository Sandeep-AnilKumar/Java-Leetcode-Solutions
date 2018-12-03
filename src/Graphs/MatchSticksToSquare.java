package Graphs;

import java.util.Arrays;
import java.util.HashMap;
import javafx.util.Pair;

public class MatchSticksToSquare {

    //TLE
//    private Set<State> set = new HashSet<>();
//    private int cost = 0;
//
//    class State {
//        int[] sides;
//        private int bitMask;
//
//        public State() {
//            this.sides = new int[4];
//            this.bitMask = 0;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || this.getClass() != o.getClass()) return false;
//            State other = (State) o;
//            return Arrays.equals(sides, other.sides) &&
//                    Objects.equals(bitMask, other.bitMask);
//        }
//
//        @Override
//        public int hashCode() {
//
//            int result = Objects.hash(bitMask);
//            result = 31 * result + Arrays.hashCode(sides);
//            return result;
//        }
//    }
//
//    public boolean makesquare(int[] nums) {
//        int N = nums.length;
//        int perimeter = 0;
//        for (int i = 0; i < N; ++i) perimeter += nums[i];
//        cost = perimeter / 4;
//        if (perimeter % 4 != 0) return false;
//
//        Arrays.sort(nums);
//        int temp = 0;
//
//        for (int i = 0; i < N/2; ++i) {
//            temp = nums[i];
//            nums[i] = nums[N - i - 1];
//            nums[N - i - 1] = temp;
//        }
//
//        return dfs(nums, 0, new State());
//    }
//
//    private boolean dfs(int[] nums, int index, State cur) {
//        if (allEdgesEqual(cur, cost)) return true;
//        State next;
//
//        for (int i = index; i < nums.length; ++i) {
//            if ((cur.bitMask & (1 << i)) == 0) {
//                for (int j = 0; j < 4; ++j) {
//                    if (cur.sides[j] + nums[i] <= cost) {
//                        cur.bitMask |= 1 << i;
//                        cur.sides[j] += nums[i];
//                        if (!set.contains(cur)) {
//                            set.add(cur);
//                            if (dfs(nums, index + 1, cur)) {
//                                return true;
//                            }
//                        }
//                        cur.sides[j] -= nums[i];
//                        cur.bitMask ^= 1 << i;
//                    }
//                }
//            }
//        }
//
//        return false;
//    }
//
//
//    private boolean allEdgesEqual(State cur, int cost) {
//        return cur.sides[0] == cost && cur.sides[0] == cur.sides[1] && cur.sides[1] == cur.sides[2];
//    }

    // The memoization cache to be used during recursion.
    public HashMap<Pair<Integer, Integer>, Boolean> memo;

    // Array containing our matchsticks.
    public int[] nums;

    // Possible side of our square depending on the total sum of all the matchsticks. 
    public int possibleSquareSide;

    // Default constructor to initialise our memo cache.
    public MatchSticksToSquare() {
        this.memo = new HashMap<Pair<Integer, Integer>, Boolean>();
    }

    // Main DP function.
    public boolean recurse(Integer mask, Integer sidesDone) {
        int total = 0;
        int L = this.nums.length;

        // The memo key for this recursion
        Pair<Integer, Integer> memoKey = new Pair<>(mask, sidesDone);

        // Find out the sum of matchsticks used till now.
        for(int i = L - 1; i >= 0; i--) {
            if ((mask&(1 << i)) == 0) {
                total += this.nums[L - 1 - i];
            }
        }

        // If the sum if divisible by our square's side, then we increment our number of complete sides formed variable.
        if (total > 0 && total % this.possibleSquareSide == 0) {
            sidesDone++;
        }

        // Base case.
        if (sidesDone == 3) {
            return true;
        }


        // Return precomputed results
        if (this.memo.containsKey(memoKey)) {
            return this.memo.get(memoKey);
        }

        boolean ans = false;
        int c = total / this.possibleSquareSide;

        // Remaining vlength in the current partially formed side.
        int rem = this.possibleSquareSide * (c + 1) - total;

        // Try out all remaining options (that are valid)
        for(int i = L - 1; i >= 0; i--) {
            if (this.nums[L - 1 - i] <= rem && (mask&(1 << i)) > 0) {
                if (this.recurse(mask ^ (1 << i), sidesDone)) {
                    ans = true;
                    break;
                }
            }
        }

        // Cache the computed results.
        this.memo.put(memoKey, ans);
        return ans;
    }

    public boolean makesquare(int[] nums) {

        // Empty matchsticks.
        if (nums == null || nums.length == 0) {
            return false;
        }

        // Find the perimeter of the square (if at all possible)
        int L = nums.length;
        int perimeter = 0;
        for(int i = 0; i < L; i++) {
            perimeter += nums[i];
        }

        int possibleSquareSide =  perimeter / 4;
        if (possibleSquareSide * 4 != perimeter) {
            return false;
        }

        this.nums = nums;
        this.possibleSquareSide = possibleSquareSide;
        return this.recurse((1 << L) - 1, 0);
    }

    public static void main(String[] args) {
        MatchSticksToSquare matchSticksToSquare = new MatchSticksToSquare();

//        int[] nums = {1,1,2,2,2};
//        System.out.println("Can we create a square? := " + matchSticksToSquare.makesquare(nums));
//
//        nums = new int[]{1,1,1,1,1,1,1,1};
//        System.out.println("Can we create a square? := " + matchSticksToSquare.makesquare(nums));
//
//        nums = new int[]{3,3,3,3,4};
//        System.out.println("Can we create a square? := " + matchSticksToSquare.makesquare(nums));
//
//        nums = new int[]{5,5,5,5,4,4,4,4,3,3,3,3};
//        System.out.println("Can we create a square? := " + matchSticksToSquare.makesquare(nums));
        
        Pair<Integer, Integer> pair = new Pair<>(Arrays.asList(5, 2).hashCode(), Arrays.asList(2, 5).hashCode());
        System.out.println(pair);
    }
}
