public class MatrixChainMultiplication {


    private static int mcmTemplate(int[] arr,int i,int j){
        if(i==j) return 0;

        int res = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            res = Math.min(res, mcmTemplate(arr,i,k)+mcmTemplate(arr,k+1,j) + arr[i-1]*arr[k]*arr[j]);
        }
        return res;
    }

    private static int palindromPartitions(String str,int i,int j){
        int res = Integer.MAX_VALUE;
        if(i>=j || isPalindrom(str,i,j)) return 0;
        for(int k=i;k<j;k++){
            res = Math.min(res, 1+ Math.min(palindromPartitions(str,i,k),palindromPartitions(str,k+1,j)));
        }
        return res;
    }

    //fishy. doesnt always work
    private static boolean isPalindrom(String str, int i, int j) {
        if(i==j || i>=str.length() || j<0) return true;
        return str.charAt(i)==str.charAt(j) && isPalindrom(str,i+1,j-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,3};
        System.out.println(mcmTemplate(arr,1,arr.length-1));
        //System.out.println(palindromPartitions("dVGAaVO25EmT6W3zSTEA0k12i64Kkmmli09Kb4fArlF4Gc2PknrlkevhROxUg",0,60));
        System.out.println("dVGAaVO25EmT6W3zSTEA0k12i64Kkmmli09Kb4fArlF4Gc2PknrlkevhROxUg".length());
        System.out.println(isPalindrom("bb",0,1));
    }
}

