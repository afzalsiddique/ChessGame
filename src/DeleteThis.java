import java.util.ArrayList;

public class DeleteThis {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);
        System.out.println(nums);
        nums.remove(nums.size()-1);
        System.out.println(nums);
    }
}
