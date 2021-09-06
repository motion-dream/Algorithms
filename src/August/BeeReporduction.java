package August;

import java.util.Scanner;

/**
 * @author jmm
 * @version 1.0
 * @date 2021/8/18 19:43
 * @email 2867405686@qq.com
 */
public class BeeReporduction {
    /*
    1 0   1       2
    1  1  2     4
    1   2  4    7
    1  4   7    12
    1  7   12   20
    1  12  20   33
     */
    static int Queen=1;
    static int Soldier=0;
    static int Worker=1;
    static int[] bees=new int[1000];
    //arithmetic one
    static void reproduce(){
        int last_Queen=Queen;
        int last_Soldier=Soldier;
        int last_Worker=Worker;
        Soldier=last_Worker;
        Worker=last_Soldier+last_Worker+last_Queen;
    }
    //arithmetic two
    static void reproduce(int year){
        for (int i=1;i<=year;i++){
            if (i==1){
                bees[i]=4;
            }else {
                bees[i]=bees[i-1]+bees[i-2]+1;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int year=scanner.nextInt();
        //arithmetic one
        for (int i=0;i<year;i++){
            reproduce();
        }
        System.out.println("arithmetic one:the bees is   "+(Queen+Soldier+Worker));
        //arithmetic two
        bees[0]=2;
        reproduce(year);
        System.out.println("arithmetic two:the bees is   "+bees[year]);
    }
}
/*
    inputs     :  year
    outputs    :  bees  numbers
    conditions :  if(year==1) bees[year] = 4
                  else         bees[year]=bees[year-1]+bees[year-2]+1
 */
/*
     year      bees
      0          2
      1          4
      2          7
      '''
      year      bees[year]=bees[year-1]+bees[year-2]+1
 */
/*
        initialization :   bees[2]=bees[1]+bees[0]  == bees[year]=bees[year-1]+bees[year-2]+1
        maintenance    :   bees[year]=bees[year-1]+bees[year-2]+1
        termination    :   bees[year+1]=bees[year]+bees[year-1]+1
        so the arithmetic is right
 */
/*
        The total number of bees in the fourth year
 */
/*
        the time complexity of your algorithm is O(n)
 */