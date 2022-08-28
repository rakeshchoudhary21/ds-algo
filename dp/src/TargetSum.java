public class TargetSum {

    //Number of ways to get target by placing + or - in front of each number in given array.
    // easier approach would be : {s1} - {s2} = target and {s1}+{s2} = Sum of Array. then 2S1 = Sum-target, compute this
    //and then the problem becomes number of ways to form given target.
    private static int targetSum(int[] arr,int i, int targetSum,int currSum){
        if(i>=arr.length) {
            if (currSum == targetSum) {
                return 1;
            }
            else return 0;
        }
        return targetSum(arr,i+1,targetSum,currSum+arr[i])+ targetSum(arr,i+1,targetSum,currSum);

    }

    public static void main(String[] args) {
        System.out.println(targetSum(new int[]{1,1,2,3},0,1,0));
        System.out.println(targetSum(new int[]{1,1,1,1,1},0,4,0));
    }
}
