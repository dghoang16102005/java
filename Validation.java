/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jd55;

import java.util.Scanner;

/**
 *
 * @author Duong Hoang
 */
public class Validation {
    
    
    public static int getInteger(String msg, int min, int max) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String inputInt = scan.nextLine().trim();
            try {
                int convertInt = Integer.parseInt(inputInt);
                
                if(convertInt < min || convertInt > max){
                    System.out.println("Plase value input only from " + min +" to " + max);
                    
                }else{
                    return convertInt;
                }
                
                
            } catch (NumberFormatException e) {
                System.out.println("Sai định dạng. Vui lòng nhập lại!");
            }
        }
    }
    
    public static String getString(String msg){
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String inputString = scan.nextLine().trim();
            
            if(!(inputString.isEmpty())){
                return  inputString;
            }else{
                System.out.println("Please input again, value not null");
                continue;
            }
        }
        
    }
   
    
}
