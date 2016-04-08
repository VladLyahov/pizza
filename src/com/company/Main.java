package com.company;

import com.company.entity.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        Dispatcher.doNewRoute(new int[][]{{666,1,6},{6,666,2},{6,6,666}}, new int[]{3, 6, 6,6,6,3});
        //Dispatcher2.doNewRoute(new int[][]{{666,5,11},{10,666,8},{7,14,666}}, new int[]{12, 6, 15,9,7,8});

        //Bakery.toByte("ggg");
//        String str = "11 34 3 45 23 5 67";
//
//        int[] numArr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
//        for (int i =0; i<numArr.length;i++){
//            //if (i%2==0) System.out.print("  ");
//            System.out.print(" "+numArr[i]);
//        }
        //Main.lis("10 56 -93 88 56 98");

       // MoveNew.eMove(MoveNew.doNewArray(new int[]{3, 1, 1, 1, 0, 0}));
        //MoveNew.sortMove(new int[]{3, 1, 1, 1,1 , 2});
//        String s= "15 rv";
//        int a = (int) Integer.parseInt(s.replaceAll("[\\D]", ""));
//        int b =7;
//        b = Metod.sss(b);
//        System.out.println(a-b);


       int [] AAA = Disp.doNewRouteArray(new int[][]{{666,5,11},{10,666,8},{7,14,666}}, new int[]{12, 6, 15,9,7,8});
      // int [] AAA = Disp.doNewRouteArray(new int[][]{{666,1},{666,666}},new int[]{3,666,666,2});
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
        for (int i = 0; i <AAA.length ; i++) {
            System.out.print(" "+AAA[i]);
        }
        // write your code here
    }
    public static  void lis (String str){
        int[] numArr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i =0; i<numArr.length;i++){
            //if (i%2==0) System.out.print("  ");
            System.out.print(" "+numArr[i]);
        }
    }
}
