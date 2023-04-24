import java.util.ArrayList;
import java.util.Objects;

class Solution {
    public int findRepeatNumber(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (Objects.equals(nums.get(i), nums.get(j))){
                    return nums.get(i);
                }
            }
        }
        return 0;
    }
}