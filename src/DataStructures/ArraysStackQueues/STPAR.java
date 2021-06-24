package DataStructures.ArraysStackQueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

//Problem Statement
//https://www.spoj.com/problems/STPAR/


public class STPAR {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int n = in.nextInt();
        while (n != 0) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            Stack<Integer> wait = new Stack<Integer>();
//
//        System.out.println("n: "+n);
//        System.out.println("arr size: "+arr.length);

            boolean pos = false;
            int i = 1, j = 0;
            while (j < n) {

//            System.out.println("-----------------");
//            System.out.println("j: "+j);
//            System.out.println("i: "+i);
//
//            System.out.println("-----------------");
                if (arr[j] == i) {
                    i++;
                } else {
                    if (!wait.isEmpty() && wait.peek() == i) {
                        wait.pop();
                        i++;
                        j--;
                    } else {
                        wait.push(arr[j]);
                    }
                }
                j++;
//            if(!wait.isEmpty()) {
//                System.out.println("wait: " + wait.peek());
//            }

            }
//        System.out.println("i: "+i);
//        System.out.println("loop END");
            if (i <= n && !wait.isEmpty()) {

                while (!wait.isEmpty()) {
                    if (wait.pop() != i) {
                        break;
                    }
                    i++;
                }
            }
            if (i == n + 1) {
                pos = true;
            }


            if (pos) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

            n = in.nextInt();

        }

    }

}
