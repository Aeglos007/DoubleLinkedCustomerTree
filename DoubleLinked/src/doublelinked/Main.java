/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublelinked;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Main {
    public static ArrayList tel;//Saves telephone numbers here
    public static LinkedList linkedList = new LinkedList(); 
 
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);       
        int tercih=0; //User selects operation. 
        while(tercih!=5){
         
        System.out.println("Ne yapmak istiyorsunuz\n"
                + "0)Dosyadan musterileri ekleme\n"
                + "1)Elle Musteri ekleme\n"
                + "2)Elle Musteri silme\n"
                + "3)A-Z musterileri listeleme\n"
                + "4)A-Z musterileri listeleme \n"
                + "5)Programi kapat");
        tercih=sc.nextInt();
        sc.nextLine();
        String adSoyad;
        switch (tercih){
            case 0:
                customerList(); //Adding txt file elements
                break;
                
            case 1:
                System.out.println("ad soyad giriniz (Buyuk Harfle baslamaya dikkat ediniz)"); //Adding customers manuelly.
                adSoyad=sc.nextLine();
                System.out.println("adres giriniz");
                String adres=sc.nextLine();
                String tel="0";
                ArrayList teller = new ArrayList();
                              
                while(!tel.equals("q")){ //Adding several telephone number 
                    System.out.println("tel no giriniz\n"
                            + "bittiginde 'q' ya basiniz");
                    tel=sc.nextLine();
                    if(!tel.equals("q")){
                    teller.add(tel);}
                }
                linkedList.insertSorted(new CustomerInfo(adSoyad, adres, teller )); //Creating customers
                break;
                
            case 2:
                System.out.println("Kimi silmek istiyorsunuz? Ad Soyad: "); //Deleting option
                adSoyad=sc.nextLine();
                linkedList.deleteSpecificNode(adSoyad);
                break;
            
            case 3:
                linkedList.displayFrwd(); //A-Z display 
                break;
            
            case 4:
               linkedList.displayBckwrd(); //Z-A display
               break;
        }   
        
        
        }
   }
    static void customerList(){ // Taking customers from txt file and creating new Customers.
        String thisLine = null;
      
      try {
         // open input stream test.txt for reading purpose.
         BufferedReader br = new BufferedReader(new FileReader("customer.txt"));
         
         while ((thisLine = br.readLine()) != null) { 
             tel= new ArrayList();
             String[] satir= thisLine.split(",");
             for (int i = 2; i < satir.length; i++) {
                 tel.add(satir[i]);
             }
             
             
             linkedList.insertSorted(new CustomerInfo(satir[0], satir[1], tel));
             
         }       
      } catch(Exception e) {
        
      }
    }
}
    
    
