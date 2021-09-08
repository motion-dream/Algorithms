package September;

import java.util.Scanner;

/**
 * @author jmm
 * @version 1.0
 * @date 2021/9/6 21:03
 * @email 2867405686@qq.com
 * 0,1 KnapSack
 */
public class KnapSack01 {
    public static void main(String[] args) {
        int N,W;
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextInt();
        W=scanner.nextInt();
        int[] dp=new int[12880];
        for (int i=0;i<N;i++){
            int m=scanner.nextInt();
            int q=scanner.nextInt();
            for (int j=W;j>=m;j--){
                dp[j]=Math.max(dp[j],dp[j-m]+q);
            }
        }
        int max=0;
        for (int i=0;i<W+1;i++){
            if(dp[i]>max){
                max=dp[i];
            }
        }
        System.out.println(max);
    }
}
