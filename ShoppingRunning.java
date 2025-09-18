/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shoppingrunning;

import java.util.Scanner;

/**
 *
 * @author Duong Hoang
 */
public class ShoppingRunning {
    int[] billingLoop;
    
    
    public int getInteger(String msg, int min, int max) {
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
    
    public int[] loopInputBill(int loopNumber){
        billingLoop = new int[loopNumber];
        
        for(int i=0;i<loopNumber;i++){
            String println = "input bill " +( i +1) +": " ;
            billingLoop[i] = getInteger(println, 0, Integer.MAX_VALUE);
            
        }
        return billingLoop;
    }
    
    
    
    public static void main(String[] args) {
        ShoppingRunning running = new ShoppingRunning();
        System.out.println("====== shopping progaming ======");
        int totalBilling = running.getInteger("Please input total bill: ", 1, Integer.MAX_VALUE);
        int[] bills = running.loopInputBill(totalBilling);
        int moneyWallet = running.getInteger("Please enter money in walllet: ", 0, Integer.MAX_VALUE);
        Person person = new Person(moneyWallet, bills, 0);
        
        int totalMoneyOfBill =person.calcTotal();
        
        person.setTotalMoneyBuy(totalMoneyOfBill);
        
        System.out.println("Total of bill: " +totalMoneyOfBill);
        
        person.getWallet().payMoney(person.getTotalMoneyBuy());
    }
    
}
