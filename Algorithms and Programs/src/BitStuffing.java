/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
class Stuffing1{
    String data;
    Stuffing1(String data){
      this.data=data;
  }
    void stuff() {
        String ori=data;
        if(data.contains("11111")){
            data=data.replace("11111","111101");
        }
        System.out.println("Transmitted message is:\n");
        System.out.print("01111110");
        System.out.print(" "+data+" ");
        System.out.print("01111110");  
    
        DeStuffing df=new DeStuffing(data,ori);
        df.deStuff();
    }
}
class DeStuffing{
    String data1,ori;
    DeStuffing(String data,String ori){
    data1=data;
    this.ori=ori;
}
    public void deStuff(){
        if(ori.contains("11111")){
            data1=data1.replace("111101","11111");
        }
        System.out.println("\n"+"\n");
        System.out.println("\nThe recieved data is:\n");
        System.out.println(ori);
    }
}
    
    
  public class BitStuffing{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data: ");
        String data=sc.nextLine();
        Stuffing1 sf=new Stuffing1(data);
        sf.stuff();
    }
}

