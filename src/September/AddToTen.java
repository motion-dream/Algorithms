package September;


import java.util.Scanner;

/**
 * @author jmm
 * @version 1.0
 * @date 2021/9/16 19:24
 * @email 2867405686@qq.com
 */
public class AddToTen {
    static int[] ints=new int[1000];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int j=0;
        for (int i=0;i<s.length();i++,j++){
            ints[j]=new Integer(s.substring(i,i+1));
            i++;
        }
        int m=0;
        for(int i=0;i<j;i++){
            int sum=0;
            sum+=ints[i];
            for( int n=i+1;n<j;n++){
                sum += ints[n];
                if(sum==10){
                    m++;
                    break;
                }
            }
        }
        System.out.println(m);
    }
}
