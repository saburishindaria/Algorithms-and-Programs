/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */

import java.util.Arrays;
import java.util.Scanner;

public class Probing {
    public static void main(String[] args) {
        System.out.println("Enter Size of table: ");
        Scanner S = new Scanner(System.in);
        int s = S.nextInt();
        System.out.println("Enter number of elements: ");
        int num = S.nextInt();
        System.out.println("1 for Linear Probing" + "\n" +  "2 for Quadratic Probing" + "\n" + "3 for Double Hashing");
        int choice = S.nextInt();
        switch(choice){
            case 1:
                linearProbing(s, num);
                break;
            case 2:
                quadraticProbing(s, num);
                break;
            case 3:
                doubleHashing(s, num);
                break;
        }
    }
    
    static void linearProbing(int s, int num){
        System.out.println(num);
        int[] elem = new int[num];
        int[] collide = new int[num];
        double[] loadF = new double[num];
        int[] temp = new int[s];
        for(int i = 0; i<num; i++){
            int a = (int) (Math.random() * (num - 1) + 1);
            elem[i] = a;
        }
        int j = 0, count = 0, count1 = 0;
        for(int i = 0; i<num; i++){
            int hx = elem[i] % s;
            j = hx;
            count = count1 = 0;
            if(temp[hx] == 0){
                temp[hx] = elem[i];
                for(int k = 0; k<s; k++){
                    if(temp[k] != 0){
                        count1++;
                    }
                }
                loadF[i] = count1/(float)s;
                if(loadF[i] == 1){
                    System.out.println("No more elements can be placed.");
                    break;
                }
                collide[i] = 0;
            }
            else{
                while(temp[j] != 0){
                    j = (j + 1) % (s);
                    count++;
                }
                temp[j] = elem[i];
                for(int k = 0; k<s; k++){
                    if(temp[k] != 0){
                        count1++;
                    }
                }
                loadF[i] = count1/(float)s;
                if(loadF[i] == 1){
                    System.out.println("No more elements can be placed.");
                    break;
                }
                collide[i] = count;
            }
        }
        System.out.println(Arrays.toString(elem));
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(loadF));
        System.out.println(Arrays.toString(collide));
    }
    static void quadraticProbing(int s, int num){
        int[] elem = new int[num];
        int[] collide = new int[num];
        double[] loadF = new double[num];
        int[] table = new int[s];
        for(int i = 0; i<num; i++){
            int a = (int) (Math.random() * (num - 1) + 1);
            elem[i] = a;
        }
        int j = 0, count = 1, i1 = 1, count1 = 0;
        for(int i = 0; i<num; i++){
            int hx = elem[i] % s;
            j = hx;
            count = count1 = 0;
            if(table[hx] == 0){
                table[hx] = elem[i];
                for(int k = 0; k<s; k++){
                    if(table[k] != 0){
                        count1++;
                    }
                }
                loadF[i] = count1/(float)s;
                if(loadF[i] == 1){
                    System.out.println("No more elements can be placed.");
                    break;
                }
                collide[i] = 0;
            }
            else{
                while(table[j] != 0){
                    j = (int) ((j + Math.pow(i1, 2))) % (s);
                    if( j == hx)
                        break;
                    count++;
                    i1++;
                }
                table[j] = elem[i];
                for(int k = 0; k<s; k++){
                    if(table[k] != 0){
                        count1++;
                    }
                }
                loadF[i] = count1/(float)s;
                if(loadF[i] == 1){
                    System.out.println("No more elements can be placed.");
                    break;
                }
                collide[i] = count;
            }
        }
        System.out.println(Arrays.toString(elem));
        System.out.println(Arrays.toString(loadF));
        System.out.println(Arrays.toString(collide));
    }
    static void doubleHashing(int s, int num){
        boolean isPrime = true;
        int temp, prime = 0;
        for(int i = s-1; i>=1; i--){
            for(int j = 2; j <= i/2; j++){
                temp = i % j;
                if(temp==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime == true){
                prime = i;
                break;
            }
        }
        int[] elem = new int[num];
        int[] collide = new int[num];
        double[] loadF = new double[num];
        int[] table = new int[s];
        for(int i = 0; i<num; i++){
            int a = (int) (Math.random() * (num - 1) + 1);
            elem[i] = a;
        }
        int j = 0, count = 1, i1 = 0, count1 = 0;
        for(int i = 0; i<num; i++){
            int hx = elem[i] % s;
            j = hx;
            count = count1 = 0;
            if(table[hx] == 0){
                table[hx] = elem[i];
                for(int k = 0; k<s; k++){
                    if(table[k] != 0){
                        count1++;
                    }
                }
                loadF[i] = count1/(float)s;
                if(loadF[i] == 1){
                    System.out.println("No more elements can be placed.");
                    break;
                }
                collide[i] = 0;
            }
            else{
                while(table[j] != 0){
                    j = ((i1 * (prime - (elem[i] % prime))) + elem[i]) % s;
                    if(i1 > Integer.MAX_VALUE)
                        break;
                    count++;
                    i1++;
                }
                table[j] = elem[i];
                for(int k = 0; k<s; k++){
                    if(table[k] != 0){
                        count1++;
                    }
                }
                loadF[i] = count1/(float)s;
                if(loadF[i] == 1){
                    System.out.println("No more elements can be placed.");
                    break;
                }
                collide[i] = count;
            }
        }
        System.out.println(Arrays.toString(table));
        System.out.println(Arrays.toString(loadF));
        System.out.println(Arrays.toString(collide));
    }
}
