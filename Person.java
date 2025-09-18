/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingrunning;

/**
 *
 * @author Duong Hoang
 */
public class Person {
    private Wallet wallet;
    private int[] bills;
    private int totalMoneyBuy;
    
    public Person(int walletAmount, int[] bills, int totalMoneyBuy) {
      
        this.wallet = new Wallet(walletAmount);
        this.bills = bills;
        this.totalMoneyBuy = totalMoneyBuy;
    }
    
    public int getWalletAmonut(){
        return  this.wallet.getMoney();
    }
    public void setWalletAmonut(int money){
         this.wallet.setMoney(money);
    }
    public Wallet getWallet(){
        return this.wallet;
    }
    
    public int[] getBills() {
        return bills;
    }
    
    
     public int calcTotal() {
        int totalMoneyBill = 0;
       
        for (int bill : this.bills) {
            totalMoneyBill += bill;
        }
        this.totalMoneyBuy = totalMoneyBill;
        return totalMoneyBill;
    }

    public int getTotalMoneyBuy() {
        return totalMoneyBuy;
    }

    public void setTotalMoneyBuy(int totalMoneyBuy) {
        this.totalMoneyBuy = totalMoneyBuy;
    }
     
    
    
    
    
}
