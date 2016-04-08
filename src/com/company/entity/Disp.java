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

    public static int[] doNewRouteArray(ArrayList routeTab, ArrayList apdate) {
        int[][] route=new int[(int) Math.sqrt(routeTab.size())][(int) Math.sqrt(routeTab.size())];
        for (int i = 0,k=0; i < route.length; i++) {
            for (int j = 0; j < route.length; j++, k++) {
                route[i][j] = (int) routeTab.get(k);
            }
        }

        int[][] newRoute = new int[route.length + 1][route.length + 1];

        for (int i = 0; i < route.length; i++) {
            for (int j = 0; j < route.length; j++)
                newRoute[i][j] = route[i][j];
        }

        for (int i = 0; i < apdate.size() / 2; i++) {
            newRoute[route.length][i] = (int) apdate.get(i);
        }
        for (int i = (apdate.size() ) / 2, k = 0; i < apdate.size(); i++, k++) {
            newRoute[k][route.length] = (int) apdate.get(i);
        }

        newRoute[route.length][route.length] = 666;
        int dimension = newRoute.length;

        ArrayList <Integer>temp = new ArrayList();
        for (int i = 0; i < newRoute.length; i++) {
            for (int j = 0; j < newRoute.length; j++)
                temp.add(newRoute[i][j]);
        }

        for (int k=0;k <newRoute.length-1;k++){
            //return newRoute;
            Disp.iteration(temp, k,dimension-k);
            toDisp.sortMove(tempRouteDriver);
        }
        tempRouteDriver.add(0);
        tempRouteDriver.add(0);
        toDisp.sortMove(tempRouteDriver);
        toDisp.directionRout(tempRouteDriver);
        int S=toDisp.sumPris(newRoute,tempRouteDriver);
        System.out.println(" ");
        System.out.println("~~~~~~~~~~~~~"+S+"~~~~~~~~~~~~~");


        int []  Route = new int[tempRouteDriver.size()];
        for (int j = 0; j < tempRouteDriver.size(); j++) {
            Route[j] = (int) tempRouteDriver.get(j);
        }

        System.out.println("----------------------");
        for (int i =0; i<tempRouteDriver.size();i++){
            if (i%2==0) System.out.print("  ");
            System.out.print(" "+tempRouteDriver.get(i));
        }
        return Route;
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
                            if (min !=666){
                            zerroArray[zerroCounter][0] = min;
                            zerroArray[zerroCounter][1] = i;
                            zerroArray[zerroCounter][2] = j;//Index;
                            } else {
                                zerroArray[zerroCounter][0] = 0;
                                zerroArray[zerroCounter][1] = i;
                                zerroArray[zerroCounter][2] = j;//Index;
                            }
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
                            if (min !=666)   zerroArray[zerroCounter][0] += min;
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
        tempRouteDriver.add(zerroArray[iIndex][1]);
        tempRouteDriver.add(zerroArray[iIndex][2]);
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



