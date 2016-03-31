package com.company.entity;

import java.util.ArrayList;

/**
 * Created by govno on 27.03.2016.
 */
public class Dispatcher {

    public static void doNewRoute(int[][] route, int []apdate) {

        int[][] newRoute = new int[route.length + 1][route.length + 1];

        for (int i = 0; i < route.length; i++) {
            for (int j = 0; j < route.length; j++)
                newRoute[i][j] = route[i][j];
        }

        for (int i = 0; i < apdate.length / 2; i++) {
            newRoute[route.length][i] = apdate[i];
        }
        for (int i = (apdate.length + 1) / 2, k = 0; i < apdate.length; i++, k++) {
            newRoute[k][route.length] = apdate[i];
        }

        newRoute[route.length][route.length] = 666;


        System.out.println(" ");
        System.out.println("novii massiv");
        for (int i = 0; i < newRoute.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < newRoute.length; j++)
                System.out.print(newRoute[i][j] + " ");
        }

        ArrayList temp = new ArrayList();
//        int restructuringRoute [][] =new int[newRoute.length][newRoute.length];
        for (int i = 0; i < newRoute.length; i++) {
            for (int j = 0; j < newRoute.length; j++)
                temp.add(newRoute[i][j]);
        }
       int stepCounter=newRoute.length;

        for (int step = 0; step < stepCounter; step++) {
//            if (step!=0){
//                newRoute=null;
//
//                for (int i = 0,k=0; i < stepCounter; i++) {
//                    for (int j = 0; j < stepCounter; j++, k++) {
//                        newRoute[i][j]= (int) temp.get(k);
//                    }
//                }
//                temp.clear();
//
//            }

            System.out.println(" ");
            System.out.println(step + " stage 1-2");
            System.out.println(" ");
            int tempArray[][] = new int[newRoute.length - step][newRoute.length + 1 - step];



//            for (int i = 0,l=0, min = 666; i < newRoute.length - step; i++,l++) {
//                for (int j = 0; j < newRoute.length + 1 - step; j++,l++) {
//                    if (j == newRoute.length - step) {
//                        tempArray[i][newRoute.length - step] = min;
//                        for (int k = 0; k < newRoute.length - step; k++) {
//                            if (newRoute[i][k] != 666) tempArray[i][k] -= min;
//                            System.out.print(" "+tempArray[i][k]);
//                        }
//                        System.out.println(" "+tempArray[i][newRoute.length - step]);
//                        l--;
//                        min = 666;
//                        continue;
//                    }
//                    if ((int) temp.get(l) < min) min = (int) temp.get(l);
//                    tempArray[i][j] = (int) temp.get(l);
//                }
//            }

            for (int i = 0; i < newRoute.length - step; i++) {
                System.out.println(" ");
                for (int j = 0; j < newRoute.length + 1 - step; j++)
                    System.out.print(tempArray[i][j] + " ");
            }
            System.out.println(step + " stage 3-4");

            int tempLineArray[][] = new int[newRoute.length + 1][newRoute.length];

            for (int i = 0, min = 666; i < newRoute.length; i++) {
                for (int j = 0; j < newRoute.length + 1; j++) {
                    if (j == newRoute.length) {
                        tempLineArray[newRoute.length][i] = min;
                        for (int k = 0; k < newRoute.length; k++) {
                            if (newRoute[i][k] != 666) tempLineArray[k][i] -= min;
                        }
                        min = 666;
                        continue;
                    }
                    if (tempArray[j][i] < min) min = tempArray[j][i];
                    tempLineArray[j][i] = tempArray[j][i];
                }
            }
            System.out.println(" ");
            System.out.println("novii massiv");
            for (int i = 0; i < newRoute.length + 1; i++) {
                System.out.println(" ");
                for (int j = 0; j < newRoute.length; j++)
                    System.out.print(tempLineArray[i][j] + " ");
            }


            System.out.println(" ");
            System.out.println("chistka");
            System.out.println(step + " stage 5-6");

            int zerroCounter = 0;

            for (int i = 0; i < newRoute.length; i++) {
                for (int j = 0; j < newRoute.length; j++)
                    if (tempLineArray[i][j] == 0) zerroCounter++;
            }

            int zerroArray[][] = new int[zerroCounter][3];
            zerroCounter = 0;

            for (int i = 0, min = 666; i < newRoute.length; i++) {
                for (int j = 0, jIndex = 0; j < newRoute.length; j++) {

                    if (tempLineArray[i][j] == 0) {
                        for (int k = 0; k < newRoute.length + 1; k++) {
                            if (k == newRoute.length) {
                                zerroArray[zerroCounter][0] = min;
                                zerroArray[zerroCounter][1] = i;
                                zerroArray[zerroCounter][2] = jIndex;
                                zerroCounter++;
                                min = 666;
                                continue;
                            }
                            if (tempLineArray[i][k] < min && k != j) {
                                min = tempLineArray[i][k];
                                jIndex = j;
                            }
                        }
                    }
                }
            }
            zerroCounter = 0;
            for (int i = 0, min = 666; i < newRoute.length; i++) {
                for (int j = 0; j < newRoute.length; j++) {

                    if (tempLineArray[i][j] == 0) {
                        for (int k = 0; k < newRoute.length + 1; k++) {
                            if (k == newRoute.length) {
                                zerroArray[zerroCounter][0] += min;
                                zerroCounter++;
                                min = 666;
                                continue;
                            }
                            if (tempLineArray[k][j] < min && k != i) {
                                min = tempLineArray[k][j];
                            }
                        }
                    }
                }
            }
            System.out.println(" ");
            System.out.println(step + " stage 7");
            for (int i = 0; i < zerroArray.length; i++) {
                System.out.println(" ");
                for (int j = 0; j < 3; j++)
                    System.out.print(zerroArray[i][j] + " ");
            }

            int iIndex = 0;
            for (int i = 0, max = zerroArray[0][0]; i < zerroArray.length; i++) {
                if (zerroArray[i][0] > max) {
                    max = zerroArray[i][0];
                    iIndex = i;
                }
            }

            System.out.println(iIndex);
            System.out.println(step + " stage 8-9");

            int[][] stepRoute = new int[route.length][route.length];

            for (int i = 0, k = 0; i < newRoute.length; i++, k++) {
                System.out.println(" ");
                if (i == zerroArray[iIndex][1]) {
                    --k;
                    continue;
                }
                for (int j = 0, l = 0; j < newRoute.length; j++, l++) {
                    if (j == zerroArray[iIndex][2]) {
                        --l;
                        continue;
                    }
                    if (j == zerroArray[iIndex][1] && i == zerroArray[iIndex][2]) stepRoute[k][l] = 666;
                    else stepRoute[k][l] = tempLineArray[i][j];
                    System.out.print(stepRoute[k][l] + " ");
                }
            }

            temp.clear();
            for (int i=0;i<newRoute.length-1;i++){
                for (int j=0;j<newRoute.length-1;j++){
                    temp.add(stepRoute[i][j]);
                }
            }

            String tempSTR = "";
            for (int i = 0; i < temp.size(); i++) {
                tempSTR = tempSTR+ temp.get(i) + " ";
            }
            System.out.println("Все коты: " + tempSTR);


            newRoute = null;
            //int newRoute [] [] = new int[3][3];


            System.out.println("=====================end " + step + " step=================");
//        System.out.println("step massiv");
//        for (int i = 0; i <stepRoute.length; i++) {
//            System.out.println(" ");
//            for (int j = 0; j < stepRoute.length; j++)
//                System.out.print(stepRoute[i][j] + " ");
//        }


        }
    }


}
