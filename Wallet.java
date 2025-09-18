/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingrunning;

/**
 *
 * @author Duong Hoang
 */
public class Wallet {
    
    private int money;

    public Wallet() {
    }

    public Wallet(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    
    
    public void payMoney(int totalBill){
        if(this.money > totalBill){
            
            System.out.println("You can pay it");
        }else{
            System.out.println("You can't pay it");
        }
    }
    
}
