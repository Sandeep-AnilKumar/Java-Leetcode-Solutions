package DynamicProgramming;

public class RangeSumQueryMutable {
    int[] data;
    int[] fenTree;
    int length;

    //Time to build Fenwick Tree O(n logn). Time to retrieve sum -> O(logn), time to update -> O(logn), space -> O(n).
    //Simply Awesome :-)

    public RangeSumQueryMutable(int[] nums) {
        if(nums == null || nums.length == 0) {
            this.data = null;
            this.fenTree = null;
            this.length = 0;
            return;
        }
        data = nums;
        length = nums.length;
        fenTree = new int[length + 1];
        fenTree[0] = 0;
        int next = 0;
        for(int i = 0; i < length; ++i) {
            next = i + 1;
            fenTree[next] += nums[i];
            while(next - 1 < length) {
                next = getNext(next);
                if(next - 1 < length) {
                    fenTree[next] += nums[i]; 
                }
            }
        }
    }

    public int getNext(int num) {
        return (-num & num) + num;
    }

    public void update(int i, int val) {
        int diff = val - data[i];
        data[i] = val;
        fenTree[i + 1] += diff;
        int next = i + 1;
        while(next - 1 < length) {
            next = getNext(next);
            if(next - 1 < length) {
                fenTree[next] += diff; 
            }
        }
        return;
    }

    public int getSum(int num) {
        int sum = 0;
        while(num > 0) {
            sum += fenTree[num];
            num -= (-num & num);
        }
        return sum;
    }

    //sum(j + 1) - sum(i);
    public int sumRange(int i, int j) {
        return i == 0 ? getSum(j + 1) : getSum(j + 1) - getSum(i);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,7,2,0};
        RangeSumQueryMutable r = new RangeSumQueryMutable(nums);
        r.update(4,6);
        r.update(0,2);
        r.update(0,9);
        System.out.println(r.sumRange(4,4));
        r.update(3,8);
        System.out.println(r.sumRange(0,4));
        r.update(4,1);
        System.out.println(r.sumRange(0,3));
        System.out.println(r.sumRange(0,4));
        r.update(0,4);
    }
}
