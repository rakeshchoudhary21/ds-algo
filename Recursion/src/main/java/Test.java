import java.util.ArrayDeque;

public class Test {

    public static int houseRobber(int[] items){
        int noRob=0;
        int rob=0;
        for(int item: items){
            int temp = Math.max(noRob+item,rob);
            noRob=rob;
            rob=temp;
        }
        return rob;
    }

    private static int[] slidingWindow(int[] nums,int k){
        int[] res = new int[nums.length+1-k];
        int index=0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            while(!deque.isEmpty() && nums[deque.getLast()]<nums[i])
                deque.removeLast();
            deque.addLast(i);
            if(!deque.isEmpty() && deque.getFirst()<= (i-k)) deque.removeFirst();
            if(i>k-1) res[index++]=nums[deque.getFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] items = {10,2,1,10};
        System.out.println(houseRobber(items));

    }

}
