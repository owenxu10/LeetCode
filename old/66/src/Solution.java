import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        boolean addOne = false;
        int add = 1;
        int[] result;
        for (int index = digits.length - 1; index >= 0; index--) {
            if (index == digits.length - 1) {
                digits[index] = digits[index] + 1;
            } else {
                if (addOne == true) {
                    digits[index] = digits[index] + add;
                }
            }
            if (digits[index] > 9) {
                addOne = true;
                digits[index] = digits[index] % 10;
            }
            else{
                addOne = false;
            }
        }


        if (addOne == true) {
            result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
        } else {
            result = digits;
        }

        return result;
    }

    public static void main(String args[]) {

        Solution solution = new Solution();
        int[] nums = {2,9};
        System.out.println(Arrays.toString(solution.plusOne(nums)));
    }
}