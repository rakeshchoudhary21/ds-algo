import java.util.Arrays;

public class Knapsack0_1 {

    private static void knapsack(int[] wt,int[] vals, int totalWeight){
        int[][] DP = new int[wt.length+1][totalWeight+1];

        for(int i=1;i<=wt.length;i++) {
            for (int j = 1; j <= totalWeight; j++) {
                if (j < wt[i-1]) DP[i][j] = DP[i - 1][j];
                else DP[i][j] = Math.max(DP[i-1][j], vals[i-1]+DP[i-1][j-wt[i-1]]);
            }
        }

        for(int[] arr: DP) System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int[] wt = {1,2,3};
        int[] val = {10,15,40};
        knapsack(wt,val,6);
    }
}
