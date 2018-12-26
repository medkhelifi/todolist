package com.medkhelifi.tutorials.todolist.util.applications;

import antlr.collections.List;
import org.h2.command.dml.Set;

import java.util.Map;
import java.util.Scanner;

interface A extends List, Map {

}
public class Temperature {

    static double closestToZero(double[] ts) {
        if (ts.length == 0) return 0;

        double closest = ts[0];
        for (double i : ts) {
            double abs = Math.abs(i);
            double absClosest = Math.abs(closest);
            if (abs < absClosest) {
                closest = i;
            } else if (abs == absClosest && closest < 0) {
                closest = i;
            }
        }
        return closest;
    }

    public static void main (String [] args){
        int p = 5; int j = 2;
        System.out.println(p/j);

        int K =0;
        System.out.println(K++);

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int data = 0;
        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            if(Math.abs(data) == Math.abs(temp)) data = Math.abs(data);
            else if(data ==0 || (Math.abs(temp) < Math.abs(data))) data = temp;
        }
        System.out.println(data);

    }
}
