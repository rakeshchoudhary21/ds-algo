public class SubsetSum {


    private static boolean subsetSum(int[] arr,int sum,int index){

        if(sum==0) return true;
        if(index>=arr.length) return false;

        return subsetSum(arr,sum-arr[index],index+1) || subsetSum(arr,sum,index+1);
    }

    private static boolean subsetSumDP(int[] arr,int sum){
        boolean[][] DP = new boolean[arr.length+1][sum+1];
        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j) DP[i][j]=DP[i-1][j];
                else DP[i][j] = (arr[i-1] == j) || DP[i-1][j-arr[i-1]];
            }
        }
        return DP[arr.length][sum];
    }

    public static void main(String[] args) {
        int[] arr = {3,5,6};
        System.out.println(subsetSum(arr,14,0));
        System.out.println(subsetSumDP(arr,4));
    }

}
