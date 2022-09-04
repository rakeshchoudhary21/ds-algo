import java.util.ArrayList;
import java.util.List;

public class AllRecursion {

    //also called subsequence problem, or powerset
    private static void allSubsets(String input,String output){
        if(input.length()==0) {
            System.out.println(""+output);
            return;
        }
        
        allSubsets(input.substring(1),output+ input.charAt(0));
        allSubsets(input.substring(1),output);

    }

    private static void print1ToN(int n){
        if(n>1) print1ToN(n-1);
        System.out.println(n);
    }

    private static void printNto1(int n){
        if(n==0) return;
        System.out.println(n);
        print1ToN(n-1);
    }

    private static void permutation(String input,String output){
        if(input.length()==0){
            System.out.println(output);
            return;
        }
        for(int i=0;i<input.length();i++){
            char curr = input.charAt(i);
            String rest = input.substring(0,i)+ input.substring(i+1);
            permutation(rest,output+curr);
        }
    }

    private static void reverse(String input,String output){
        if(input.length()==0) {
            System.out.println(output);
            return;
        }
        reverse(input.substring(0,input.length()-1),output+input.charAt(input.length()-1));
    }

    private static void sort(String input,StringBuffer sorted){
        if(input.length()==0){
            return;
        }

        char curr = input.charAt(0);
        sort(input.substring(1),sorted);
        insert(sorted,curr);
    }

    private static void insert(StringBuffer sorted, char c){
        if(sorted.length()==0 || sorted.charAt(sorted.length()-1)<c) {
            sorted.append(c);
            return;
        }

        char last = sorted.charAt(sorted.length()-1);
        sorted.deleteCharAt(sorted.length()-1);
        insert(sorted,c);
        sorted.append(last);
    }

    private static void allSubstrings(String input){
        for(int i=0;i<input.length();i++){
            String part_1 = input.substring(0,i);
            String part_2 = input.substring(i);
            System.out.println(part_1);
            System.out.println(part_2);
        }

    }

    //Permuations with underscores: can also be asked with spaces or pipe etc
    private static void spaceBetween(String input,String res){
        if(input.length()==0) {
            System.out.println(res);
            return;
        }

        if(res.length()==0) {
            input=input.substring(1);
            spaceBetween(input,res+input.charAt(0));
        }
        else{
            String res1=res+"_"+input.charAt(0);
            String res2=res+input.charAt(0);
            input=input.substring(1);
            spaceBetween(input,res1);
            spaceBetween(input,res2);

        }
    }

    private static void permuteWithCaseChange(String input,String output){
        if(input.length()==0) {
            System.out.println(output);
            return;
        }
        String res1 = output+Character.toUpperCase(input.charAt(0));
        String res2 = output+Character.toLowerCase(input.charAt(0));
        input=input.substring(1);
        permuteWithCaseChange(input,res1);
        permuteWithCaseChange(input,res2);
    }

    private static void generateBalancedParanthesis(String output,int open,int close){
        if(open==0 && close==0){
            System.out.println(output);
            return;
        }
        if(open>0) generateBalancedParanthesis(output+"(",open-1,close);
        if(close>open)generateBalancedParanthesis(output+")",open,close-1);
    }


    private static void prefixWithMore1sThan0s(String out, int ones,int zeros,int N){
        if(out.length()==N){
            System.out.println(out);
            return;
        }
        if(ones<N) prefixWithMore1sThan0s(out+"1",ones+1,zeros,N);
        if(zeros<ones) prefixWithMore1sThan0s(out+"0",ones,zeros+1,N);

    }

    private static void josephus(int N,int k, int last, List<Integer> man){
        if(man.size()==1) {
            System.out.println(man);
            return;
        }
        last = (last+k-1) % man.size();
        man.remove(last);
        josephus(N-1,k,last,man);
    }

    private static int kthSymbol(int n,int k){
        if(k==1 || n==1) return 0;
        int mid = (int) Math.pow(2,n-1)/2;
        if(k<=mid) return kthSymbol(n-1,k);
        else return kthSymbol(n-1,k-mid)==0?1:0;
    }

    private static boolean regexMatch(String str,String pattern){
        if(pattern.length()==0) return str.length()==0;
        boolean match=false;
        if(str.length()>0)
            match = str.charAt(0)==pattern.charAt(0) || pattern.charAt(0)=='.';
        if(pattern.length()>=2)
            return regexMatch(str,pattern.substring(2)) || (match && regexMatch(str.substring(1),pattern));
        return match && regexMatch(str.substring(1),pattern.substring(1));
    }

    //zero-one knapsack
    private static int knapsack0_1(int[] wt,int[] vals,int i, int totalWeight){
        if(totalWeight==0 || i==wt.length) return 0;

        if(wt[i]>totalWeight) return knapsack0_1(wt,vals,i+1,totalWeight);
        else return Math.max(vals[i]+knapsack0_1(wt,vals,i+1,totalWeight-wt[i]),knapsack0_1(wt,vals,i+1,totalWeight));

    }

    //unbounded knapsack
    private static int knapsackUnbounded(int[] wt,int[] vals,int i, int totalWeight){
        if(totalWeight==0 || i==wt.length) return 0;

        if(wt[i]>totalWeight) return knapsackUnbounded(wt,vals,i+1,totalWeight);
        else return Math.max(vals[i]+Math.max(knapsackUnbounded(wt,vals,i+1,totalWeight-wt[i]),
                knapsackUnbounded(wt,vals,i,totalWeight-wt[i])),knapsackUnbounded(wt,vals,i+1,totalWeight));

    }

    private static int rodCutting(int[] wt,int[] vals,int i, int totalWeight){
        if(totalWeight==0 || i==wt.length) return 0;

        if(wt[i]>totalWeight) return rodCutting(wt,vals,i+1,totalWeight);
        else return Math.max(vals[i]+Math.max(rodCutting(wt,vals,i+1,totalWeight-wt[i]),
                rodCutting(wt,vals,i,totalWeight-wt[i])),rodCutting(wt,vals,i+1,totalWeight));

    }

    private static int coinChangeMaxWays(int[] coins, int i, int targetChange,int currentChange){
        if (currentChange == targetChange) {
            return 1;
        }
        if(i>=coins.length) return 0;

        if(coins[i]>targetChange || currentChange>targetChange) return coinChangeMaxWays(coins,i+1,targetChange,currentChange);
        return Math.max(coinChangeMaxWays(coins,i+1,targetChange,currentChange+coins[i])
                ,coinChangeMaxWays(coins,i,targetChange,currentChange+coins[i]))+coinChangeMaxWays(coins,i+1,targetChange,currentChange);
    }

    //bounded knapsack
    private static int minCoins(int[] coins,int i, int targetChange){
        if(targetChange==0) return 0;
        if(i>=coins.length) return Integer.MAX_VALUE;

        if(coins[i]<=targetChange) {
            int with = minCoins(coins,i+1,targetChange-coins[i]);
            int without = minCoins(coins,i+1,targetChange);
            if(with!=Integer.MAX_VALUE) with+=1;
            return Math.min(with,without);
        } else return Integer.MAX_VALUE;
    }

    private static int minCoinsUnbounded(int[] coins,int i, int targetChange){
        if(targetChange==0) return 0;
        if(i>=coins.length) return Integer.MAX_VALUE;

        if(coins[i]<=targetChange) {
            int with = minCoinsUnbounded(coins,i+1,targetChange-coins[i]);
            int withUnbounded = minCoinsUnbounded(coins,i,targetChange-coins[i]);
            int without = minCoinsUnbounded(coins,i+1,targetChange);
            if(with!=Integer.MAX_VALUE) with+=1;
            if(withUnbounded!=Integer.MAX_VALUE) withUnbounded+=1;
            return Math.min(with,Math.min(withUnbounded,without));
        } else return Integer.MAX_VALUE;
    }

    private static int longestSubsequence(String str,String pattern,int m,int n){
        if(m==str.length() || n==pattern.length()) return 0;

        if(str.charAt(m)== pattern.charAt(n)) return 1 + longestSubsequence(str,pattern,m+1,n+1);
        else return Math.max(longestSubsequence(str,pattern,m+1,n), longestSubsequence(str,pattern,m,n+1));
    }

    private static int longestCommonSubstring(String str, String pattern, int m, int n,int count){
        if(m==str.length()|| n==pattern.length()) return count;
        if(str.charAt(m) == pattern.charAt(n)) return longestCommonSubstring(str,pattern,m+1,n+1,count+1);
        else return Math.max(count, Math.max(longestCommonSubstring(str,pattern,m+1,n,0),longestCommonSubstring(str,pattern,m,n+1,0)));
    }

    private static int shortestCommonSuperSeq(String a,String b){
        //a.length + b.length - longestSubsequence(a,b,a.length,b.length) // think
        return a.length()+b.length() - longestSubsequence(a,b,a.length(),b.length());
    }

    private static int minAddDeleteToConvertAtoB(String a,String b){
        //delete = a.length - lcs(a,b)
        //insert = b.length - lcs(a,b)
        return -1;
    }

    private static int longestPalindromincSuseq(String a){
        String b = new StringBuffer(a).reverse().toString();
        return longestSubsequence(a,b,a.length(),b.length());
    }

    //Same solution can be used to tell number of inserts to make it a palindrom.
    private static int minDeleteToMakePalindrom(String a){
        return a.length() - longestPalindromincSuseq(a);
    }

    private static int longestRepeatingSubseq(String a){
        //take LCS on same string and just add one extra condition that i!=j
        return longestRepeatingSubseq(a,a,0,0);
    }

    private static int longestRepeatingSubseq(String a,String b,int i,int j){
        if(i==a.length() || j==b.length()) return 0;
        if(a.charAt(i) == b.charAt(j) && (i!=j)) return 1+ longestRepeatingSubseq(a,b,i+1,j+1);
        else return Math.max(longestRepeatingSubseq(a,b,i+1,j),longestRepeatingSubseq(a,b,i,j+1));
    }

    public static void main(String[] args) {
        allSubsets("abc","");
        print1ToN(2);
        printNto1(2);
        permutation("123","");
        reverse("abcde","");
        StringBuffer res = new StringBuffer();
        sort("ghacbefd",res);
        System.out.println(res);
        allSubstrings("abc");
        System.out.println("Lets see spaces");
        spaceBetween("abc","");
        permuteWithCaseChange("abc","");
        generateBalancedParanthesis("",3,3);
        prefixWithMore1sThan0s("",0,0,4);
        List<Integer> men = new ArrayList<>();
        for(int i=1;i<=40;i++) men.add(i);
        josephus(40,7,0,men);
        System.out.println(kthSymbol(3,4));
        System.out.println(regexMatch("aa","a*"));
        int[] wt = {10,40,20};
        int[] val = {25,95,60};

        System.out.println(knapsack0_1(wt,val,0,40));
        System.out.println(knapsackUnbounded(new int[]{1, 3, 4, 5},new int[]{10, 40, 50, 70},0,8));
        int W = 100;
        int val2[] = { 10, 30, 20 };
        int wt2[] = { 5, 10, 15 };
        System.out.println(knapsackUnbounded(wt2,val2,0,W));
        int prices[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int lengths[] = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(rodCutting(lengths,prices,0, prices.length));

        System.out.println(coinChangeMaxWays(new int[]{1,2},0,5,0));
        System.out.println(minCoins(new int[]{1,2,6},0,5));
        System.out.println(minCoinsUnbounded(new int[]{1,6},0,5));
        System.out.println(longestSubsequence("abcdefgh","acg",0,0));
        System.out.println(longestCommonSubstring("abcdefgh","gh",0,0,0));

        System.out.println(longestRepeatingSubseq("ABCDE"));
    }

}
