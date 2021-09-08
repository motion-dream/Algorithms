package September;

import java.util.Scanner;

/**
 * @author jmm
 * @version 1.0
 * @date 2021/9/8 10:38
 * @email 2867405686@qq.com
 */
public class KnapSack {
    public static void main(String[] args) {
        int N,W;
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextInt();
        W=scanner.nextInt();
        int[] dp=new int[12880];
        for (int i=0;i<N;i++){
            int m=scanner.nextInt();
            int q=scanner.nextInt();
            for (int j=m;j<=W;j++){
                dp[j]=Math.max(dp[j],dp[j-m]+q);
            }
        }
        System.out.println(dp[W]);
    }
}
