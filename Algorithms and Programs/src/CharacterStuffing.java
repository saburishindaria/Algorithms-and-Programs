/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;

/**
 *
 * @author Acer
 */
class Stuffing {
    

    void charstuff(int n, String[] d, String s, String e) {
        for(int i= 0;i<n;i++)
        {
            if(d[i].equals(s))
            {
                d[i]=s+s;
            }
            if(d[i].equals(e))
            {
                d[i]=e+e;
            }
        }
        System.out.println("Transmitted message is: ");
        System.out.print(s);
        for(int i=0;i<n;i++)
        {
            System.out.print(d[i]+" ");
        }
        System.out.print(e);  
    
        Destuffing df=new Destuffing();
        df.chardestuff(n, d, s, e);
    }
       
}   


class Destuffing{
    public void chardestuff(int n, String[] d, String s, String e){
        for(int i=0;i<n;i++){
            if(d[i].equalsIgnoreCase(s+s)){
                d[i]=s;
            }
            if(d[i].equalsIgnoreCase(e+e)){
                d[i]=e;
            }
        }
        System.out.println("Destuffed data is:\n");
        for(int i=0;i<n;i++)
        {
        System.out.print(d[i]+" ");
        }
    }
}
    
    
  public class CharacterStuffing{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter starting character: ");
        String s=sc.nextLine();
        System.out.println("Enter end character: ");
        String e=sc.nextLine();
        System.out.println("Enter number of characters: ");
        int n=sc.nextInt();
        String d[] = new String[n];
        System.out.println("Enter data: ");
        for(int i=0;i<n;i++)
        {
            d[i]=sc.next();
        }
        Stuffing sf=new Stuffing();
        sf.charstuff(n,d,s,e);
    }
}