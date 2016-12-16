package Arrays;
class GetMissingRanges {

    public static void main(String[] args) {
        int[] nums = {1,2,50,52,76};
        int start = 0;
        int end = 99;

        System.out.println("The missing ranges from " + start + " to " + end + " in array " 
                + printArray(nums) + " are := " + getRanges(nums, start, end));
    }

    public static String printArray(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int i : nums) {
            sb.append(i + ",");
        }
        return sb.toString();
    }

    public static String getRanges(int[] nums, int start, int end) {
        if(nums == null || nums.length == 0) {
            return start + "-" + end;
        }

        int count = start;
        int length = nums.length;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < length; ++i) {
            if(count != nums[i]) {
                getRange(sb, count, nums[i]);
            }
            count = nums[i] + 1;
        }

        if(count != end) {
            getRange(sb, count, end);
        }
        return sb.toString();
    }

    public static void getRange(StringBuilder sb, int count, int cur) {
        if((cur - 1) == count) {
            sb.append(count + ",");
        } else {
            sb.append(count + "-" + (cur - 1) + ",");
        }
    }
}