package August;

import java.util.Scanner;

/**
 * @author jmm
 * @version 1.0
 * @date 2021/8/18 18:01
 * @email 2867405686@qq.com
 */
public class RollTheDice {
    static int Top=0;
    static int Bottom=1;
    static int Left=2;
    static int Right=3;
    static int Front=4;
    static int Back=5;
    public static int[] start_dice={1,6,3,6,2,5};
    public static int[] S(int[] dice){
        return  new int[]{1,6,3,6,2,5};
    }
    public static int[] F(int[] dice){
        int new_Top=dice[Back];
        int new_Bottom=dice[Front];
        int new_Front=dice[Top];
        int new_Back=dice[Bottom];
        dice[Top]=new_Top;
        dice[Bottom]=new_Bottom;
        dice[Front]=new_Front;
        dice[Back]=new_Back;
        return dice;
    }
    public static int[] B(int[] dice){
        int new_Top=dice[Front];
        int new_Bottom=dice[Back];
        int new_Front=dice[Bottom];
        int new_Back=dice[Top];
        dice[Top]=new_Top;
        dice[Bottom]=new_Bottom;
        dice[Front]=new_Front;
        dice[Back]=new_Back;
        return dice;
    }
    public static int[] L(int[] dice){
        int new_Top=dice[Right];
        int new_Bottom=dice[Left];
        int new_Left=dice[Top];
        int new_Right=dice[Bottom];
        dice[Top]=new_Top;
        dice[Bottom]=new_Bottom;
        dice[Left]=new_Left;
        dice[Right]=new_Right;
        return dice;
    }
    public static int[] R(int[] dice){
        int new_Top=dice[Left];
        int new_Bottom=dice[Right];
        int new_Left=dice[Bottom];
        int new_Right=dice[Top];
        dice[Top]=new_Top;
        dice[Bottom]=new_Bottom;
        dice[Left]=new_Left;
        dice[Right]=new_Right;
        return dice;
    }
    public static int[] C(int[] dice){
        int new_Left=dice[Front];
        int new_Right=dice[Back];
        int new_Front=dice[Right];
        int new_Back=dice[Left];
        dice[Left]=new_Left;
        dice[Right]=new_Right;
        dice[Front]=new_Front;
        dice[Back]=new_Back;
        return dice;
     }
    public static int[] D(int[] dice){
        int new_Left=dice[Back];
        int new_Right=dice[Front];
        int new_Front=dice[Left];
        int new_Back=dice[Right];
        dice[Left]=new_Left;
        dice[Right]=new_Right;
        dice[Front]=new_Front;
        dice[Back]=new_Back;
        return dice;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String rotation=scanner.next();
        for (int i=0;i<rotation.length();i++){
            switch (rotation.substring(i,i+1)){
                case "S":{start_dice=S(start_dice);break;}
                case "F":{start_dice=F(start_dice);break;}
                case "B":{start_dice=B(start_dice);break;}
                case "L":{start_dice=L(start_dice);break;}
                case "R":{start_dice=R(start_dice);break;}
                case "C":{start_dice=C(start_dice);break;}
                case "D":{start_dice=D(start_dice);break;}
            }
        }
        System.out.println(start_dice[Front]);
    }
}

/*
       2.
       inputs:  rotation orders
       outputs:  the dice of front face after rotation
       conditions: inputs is right
 */
/*
       3.
                                 Top Bottom Left Right Front Back
         Start              S     1    6     3    4     2     5
         Forward            F     5    2     3    4     1     6
         Backward           B     2    5     3    4     6     1
         Left               L     4    3     1    6     2     5
         Right              R     3    4     6    1     2     5
         Clockwise          C     1    6     2    5     4     3
         Counter-Clockwise  D     1    6     5    2     3     4


 */
/*
        4.
        initialization :  Choose an orientation and roll the dice is right
        maintenance    :  Choose an orientation and roll the dice is right
        termination    :  Choose an orientation and roll the dice is right
        so the arithmetic is right

 */
/*
        5.
         Roll the dice four times as follows： Forward,Backward,Backward,Left
 */