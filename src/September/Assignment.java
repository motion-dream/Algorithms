package September;

import java.util.Scanner;

/**
 * @author jmm
 * @version 1.0
 * @date 2021/9/9 17:56
 * @email 2867405686@qq.com
 */
public class Assignment {
    public static int sum = 0,n;
    public static int [] [] num ;
    public static boolean []  bool;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        num = new int [n+1][n+1];
        bool = new boolean [n+1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=n; j++) {
                num[i][j]=sc.nextInt();
            }
        }
        f(1);
        System.out.println(min);
    }
    public static void f(int a){
        if(a==n+1){
            if(sum<min){
                min=sum;
            }
            return;
        }
        for (int i = 1; i <=n; i++) {
            if(!bool[i]){
                sum+=num[a][i];
                bool[i]=true;
                f(a+1);
                sum-=num[a][i];
                bool[i]=false;
            }
        }
    }
}
