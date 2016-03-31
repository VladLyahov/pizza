package com.company;

import com.company.entity.Disp;
import com.company.entity.Dispatcher;
import com.company.entity.Dispatcher2;

public class Main {

    public static void main(String[] args) {
//        Dispatcher.doNewRoute(new int[][]{{666,1,6},{6,666,2},{6,6,666}}, new int[]{3, 6, 6,6,6,3});
        //Dispatcher2.doNewRoute(new int[][]{{666,5,11},{10,666,8},{7,14,666}}, new int[]{12, 6, 15,9,7,8});
        Disp.doNewRouteArray(new int[][]{{666,5,11},{10,666,8},{7,14,666}}, new int[]{12, 6, 15,9,7,8});
	// write your code here
    }
}
