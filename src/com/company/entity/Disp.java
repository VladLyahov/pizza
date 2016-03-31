package com.company.entity;

import java.util.ArrayList;

/**
 * Created by govno on 29.03.2016.
 */
public class Disp {
    public ArrayList getTempRouteDriver() {
        return tempRouteDriver;
    }

    public void setTempRouteDriver(ArrayList tempRouteDriver) {
        this.tempRouteDriver = tempRouteDriver;
    }

    public static ArrayList tempRouteDriver = new ArrayList();

    public static void doNewRouteArray(int[][] route, int[] apdate) {
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
        int dimension = newRoute.length;

        ArrayList <Integer>temp = new ArrayList();
        for (int i = 0; i < newRoute.length; i++) {
            for (int j = 0; j < newRoute.length; j++)
                temp.add(newRoute[i][j]);
        }

        for (int k=0;k <3;k++){


            //return newRoute;
            Disp.iteration(temp, k,dimension-k);
            //System.out.println("----------------------");
            //temp.clear();
        }
        System.out.println("----------------------");
        for (int i =0; i<tempRouteDriver.size();i++){
            System.out.print(" "+tempRouteDriver.get(i));
        }


    }

    public static ArrayList iteration (ArrayList temp,int numberOfSteps,int dimension){
        System.out.println("");
        System.out.println("==============="+numberOfSteps+"+++++++++++++");
        int [] [] newRoute = new int[dimension][dimension];

        for (int i = 0,k=0; i < dimension; i++) {
            System.out.println(" ");
            for (int j = 0; j < dimension; j++, k++) {
                newRoute[i][j] = (int) temp.get(k);
                System.out.print(" "+newRoute[i][j]);

            }
        }



        int tempArray[][] = new int[newRoute.length][newRoute.length + 1];



        //int min=newRoute[k][0];

        for (int i = 0, min = 666; i < newRoute.length; i++) {
            for (int j = 0; j < newRoute.length + 1; j++) {
                if (j == newRoute.length) {
                    tempArray[i][newRoute.length] = min;
                    for (int k = 0; k < newRoute.length; k++) {
                        if (newRoute[i][k] != 666) tempArray[i][k] -= min;
                    }
                    min = 666;
                    continue;
                }
                if (newRoute[i][j] < min) min = newRoute[i][j];
                tempArray[i][j] = newRoute[i][j];
            }
        }

        //=======================
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

        System.out.println("tytytytytytt");
        System.out.println(" ");
        System.out.println("chistka");
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
        System.out.println("novii massiv");
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
        tempRouteDriver.add(zerroArray[iIndex][1]*10+zerroArray[iIndex][2]);
        //tempRouteDriver.add(zerroArray[iIndex][2]);

        System.out.println("==================");

        int[][] stepRoute = new int[newRoute.length-1][newRoute.length+1];

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
        System.out.println(" ");
        System.out.println("step step step step step step step step step ");

        //ArrayList <Integer>temp = new ArrayList();
        temp.clear();

        for (int i = 0; i < newRoute.length-1; i++) {
            for (int j = 0; j < newRoute.length-1; j++)
                temp.add(stepRoute[i][j]);
        }
        return temp;



    }

}



